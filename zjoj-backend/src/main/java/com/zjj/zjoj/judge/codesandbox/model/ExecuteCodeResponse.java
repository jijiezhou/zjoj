package com.zjj.zjoj.judge.codesandbox.model;

import com.zjj.zjoj.model.dto.questionsubmit.JudgeInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Classname ExecuteCodeRequest
 * @Description TODO
 * @Author zjj
 * @Date 1/28/24 4:09 PM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExecuteCodeResponse {
    private List<String> outList;

    /**
     * execution message
     */
    private String message;

    /**
     * execution status
     */
    private Integer status;

    /**
     * judgeInfo: message - memory - time
     */
    private JudgeInfo judgeInfo;
}
