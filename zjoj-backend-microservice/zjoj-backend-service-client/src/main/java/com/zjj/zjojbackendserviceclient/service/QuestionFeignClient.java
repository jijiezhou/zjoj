package com.zjj.zjojbackendserviceclient.service;

import com.zjj.zjojbackendmodel.model.entity.Question;
import com.zjj.zjojbackendmodel.model.entity.QuestionSubmit;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
* @author zjj
* @description focus on【question(user)】Service
* @createDate 2024-01-24 15:01:05
*/
@FeignClient(name = "zjoj-backend-question-service", path = "/api/question/inner")
public interface QuestionFeignClient{
    /**
     * GetById
     * @param questionId
     * @return
     */
    @GetMapping("/get/id")
    Question getById(@RequestParam("questionId") long questionId);

    /**
     * GetByQuestionSubmitId
     * @param questionSubmitId
     * @return
     */
    @GetMapping("/question_submit/get/id")
    QuestionSubmit getQuestionSubmitById(@RequestParam("questionSubmitId") long questionSubmitId);

    /**
     * update quesitonSubmit
     * @param questionSubmit
     * @return
     */
    @PostMapping("/question_submit/update")
    boolean updateQuestionSubmit(@RequestBody QuestionSubmit questionSubmit);
}
