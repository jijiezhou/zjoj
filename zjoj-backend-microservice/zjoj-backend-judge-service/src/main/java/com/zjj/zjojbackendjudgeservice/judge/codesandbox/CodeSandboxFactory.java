package com.zjj.zjojbackendjudgeservice.judge.codesandbox;

import com.zjj.zjojbackendjudgeservice.judge.codesandbox.impl.ExampleCodeSandbox;
import com.zjj.zjojbackendjudgeservice.judge.codesandbox.impl.RemoteCodeSandbox;
import com.zjj.zjojbackendjudgeservice.judge.codesandbox.impl.ThirdPartyCodeSandbox;

/**
 * @Classname CodeSandboxFactory
 * @Description string parameters of type to generate corresponding sandbox
 * @Author zjj
 * @Date 1/28/24 4:49 PM
 */
public class CodeSandboxFactory {
    /**
     * Create instantiation of sandbox
     *
     * @param type
     * @return
     */
    public static CodeSandbox newInstance(String type) {
        switch (type) {
            case "example":
                return new ExampleCodeSandbox();
            case "remote":
                return new RemoteCodeSandbox();
            case "thirdParty":
                return new ThirdPartyCodeSandbox();
            default:
                return new ExampleCodeSandbox();
        }
    }
}
