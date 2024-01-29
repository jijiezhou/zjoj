package com.zjj.zjoj.judge;

import com.zjj.zjoj.judge.strategy.DefaultJudgeStrategy;
import com.zjj.zjoj.judge.strategy.JavaLanguageJudgeStrategy;
import com.zjj.zjoj.judge.strategy.JudgeContext;
import com.zjj.zjoj.judge.strategy.JudgeStrategy;
import com.zjj.zjoj.model.dto.questionsubmit.JudgeInfo;
import com.zjj.zjoj.model.entity.QuestionSubmit;
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
