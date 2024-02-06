package com.zjj.zjojbackendmodel.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * question submit
 * @TableName question_submit
 */
@TableName(value ="question_submit")
@Data
public class QuestionSubmit implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * language use
     */
    private String language;

    /**
     * code
     */
    private String code;

    /**
     * judgement info - JSON object
     */
    private String judgeInfo;

    /**
     * 0-waiting,1-judging,2-success,3-fail
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

    /**
     * create time
     */
    private Date createTime;

    /**
     * update time
     */
    private Date updateTime;

    /**
     * flag of delete or not
     */
    @TableLogic
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
