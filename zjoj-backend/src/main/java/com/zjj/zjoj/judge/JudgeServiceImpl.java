package com.zjj.zjoj.judge;

import cn.hutool.json.JSONUtil;
import com.zjj.zjoj.common.ErrorCode;
import com.zjj.zjoj.exception.BusinessException;
import com.zjj.zjoj.judge.codesandbox.CodeSandbox;
import com.zjj.zjoj.judge.codesandbox.CodeSandboxFactory;
import com.zjj.zjoj.judge.codesandbox.CodeSandboxProxy;
import com.zjj.zjoj.judge.codesandbox.model.ExecuteCodeRequest;
import com.zjj.zjoj.judge.codesandbox.model.ExecuteCodeResponse;
import com.zjj.zjoj.judge.strategy.JudgeContext;
import com.zjj.zjoj.model.dto.question.JudgeCase;
import com.zjj.zjoj.model.dto.questionsubmit.JudgeInfo;
import com.zjj.zjoj.model.entity.Question;
import com.zjj.zjoj.model.entity.QuestionSubmit;

import com.zjj.zjoj.model.enums.QuestionSubmitStatusEnum;
import com.zjj.zjoj.service.QuestionService;
import com.zjj.zjoj.service.QuestionSubmitService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Classname JudgeServiceImpl
 * @Description TODO
 * @Author zjj
 * @Date 1/28/24 7:10 PM
 */
@Service
public class JudgeServiceImpl implements JudgeService {
    @Resource
    private QuestionService questionService;

    @Resource
    private QuestionSubmitService questionSubmitService;

    @Resource
    private JudgeManager judgeManager;

    @Value("${codesandbox.type:example}")
    private String type;

    @Override
    public QuestionSubmit doJudge(long questionSubmitId) {
        //1) In: questionSubmitId to get question info and submitInfo(code, language…)
        QuestionSubmit questionSubmit = questionSubmitService.getById(questionSubmitId);
        if (questionSubmit == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR, "submit info not exist");
        }
        Long questionId = questionSubmit.getQuestionId();
        Question question = questionService.getById(questionId);
        if (question == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR, "question not exist");
        }
        //2) Only do the judge service when questionSubmit status is “WAITING”
        if (!questionSubmit.getStatus().equals(QuestionSubmitStatusEnum.WAITING.getValue())) {
            throw new BusinessException(ErrorCode.OPERATION_ERROR, "question is judging now");
        }
        //3) Change the questionSubmit status to “RUNNING” to prevent multiple execution
        QuestionSubmit questionSubmitUpdate = new QuestionSubmit();
        questionSubmitUpdate.setId(questionSubmitId);
        questionSubmitUpdate.setStatus(QuestionSubmitStatusEnum.RUNNING.getValue());
        boolean update = questionSubmitService.updateById(questionSubmitUpdate);
        if (!update) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "update questionSubmit fail");
        }

        //4) Call codesandbox and get execution result
        CodeSandbox codeSandbox = CodeSandboxFactory.newInstance(type);
        codeSandbox = new CodeSandboxProxy(codeSandbox);
        String language = questionSubmit.getLanguage();
        String code = questionSubmit.getCode();

        //Get user input case: String -> List<JudgeCase> -> List<String>
        String judgeCaseStr = question.getJudgeCase();
        List<JudgeCase> judgeCaseList = JSONUtil.toList(judgeCaseStr, JudgeCase.class);
        List<String> inputList = judgeCaseList.stream().map(JudgeCase::getInput).collect(Collectors.toList());

        ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder().
                code(code).
                inputList(inputList).
                language(language).
                build();
        ExecuteCodeResponse executeCodeResponse = codeSandbox.executeCode(executeCodeRequest);
        List<String> outputList = executeCodeResponse.getOutList();

        //5) Set questionJudge info and status based on output from sandbox
        JudgeContext judgeContext = new JudgeContext();
        judgeContext.setJudgeInfo(executeCodeResponse.getJudgeInfo());
        judgeContext.setInputList(inputList);
        judgeContext.setOutputList(outputList);
        judgeContext.setQuestion(question);
        judgeContext.setJudgeCaseList(judgeCaseList);
        judgeContext.setQuestionSubmit(questionSubmit);

        //JudgeManager
        JudgeInfo judgeInfo = judgeManager.doJudge(judgeContext);;

        //6). update judge result in database
        questionSubmitUpdate = new QuestionSubmit();
        questionSubmitUpdate.setId(questionSubmitId);
        questionSubmitUpdate.setStatus(QuestionSubmitStatusEnum.SUCCEED.getValue());
        questionSubmitUpdate.setJudgeInfo(JSONUtil.toJsonStr(judgeInfo));
        update = questionSubmitService.updateById(questionSubmitUpdate);
        if (!update) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "update questionSubmit fail");
        }
        QuestionSubmit questionSubmitResult = questionSubmitService.getById(questionId);
        return questionSubmitResult;
    }
}
