package com.zjj.zjojcodesandbox.model;

import lombok.Data;

/**
 * @Classname ExecuteMessage
 * @Description Process Execution Message
 * @Author zjj
 * @Date 1/29/24 6:10 PM
 */
@Data
public class ExecuteMessage {
    private Integer exitValue;

    private String message;

    private String errorMessage;

    private Long time;

    private Long memory;
}
