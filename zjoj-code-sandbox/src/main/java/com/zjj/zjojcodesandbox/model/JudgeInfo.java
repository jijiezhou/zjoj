package com.zjj.zjojcodesandbox.model;

import lombok.Data;

/**
 * @Classname JudgeInfo
 * @Description judgement information
 * @Author zjj
 * @Date 1/24/24 8:14 PM
 */
@Data
public class JudgeInfo {
    /**
     * message
     */
    private String message;

    /**
     * memory(kb)
     */
    private Long memory;

    /**
     * time(ms)
     */
    private Long time;
}
