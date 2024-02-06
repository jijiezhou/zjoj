package com.zjj.zjojbackendmodel.model.dto.question;

import lombok.Data;

/**
 * @Classname JudgeConfig
 * @Description question configuration
 * @Author zjj
 * @Date 1/24/24 8:09 PM
 */
@Data
public class JudgeConfig {
    /**
     * time limit(ms)
     */
    private Long timeLimit;

    /**
     * memory limit(kb)
     */
    private Long memoryLimit;

    /**
     * stack limit(kb)
     */
    private Long stackLimit;
}
