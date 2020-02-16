package com.project.form;

import lombok.Data;

@Data
public class QuestionForm {

    private Long examId;
    private String questionName;

    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;

    private String answerCorect;
    private String explan;
    private String difficulty;

    private Boolean autoGen;
    private Integer numbers;

    private Integer number;

}
