package com.zjj.zjojbackendjudgeservice.judge.codesandbox.impl;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.zjj.zjojbackendcommon.common.ErrorCode;
import com.zjj.zjojbackendcommon.exception.BusinessException;
import com.zjj.zjojbackendjudgeservice.judge.codesandbox.CodeSandbox;
import com.zjj.zjojbackendmodel.model.codesandbox.ExecuteCodeRequest;
import com.zjj.zjojbackendmodel.model.codesandbox.ExecuteCodeResponse;
import org.apache.commons.lang3.StringUtils;

/**
 * @Classname RemoteCodeSandbox
 * @Description Remote Actual Call Interface
 * @Author zjj
 * @Date 1/28/24 4:23 PM
 */
public class RemoteCodeSandbox implements CodeSandbox {
    private static final String AUTH_REQUEST_HEADER = "auth";

    private static final String AUTH_REQUEST_SECRET = "secretKey";

    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("Remote CodeSandbox Start!");
        String url = "http://localhost:8090/executeCode";
        String json = JSONUtil.toJsonStr(executeCodeRequest);
        String responseStr = HttpUtil.createPost(url)
                .header(AUTH_REQUEST_HEADER, AUTH_REQUEST_SECRET)
                .body(json)
                .execute()
                .body();
        if (StringUtils.isBlank(responseStr)) {
            throw new BusinessException(ErrorCode.API_REQUEST_ERROR, "executeCode remoteSandbox error: " + responseStr);
        }
        return JSONUtil.toBean(responseStr, ExecuteCodeResponse.class);
    }
}
