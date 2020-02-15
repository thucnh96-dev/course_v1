package com.project.form;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserExamForm {

    private Long examId;

    private Long userId;

    private Boolean immediatelyResult;

    private BigDecimal expectPoint;
}
