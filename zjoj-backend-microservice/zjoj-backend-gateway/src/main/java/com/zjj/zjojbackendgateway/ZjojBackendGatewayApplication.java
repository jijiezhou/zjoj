package com.zjj.zjojbackendgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ZjojBackendGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZjojBackendGatewayApplication.class, args);
    }

}
