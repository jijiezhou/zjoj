package com.zjj.zjoj.judge.codesandbox.impl;

import com.zjj.zjoj.judge.codesandbox.CodeSandbox;
import com.zjj.zjoj.judge.codesandbox.model.ExecuteCodeRequest;
import com.zjj.zjoj.judge.codesandbox.model.ExecuteCodeResponse;

/**
 * @Classname RemoteCodeSandbox
 * @Description Actual Call Interface
 * @Author zjj
 * @Date 1/28/24 4:23 PM
 */
public class RemoteCodeSandbox implements CodeSandbox {
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.print("RemoteCodeSandbox");
        return null;
    }
}
