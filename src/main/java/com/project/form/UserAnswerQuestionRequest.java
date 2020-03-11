package com.project.form;

import lombok.Data;

@Data
public class UserAnswerQuestionRequest {
    private String answer;
    private Long userExamQuestionId;

}
