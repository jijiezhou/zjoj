package com.zjj.zjojcodesandbox;

import com.zjj.zjojcodesandbox.model.ExecuteCodeRequest;
import com.zjj.zjojcodesandbox.model.ExecuteCodeResponse;

/**
 * @Classname CodeSandbox
 * @Description Code Sandbox Interface
 * @Author zjj
 * @Date 1/28/24 4:07 PM
 */

public interface CodeSandbox {
    ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest);
}
