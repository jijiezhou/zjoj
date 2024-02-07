package com.zjj.zjojbackendquestionservice.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zjj.zjojbackendmodel.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.zjj.zjojbackendmodel.model.dto.questionsubmit.QuestionSubmitQueryRequest;
import com.zjj.zjojbackendmodel.model.entity.QuestionSubmit;
import com.zjj.zjojbackendmodel.model.entity.User;
import com.zjj.zjojbackendmodel.model.vo.QuestionSubmitVO;

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

    /**
     * Get query request
     *
     * @param questionSubmitQueryRequest
     * @return
     */
    QueryWrapper<QuestionSubmit> getQueryWrapper(QuestionSubmitQueryRequest questionSubmitQueryRequest);

    /**
     * Get QuestionSubmitVO
     *
     * @param questionSubmit
     * @param loginUSer
     * @return
     */
    QuestionSubmitVO getQuestionSubmitVO(QuestionSubmit questionSubmit, User loginUSer);

    /**
     * Get QuestionSubmitVO by Page
     *
     * @param questionSubmitPage
     * @param loginUser
     * @return
     */
    Page<QuestionSubmitVO> getQuestionSubmitVOPage(Page<QuestionSubmit> questionSubmitPage, User loginUser);
}
