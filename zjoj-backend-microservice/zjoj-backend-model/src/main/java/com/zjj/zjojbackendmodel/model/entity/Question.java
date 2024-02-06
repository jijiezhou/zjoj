package com.zjj.zjojbackendmodel.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * user
 * @TableName question
 */
@TableName(value ="question")
@Data
public class Question implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.ASSIGN_ID)
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
    private String tags;

    /**
     * question answer
     */
    private String answer;

    /**
     * submission number
     */
    private Integer submitNum;

    /**
     * accepted number
     */
    private Integer acceptedNum;

    /**
     * judge case - JSON array
     */
    private String judgeCase;

    /**
     * judge config - JSON object
     */
    private String judgeConfig;

    /**
     * like number
     */
    private Integer thumbNum;

    /**
     * favour number
     */
    private Integer favourNum;

    /**
     * create user id
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
