package com.zjj.zjoj.judge.strategy;

import com.zjj.zjoj.model.dto.question.JudgeCase;
import com.zjj.zjoj.judge.codesandbox.model.JudgeInfo;
import com.zjj.zjoj.model.entity.Question;
import com.zjj.zjoj.model.entity.QuestionSubmit;
import lombok.Data;

import java.util.List;

/**
 * @Classname JudgeContext
 * @Description TODO
 * @Author zjj
 * @Date 1/28/24 8:04 PM
 */
@Data
public class JudgeContext {
    private JudgeInfo judgeInfo;

    private List<String> inputList;

    private List<String> outputList;

    private Question question;

    private List<JudgeCase> judgeCaseList;

    private QuestionSubmit questionSubmit;
}
