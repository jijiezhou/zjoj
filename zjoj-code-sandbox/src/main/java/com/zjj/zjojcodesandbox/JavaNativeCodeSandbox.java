package com.zjj.zjojcodesandbox;

import com.zjj.zjojcodesandbox.model.ExecuteCodeRequest;
import com.zjj.zjojcodesandbox.model.ExecuteCodeResponse;
import org.springframework.stereotype.Component;

/**
 * @Classname JavaNativeCodeSandbox
 * @Description Reuse executeCode method from Abstract Template
 * @Author zjj
 * @Date 1/29/24 2:46PM
 */
@Component
public class JavaNativeCodeSandbox extends JavaCodeSandboxTemplate {
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        return super.executeCode(executeCodeRequest);
    }
}
