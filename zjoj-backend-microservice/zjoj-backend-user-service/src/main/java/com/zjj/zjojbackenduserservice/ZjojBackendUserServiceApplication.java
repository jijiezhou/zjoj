package com.zjj.zjojbackenduserservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.zjj.zjojbackenduserservice.mapper")
@EnableScheduling
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@ComponentScan("com.zjj")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.zjj.zjojbackendserviceclient.service"})
public class ZjojBackendUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZjojBackendUserServiceApplication.class, args);
    }

}
