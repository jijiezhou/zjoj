package com.zjj.zjoj.judge.codesandbox.impl;

import com.zjj.zjoj.judge.codesandbox.CodeSandbox;
import com.zjj.zjoj.judge.codesandbox.model.ExecuteCodeRequest;
import com.zjj.zjoj.judge.codesandbox.model.ExecuteCodeResponse;

/**
 * @Classname ExampleCodeSandbox
 * @Description Example: Just for run through service process
 * @Author zjj
 * @Date 1/28/24 4:22 PM
 */
public class ExampleCodeSandbox implements CodeSandbox {

    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.print("ExampleCodeSandbox");
        return null;
    }
}
