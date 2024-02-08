package com.zjj.zjojbackendserviceclient.service;

import com.zjj.zjojbackendmodel.model.entity.QuestionSubmit;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Classname JudgeFeignClient
 * @Description TODO
 * @Author zjj
 * @Date 1/28/24 7:05 PM
 */
@FeignClient(name = "zjoj-backend-judge-service", path = "/api/judge/inner")
public interface JudgeFeignClient {
    /**
     * Judge
     *
     * @param questionSubmitId
     * @return
     */
    @PostMapping("/do")
    QuestionSubmit doJudge(@RequestParam("questionSubmitId") long questionSubmitId);
}
