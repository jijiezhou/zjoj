package com.zjj.zjoj.model.dto.questionsubmit;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

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
