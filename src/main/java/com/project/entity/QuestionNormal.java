package com.project.entity;

import com.project.constants.CommonConstants;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="TB_QUESTION_NORMAL")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class QuestionNormal extends AbtractEntity{

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "ID")
    private Long id;

    @Column(name="answer1")
    private String answer1;

    @Column(name="answer2")
    private String answer2;

    @Column(name="answer3")
    private String answer3;

    @Column(name="answer4")
    private String answer4;


    @Column(name="answer_corect")
    @Enumerated(EnumType.STRING)
    @ApiModelProperty(notes = "난이도 - enum ( answer1, answer2, answer3, answer4)")
    private CommonConstants.QuestionNormalCorect answerCorect;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    @MapsId
    @ApiModelProperty(notes = "question")
    private Question question;

}
