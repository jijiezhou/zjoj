package com.zjj.zjojcodesandbox;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.StrUtil;
import cn.hutool.dfa.WordTree;
import com.zjj.zjojcodesandbox.model.ExecuteCodeRequest;
import com.zjj.zjojcodesandbox.model.ExecuteCodeResponse;
import com.zjj.zjojcodesandbox.model.ExecuteMessage;
import com.zjj.zjojcodesandbox.model.JudgeInfo;
import com.zjj.zjojcodesandbox.utils.ProcessUtils;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname JavaCodeSandboxTemplate
 * @Description TODO
 * @Author zjj
 * @Date 2/1/24 4:42 PM
 */
public abstract class JavaCodeSandboxTemplate implements CodeSandbox {
    private static final String GLOBAL_CODE_DIR_NAME = "tmpCode";

    private static final String GLOBAL_JAVA_CLASS_NAME = "Main.java";

    private static final String SECURITY_MANAGER_PATH = "/Users/zj/projects/zjoj/zjoj-code-sandbox/src/main/resources/security";

    private static final String SECURITY_MANAGER_CLASS_NAME = "MySecurityManager";

    private static final long TIME_OUT = 5000L;

    /**
     * Step1: User code to File
     *
     * @return
     * @Param user code
     */
    public File saveCodeToFile(String code) {
        String userDir = System.getProperty("user.dir");
        String globalCodePathName = userDir + File.separator + GLOBAL_CODE_DIR_NAME;
        //1) usercode -> file
        //1.1) check if global file directory exist
        if (!FileUtil.exist(globalCodePathName)) {
            FileUtil.mkdir(globalCodePathName);
        }

        //1.2)separate user code
        String userCodeParentPath = globalCodePathName + File.separator + UUID.randomUUID();
        String userCodePath = userCodeParentPath + File.separator + GLOBAL_JAVA_CLASS_NAME;
        File userCodeFile = FileUtil.writeString(code, userCodePath, StandardCharsets.UTF_8);
        return userCodeFile;
    }

    /**
     * Compile java file -> class file
     *
     * @param userCodeFile
     * @return
     */
    public ExecuteMessage compileFile(File userCodeFile) {
        //2) compile file -> class file
        String compileCmd = String.format("javac -encoding utf-8 %s", userCodeFile.getAbsolutePath());
        try {
            Process compileProcess = Runtime.getRuntime().exec(compileCmd);
            ExecuteMessage executeMessage = ProcessUtils.runProcessAndGetMessage(compileProcess, "compile");
            System.out.println(executeMessage);
            if (executeMessage.getExitValue() != 0) {
                throw new RuntimeException("compile error");
            }
            return executeMessage;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<ExecuteMessage> runFile() {
    }

    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        //System.setSecurityManager(new MySecurityManager());

        List<String> inputList = executeCodeRequest.getInputList();
        String code = executeCodeRequest.getCode();
        String language = executeCodeRequest.getLanguage();

        //1) usercode -> file
        File userCodeFile = saveCodeToFile(code);

        //2) compile file -> class file
        ExecuteMessage compileFileExecuteMessage = compileFile(userCodeFile);
        System.out.println(compileFileExecuteMessage);

        //3) execute code, get output
        List<ExecuteMessage> executeMessageList = new ArrayList<>();
        for (String inputArgs : inputList) {
            //String runCmd = String.format("java -Xmx256m -Dfile.encoding=UTF-8 -cp %s Main %s", userCodeParentPath, inputArgs);
            String runCmd = String.format("java -Xmx256m -Dfile.encoding=UTF-8 -cp %s:%s -Djava.security.manager=%s Main %s", userCodeParentPath, SECURITY_MANAGER_PATH, SECURITY_MANAGER_CLASS_NAME, inputArgs);
            try {
                Process runProcess = Runtime.getRuntime().exec(runCmd);
//                //1. Control time Exceeded
                new Thread(() -> {
                    try {
                        Thread.sleep(TIME_OUT);
                        System.out.println("time out, destroy!");
                        runProcess.destroy();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }).start();
                ExecuteMessage executeMessage = ProcessUtils.runProcessAndGetMessage(runProcess, "runtime");
                //ExecuteMessage executeMessage = ProcessUtils.runInteractProcessAndGetMessage(runProcess, "runtime", inputArgs);
                executeMessageList.add(executeMessage);
                System.out.println(executeMessage);
            } catch (Exception e) {
                return getErrorResponse(e);
            }
        }

        //4)Collect and arrange output
        ExecuteCodeResponse executeCodeResponse = new ExecuteCodeResponse();
        List<String> outputList = new ArrayList<>();
        //to check if run out of time
        long maxTime = 0;
        for (ExecuteMessage executeMessage : executeMessageList) {
            String errorMessage = executeMessage.getErrorMessage();
            if (StrUtil.isNotBlank(errorMessage)) {
                executeCodeResponse.setMessage(errorMessage);
                //status fail: user code fail
                executeCodeResponse.setStatus(3);
                break;
            }
            outputList.add(executeMessage.getMessage());
            Long time = executeMessage.getTime();
            if (time != null) {
                maxTime = Math.max(maxTime, time);
            }
        }
        //execution success
        if (outputList.size() == executeMessageList.size()) {
            executeCodeResponse.setStatus(1);
        }
        executeCodeResponse.setOutList(outputList);

        JudgeInfo judgeInfo = new JudgeInfo();
        judgeInfo.setTime(maxTime);
        //judgeInfo.setMemory();

        executeCodeResponse.setJudgeInfo(judgeInfo);

        //5) Clean Files
        if (userCodeFile.getParentFile() != null) {
            boolean del = FileUtil.del(userCodePath);
            System.out.println("delete file " + (del ? "success" : "fail"));
        }
        return executeCodeResponse;
    }

    private ExecuteCodeResponse getErrorResponse(Throwable e) {
        ExecuteCodeResponse executeCodeResponse = new ExecuteCodeResponse();
        executeCodeResponse.setOutList(new ArrayList<>());
        executeCodeResponse.setMessage(e.getMessage());
        //error in sandbox(compile error)
        executeCodeResponse.setStatus(2);
        executeCodeResponse.setJudgeInfo(new JudgeInfo());
        return executeCodeResponse;
    }
}
