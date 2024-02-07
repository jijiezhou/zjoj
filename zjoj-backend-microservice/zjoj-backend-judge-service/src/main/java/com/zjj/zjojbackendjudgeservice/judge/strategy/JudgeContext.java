package com.zjj.zjojbackendjudgeservice.judge.strategy;


import com.zjj.zjojbackendmodel.model.codesandbox.JudgeInfo;
import com.zjj.zjojbackendmodel.model.dto.question.JudgeCase;
import com.zjj.zjojbackendmodel.model.entity.Question;
import com.zjj.zjojbackendmodel.model.entity.QuestionSubmit;
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
