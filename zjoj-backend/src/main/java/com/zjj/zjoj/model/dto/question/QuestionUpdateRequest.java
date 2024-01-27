package com.zjj.zjoj.model.dto.question;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Question Update Request
 *
 * @author zjj
 */
@Data
public class QuestionUpdateRequest implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * question title
     */
    private String title;

    /**
     * question content
     */
    private String content;

    /**
     * question tags - JSON array
     */
    private List<String> tags;

    /**
     * question answer
     */
    private String answer;

    /**
     * judge case - JSON array
     */
    private List<JudgeCase> judgeCase;

    /**
     * judge config - JSON object
     */
    private JudgeConfig judgeConfig;

    private static final long serialVersionUID = 1L;
}
