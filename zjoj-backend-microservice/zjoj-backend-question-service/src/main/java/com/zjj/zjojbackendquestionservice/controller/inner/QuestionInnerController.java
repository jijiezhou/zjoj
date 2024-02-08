package com.zjj.zjojbackendquestionservice.controller.inner;

import com.zjj.zjojbackendmodel.model.entity.Question;
import com.zjj.zjojbackendmodel.model.entity.QuestionSubmit;
import com.zjj.zjojbackendquestionservice.service.QuestionService;
import com.zjj.zjojbackendquestionservice.service.QuestionSubmitService;
import com.zjj.zjojbackendserviceclient.service.QuestionFeignClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Classname QuestionInnerController
 * @Description Only provide for inner services, not send to frontend
 * @Author zjj
 * @Date 2/7/24 3:30 PM
 */
@RestController
@RequestMapping("/inner")
public class QuestionInnerController implements QuestionFeignClient {
    @Resource
    private QuestionService questionService;

    @Resource
    private QuestionSubmitService questionSubmitService;

    /**
     * GetById
     * @param questionId
     * @return
     */
    @Override
    @GetMapping("/get/id")
    public Question getById(@RequestParam("questionId") long questionId){
        return questionService.getById(questionId);
    }

    /**
     * GetByQuestionSubmitId
     * @param questionSubmitId
     * @return
     */
    @Override
    @GetMapping("/question_submit/get/id")
    public QuestionSubmit getQuestionSubmitById(@RequestParam("questionSubmitId") long questionSubmitId){
        return questionSubmitService.getById(questionSubmitId);
    }

    /**
     * update quesitonSubmit
     * @param questionSubmit
     * @return
     */
    @Override
    @PostMapping("/question_submit/update")
    public boolean updateQuestionSubmit(@RequestBody QuestionSubmit questionSubmit){
        return questionSubmitService.updateById(questionSubmit);
    }
}
