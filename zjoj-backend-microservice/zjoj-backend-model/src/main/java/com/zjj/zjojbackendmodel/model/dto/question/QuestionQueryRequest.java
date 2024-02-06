package com.zjj.zjojbackendmodel.model.dto.question;

import com.zjj.zjojbackendcommon.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * Question Query Request
 *
 * @author zjj
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class QuestionQueryRequest extends PageRequest implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * title
     */
    private String title;

    /**
     * content
     */
    private String content;

    /**
     * tags
     */
    private List<String> tags;

    /**
     * answer
     */
    private String answer;

    /**
     * user id
     */
    private Long userId;

    private static final long serialVersionUID = 1L;
}
