package com.zjj.zjoj.service;

import com.zjj.zjoj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.zjj.zjoj.model.entity.QuestionSubmit;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zjj.zjoj.model.entity.User;

/**
* @author zj
* @description 【question_submit(question submit)】Service
* @createDate 2024-01-24 15:02:18
*/
public interface QuestionSubmitService extends IService<QuestionSubmit> {
    /**
     * question submit
     *
     * @param questionSubmitAddRequest cannot only use questionId
     * @param loginUser
     * @return userId who submit
     */
    long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser);
}
