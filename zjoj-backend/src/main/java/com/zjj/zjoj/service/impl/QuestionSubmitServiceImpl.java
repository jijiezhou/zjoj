package com.zjj.zjoj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zjj.zjoj.common.ErrorCode;
import com.zjj.zjoj.exception.BusinessException;
import com.zjj.zjoj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.zjj.zjoj.model.entity.Question;
import com.zjj.zjoj.model.entity.QuestionSubmit;
import com.zjj.zjoj.model.entity.QuestionSubmit;
import com.zjj.zjoj.model.entity.User;
import com.zjj.zjoj.model.enums.QuestionSubmitLanguageEnum;
import com.zjj.zjoj.model.enums.QuestionSubmitStatusEnum;
import com.zjj.zjoj.service.QuestionService;
import com.zjj.zjoj.service.QuestionSubmitService;
import com.zjj.zjoj.service.QuestionSubmitService;
import com.zjj.zjoj.mapper.QuestionSubmitMapper;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author zj
 * @description 【question_submit(question submit)】ServiceIml
 * @createDate 2024-01-24 15:02:18
 */
@Service
public class QuestionSubmitServiceImpl extends ServiceImpl<QuestionSubmitMapper, QuestionSubmit>
        implements QuestionSubmitService {
    @Resource
    private QuestionService questionService;

    /**
     * question submit
     *
     * @param questionSubmitAddRequest
     * @param loginUser
     * @return
     */
    @Override
    public long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser) {
        //check if language legal
        String language = questionSubmitAddRequest.getLanguage();
        QuestionSubmitLanguageEnum languageEnum = QuestionSubmitLanguageEnum.getEnumByValue(language);
        if (languageEnum == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "language error");
        }

        long questionId = questionSubmitAddRequest.getQuestionId();
        // check if entity exist
        Question question = questionService.getById(questionId);
        if (question == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR);
        }
        // check if submit
        long userId = loginUser.getId();
        // each user submit question in parallel
        QuestionSubmit questionSubmit = new QuestionSubmit();
        questionSubmit.setUserId(userId);
        questionSubmit.setQuestionId(questionId);
        questionSubmit.setCode(questionSubmitAddRequest.getCode());
        questionSubmit.setLanguage(language);
        //set initial state: waiting
        questionSubmit.setStatus(QuestionSubmitStatusEnum.WAITING.getValue());
        questionSubmit.setJudgeInfo("{}");
        // lock: business user can only submit 1 question at a single time
        boolean save = this.save(questionSubmit);
        if (!save) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "data insert fail");
        }
        return questionSubmit.getId();
    }
}




