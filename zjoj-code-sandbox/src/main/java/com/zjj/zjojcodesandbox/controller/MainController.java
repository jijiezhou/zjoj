package com.zjj.zjojcodesandbox.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname MainController
 * @Description TODO
 * @Author zjj
 * @Date 1/29/24 1:17PM
 */
@RestController("/")
public class MainController {
    @GetMapping("/health")
    public String healthCheck(){
        return "Ok";
    }
}
