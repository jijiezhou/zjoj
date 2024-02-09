package com.zjj.zjojbackendjudgeservice;

import com.zjj.zjojbackendjudgeservice.rabbitmq.InitRabbitMq;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@ComponentScan("com.zjj")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.zjj.zjojbackendserviceclient.service"})
public class ZjojBackendJudgeServiceApplication {

    public static void main(String[] args) {
        //start message queue
        InitRabbitMq.doInit();
        SpringApplication.run(ZjojBackendJudgeServiceApplication.class, args);
    }

}
