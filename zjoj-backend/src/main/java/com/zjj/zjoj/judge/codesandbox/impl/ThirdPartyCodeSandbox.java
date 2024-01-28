package com.zjj.zjoj.judge.codesandbox.impl;

import com.zjj.zjoj.judge.codesandbox.CodeSandbox;
import com.zjj.zjoj.judge.codesandbox.model.ExecuteCodeRequest;
import com.zjj.zjoj.judge.codesandbox.model.ExecuteCodeResponse;

/**
 * @Classname ThirdPartyCodeSandbox
 * @Description Call current sandbox on the websites
 * @Author zjj
 * @Date 1/28/24 4:24 PM
 */
public class ThirdPartyCodeSandbox implements CodeSandbox {
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.print("ThirdPartyCodeSandbox");
        return null;
    }
}
