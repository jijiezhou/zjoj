package com.zjj.zjoj.judge.strategy;

import com.zjj.zjoj.model.dto.questionsubmit.JudgeInfo;

/**
 * @Classname JudgeStrategy
 * @Description TODO
 * @Author zjj
 * @Date 1/28/24 8:04PM
 */
public interface JudgeStrategy {
    JudgeInfo doJudge(JudgeContext judgeContext);
}
