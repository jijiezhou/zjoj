package com.zjj.zjojbackendjudgeservice.judge.codesandbox;

import com.zjj.zjojbackendmodel.model.codesandbox.ExecuteCodeRequest;
import com.zjj.zjojbackendmodel.model.codesandbox.ExecuteCodeResponse;
import lombok.extern.slf4j.Slf4j;

/**
 * @Classname CodeSandboxProxy
 * @Description TODO
 * @Author zjj
 * @Date 1/28/24 5:18 PM
 */
@Slf4j
public class CodeSandboxProxy implements CodeSandbox {
    private final CodeSandbox codeSandbox;

    public CodeSandboxProxy(CodeSandbox codeSandbox) {
        this.codeSandbox = codeSandbox;
    }

    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        log.info("codesandbox request info " + executeCodeRequest.toString());
         ExecuteCodeResponse executeCodeResponse = codeSandbox.executeCode(executeCodeRequest);
        log.info("codesandbox response info " + executeCodeResponse.toString());
        return executeCodeResponse;
    }
}
