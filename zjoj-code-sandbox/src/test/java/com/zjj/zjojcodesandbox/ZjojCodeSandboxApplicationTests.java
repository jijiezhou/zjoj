package com.zjj.zjojcodesandbox;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ZjojCodeSandboxApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void test() {
        System.out.println(System.getProperty("java.version"));
    }
}
