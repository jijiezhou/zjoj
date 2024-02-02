package com.zjj.zjoj.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zjj.zjoj.annotation.AuthCheck;
import com.zjj.zjoj.common.BaseResponse;
import com.zjj.zjoj.common.ErrorCode;
import com.zjj.zjoj.common.ResultUtils;
import com.zjj.zjoj.constant.UserConstant;
import com.zjj.zjoj.exception.BusinessException;
import com.zjj.zjoj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.zjj.zjoj.model.dto.questionsubmit.QuestionSubmitQueryRequest;
import com.zjj.zjoj.model.entity.QuestionSubmit;
import com.zjj.zjoj.model.entity.User;
import com.zjj.zjoj.model.vo.QuestionSubmitVO;
import com.zjj.zjoj.service.QuestionSubmitService;
import com.zjj.zjoj.service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Question Submit API
 *
 * @author zjj
 */
@RestController
//@RequestMapping("/question_submit")
@Slf4j
@Deprecated
public class QuestionSubmitController {

    @Resource
    private QuestionSubmitService questionSubmitService;

    @Resource
    private UserService userService;

//    /**
//     * Submit Question
//     *
//     * @param questionSubmitAddRequest
//     * @param request
//     * @return
//     */
//    @PostMapping("/")
//    public BaseResponse<Long> doQuestionSubmit(@RequestBody QuestionSubmitAddRequest questionSubmitAddRequest,
//                                         HttpServletRequest request) {
//        if (questionSubmitAddRequest == null || questionSubmitAddRequest.getQuestionId() <= 0) {
//            throw new BusinessException(ErrorCode.PARAMS_ERROR);
//        }
//        // submit question after login
//        final User loginUser = userService.getLoginUser(request);
//        long questionId = questionSubmitAddRequest.getQuestionId();
//        long result = questionSubmitService.doQuestionSubmit(questionSubmitAddRequest, loginUser);
//        return ResultUtils.success(result);
//    }
//
//    /**
//     * Get QuestionSubmit ByPage
//     *
//     * @param questionSubmitQueryRequest
//     * @return
//     */
//    @PostMapping("/list/page")
//    public BaseResponse<Page<QuestionSubmitVO>> listQuestionSubmitByPage(@RequestBody QuestionSubmitQueryRequest questionSubmitQueryRequest, HttpServletRequest request) {
//        long current = questionSubmitQueryRequest.getCurrent();
//        long size = questionSubmitQueryRequest.getPageSize();
//        //Get original question info by page
//        Page<QuestionSubmit> questionSubmitPage = questionSubmitService.page(new Page<>(current, size),
//                questionSubmitService.getQueryWrapper(questionSubmitQueryRequest));
//        final User loginUser = userService.getLoginUser(request);
//        //Desensitization
//        return ResultUtils.success(questionSubmitService.getQuestionSubmitVOPage(questionSubmitPage, loginUser));
//    }
}
