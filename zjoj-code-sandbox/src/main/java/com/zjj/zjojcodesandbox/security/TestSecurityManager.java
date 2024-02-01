package com.zjj.zjojcodesandbox.security;

import cn.hutool.core.io.FileUtil;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @Classname TestSecurityManager
 * @Description TODO
 * @Author zjj
 * @Date 1/30/24 4:18 PM
 */
public class TestSecurityManager {

    public static void main(String[] args){
        System.setSecurityManager(new MySecurityManager());
        FileUtil.writeString("aa", "aaa", StandardCharsets.UTF_8);
    }
}
