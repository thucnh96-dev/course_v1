package com.project.form;

import lombok.Data;

@Data
public class UserExamQuestionNormalAnswerForm {
    private Long examQuestionId;
    private Long userExamId;
    private String userAnswer;

}
