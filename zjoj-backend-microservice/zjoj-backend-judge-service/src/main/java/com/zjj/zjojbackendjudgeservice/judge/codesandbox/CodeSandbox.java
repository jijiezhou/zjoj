package com.zjj.zjojbackendjudgeservice.judge.codesandbox;


import com.zjj.zjojbackendmodel.model.codesandbox.ExecuteCodeRequest;
import com.zjj.zjojbackendmodel.model.codesandbox.ExecuteCodeResponse;

/**
 * @Classname CodeSandbox
 * @Description Code Sandbox Interface
 * @Author zjj
 * @Date 1/28/24 4:07 PM
 */

public interface CodeSandbox {
     ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest);
}
