package com.zjj.zjojbackendjudgeservice.judge;

import com.zjj.zjojbackendjudgeservice.judge.strategy.DefaultJudgeStrategy;
import com.zjj.zjojbackendjudgeservice.judge.strategy.JavaLanguageJudgeStrategy;
import com.zjj.zjojbackendjudgeservice.judge.strategy.JudgeContext;
import com.zjj.zjojbackendjudgeservice.judge.strategy.JudgeStrategy;
import com.zjj.zjojbackendmodel.model.codesandbox.JudgeInfo;
import com.zjj.zjojbackendmodel.model.entity.QuestionSubmit;
import org.springframework.stereotype.Service;

/**
 * @Classname JudgeManager
 * @Description Simplify call process
 * @Author zjj
 * @Date 1/28/24 8:39 PM
 */
@Service
public class JudgeManager {
    /**
     * doJudge
     * @param judgeContext
     * @return
     */
    JudgeInfo doJudge(JudgeContext judgeContext){
        QuestionSubmit questionSubmit = judgeContext.getQuestionSubmit();
        String language = questionSubmit.getLanguage();
        JudgeStrategy judgeStrategy = new DefaultJudgeStrategy();
        if (language.equals("java")){
            judgeStrategy = new JavaLanguageJudgeStrategy();
        }
        return judgeStrategy.doJudge(judgeContext);
    }
}
