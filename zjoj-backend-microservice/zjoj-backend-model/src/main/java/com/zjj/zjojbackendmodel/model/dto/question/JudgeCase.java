package com.zjj.zjojbackendmodel.model.dto.question;

import lombok.Data;

/**
 * @Classname JudgeCase
 * @Description question user case
 * @Author zjj
 * @Date 1/24/24 8:07 PM
 */
@Data
public class JudgeCase {
    /**
     * input user case
     */
    private String input;

    /**
     * output user case
     */
    private String output;
}
