package com.zjj.zjojbackendmodel.model.vo;

import cn.hutool.json.JSONUtil;
import com.zjj.zjojbackendmodel.model.dto.question.JudgeConfig;
import com.zjj.zjojbackendmodel.model.entity.Question;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Classname QuestionVO
 * @Description
 * @Author zjj
 * @Date 1/24/24 8:25 PM
 */
@Data
public class QuestionVO implements Serializable {
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
     * submission number
     */
    private Integer submitNum;

    /**
     * accepted number
     */
    private Integer acceptedNum;

    /**
     * judge config - JSON object
     */
    private JudgeConfig judgeConfig;

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
     * user info
     */
    private UserVO userVO;

    /**
     * Wrapper -> Object
     *
     * @param questionVO
     * @return
     */
    public static Question voToObj(QuestionVO questionVO) {
        if (questionVO == null) {
            return null;
        }
        Question question = new Question();
        BeanUtils.copyProperties(questionVO, question);
        List<String> tags = questionVO.getTags();
        if (tags != null){
            question.setTags(JSONUtil.toJsonStr(tags));
        }
        JudgeConfig judgeConfig = questionVO.getJudgeConfig();
        if (judgeConfig != null){
            question.setJudgeConfig(JSONUtil.toJsonStr(judgeConfig));
        }
        return question;
    }

    /**
     * Object -> Wrapper
     *
     * @param question
     * @return
     */
    public static QuestionVO objToVo(Question question) {
        if (question == null) {
            return null;
        }
        QuestionVO questionVO = new QuestionVO();
        BeanUtils.copyProperties(question, questionVO);
        List<String> tags = JSONUtil.toList(question.getTags(), String.class);
        questionVO.setTags(tags);
        String judgeConfigStr = question.getJudgeConfig();
        questionVO.setJudgeConfig(JSONUtil.toBean(judgeConfigStr, JudgeConfig.class));
        return questionVO;
    }

    private static final long serialVersionUID = 1L;
}
