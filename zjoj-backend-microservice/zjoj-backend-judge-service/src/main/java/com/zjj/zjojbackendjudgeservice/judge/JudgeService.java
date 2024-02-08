package com.zjj.zjojbackendjudgeservice.judge;

import com.zjj.zjojbackendmodel.model.entity.QuestionSubmit;

/**
 * @Classname JudgeFeignClient
 * @Description TODO
 * @Author zjj
 * @Date 1/28/24 7:05 PM
 */
public interface JudgeService {
    /**
     * Judge
     * @param questionSubmitId
     * @return
     */
    QuestionSubmit doJudge(long questionSubmitId);
}
