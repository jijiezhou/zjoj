package com.zjj.zjojbackendmodel.model.dto.questionsubmit;

import lombok.Data;

import java.io.Serializable;

/**
 * @Classname QuestionSubmitAddRequest
 * @Description TODO
 * @Author zjj
 * @Date 1/24/24 9:28 PM
 */
@Data
public class QuestionSubmitAddRequest implements Serializable {
    /**
     * language use
     */
    private String language;

    /**
     * code
     */
    private String code;

    /**
     * question id
     */
    private Long questionId;

    private static final long serialVersionUID = 1L;
}
