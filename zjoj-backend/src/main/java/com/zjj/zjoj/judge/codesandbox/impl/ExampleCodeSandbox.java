package com.zjj.zjoj.judge.codesandbox.impl;

import com.zjj.zjoj.judge.codesandbox.CodeSandbox;
import com.zjj.zjoj.judge.codesandbox.model.ExecuteCodeRequest;
import com.zjj.zjoj.judge.codesandbox.model.ExecuteCodeResponse;
import com.zjj.zjoj.model.dto.questionsubmit.JudgeInfo;
import com.zjj.zjoj.model.enums.JudgeInfoMessageEnum;
import com.zjj.zjoj.model.enums.QuestionSubmitStatusEnum;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @Classname ExampleCodeSandbox
 * @Description Example: Just for run through service process
 * @Author zjj
 * @Date 1/28/24 4:22 PM
 */
@Slf4j
public class ExampleCodeSandbox implements CodeSandbox {

    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        List<String> inputList = executeCodeRequest.getInputList();

        ExecuteCodeResponse executeCodeResponse = new ExecuteCodeResponse();
        executeCodeResponse.setOutList(inputList);
        executeCodeResponse.setMessage("success!!!");
        executeCodeResponse.setStatus(QuestionSubmitStatusEnum.SUCCEED.getValue());
        JudgeInfo judgeInfo = new JudgeInfo();
        judgeInfo.setMessage(JudgeInfoMessageEnum.ACCEPTED.getText());
        judgeInfo.setMemory(100L);
        judgeInfo.setTime(100L);
        executeCodeResponse.setJudgeInfo(judgeInfo);

        return executeCodeResponse;
    }
}
