package com.zjj.zjojbackendjudgeservice.judge.codesandbox.impl;


import com.zjj.zjojbackendjudgeservice.judge.codesandbox.CodeSandbox;
import com.zjj.zjojbackendmodel.model.codesandbox.ExecuteCodeRequest;
import com.zjj.zjojbackendmodel.model.codesandbox.ExecuteCodeResponse;

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
