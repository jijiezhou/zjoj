package com.zjj.zjojbackendmodel.model.dto.questionsubmit;

import com.zjj.zjojbackendcommon.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @Classname QuestionSubmitQueryRequest
 * @Description TODO
 * @Author zjj
 * @Date 1/25/24 12:43 PM
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class QuestionSubmitQueryRequest extends PageRequest implements Serializable {
    /**
     * language use
     */
    private String language;

    /**
     * question status
     */
    private Integer status;

    /**
     * question id
     */
    private Long questionId;

    /**
     * user id
     */
    private Long userId;

    private static final long serialVersionUID = 1L;
}
