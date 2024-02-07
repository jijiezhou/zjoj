package com.zjj.zjojbackendquestionservice.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zjj.zjojbackendmodel.model.dto.question.QuestionQueryRequest;
import com.zjj.zjojbackendmodel.model.entity.Question;
import com.zjj.zjojbackendmodel.model.vo.QuestionVO;

import javax.servlet.http.HttpServletRequest;

/**
* @author zjj
* @description focus on【question(user)】Service
* @createDate 2024-01-24 15:01:05
*/
public interface QuestionService extends IService<Question> {
    /**
     * validation:
     *
     * @param question
     * @param add
     */
    void validQuestion(Question question, boolean add);

    /**
     * Get query request
     *
     * @param questionQueryRequest
     * @return
     */
    QueryWrapper<Question> getQueryWrapper(QuestionQueryRequest questionQueryRequest);

    /**
     * Get QuestionVO
     *
     * @param question
     * @param request
     * @return
     */
    QuestionVO getQuestionVO(Question question, HttpServletRequest request);

    /**
     * Get QuestionVO by Page
     *
     * @param questionPage
     * @param request
     * @return
     */
    Page<QuestionVO> getQuestionVOPage(Page<Question> questionPage, HttpServletRequest request);
}
