package com.zjj.zjojbackendjudgeservice.controller.inner;

import com.zjj.zjojbackendjudgeservice.judge.JudgeService;
import com.zjj.zjojbackendmodel.model.entity.QuestionSubmit;
import com.zjj.zjojbackendserviceclient.service.JudgeFeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Classname JudgeInnerController
 * @Description Only provide for inner services, not send to frontend
 * @Author zjj
 * @Date 2/7/24 3:30 PM
 */
@RestController
@RequestMapping("/inner")
public class JudgeInnerController implements JudgeFeignClient {
    @Resource
    private JudgeService judgeService;

    /**
     * Judge
     *
     * @param questionSubmitId
     * @return
     */
    @PostMapping("/do")
    @Override
    public QuestionSubmit doJudge(@RequestParam("questionSubmitId") long questionSubmitId) {
        return judgeService.doJudge(questionSubmitId);
    }
}
