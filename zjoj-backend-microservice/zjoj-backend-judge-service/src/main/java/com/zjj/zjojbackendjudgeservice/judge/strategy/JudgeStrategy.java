package com.zjj.zjojbackendjudgeservice.judge.strategy;

import com.zjj.zjojbackendmodel.model.codesandbox.JudgeInfo;

/**
 * @Classname JudgeStrategy
 * @Description TODO
 * @Author zjj
 * @Date 1/28/24 8:04PM
 */
public interface JudgeStrategy {
    JudgeInfo doJudge(JudgeContext judgeContext);
}
