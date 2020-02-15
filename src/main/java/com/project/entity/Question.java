package com.project.entity;

import com.project.constants.CommonConstants;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TB_QUESTION")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question extends AbtractEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ApiModelProperty(notes = "id")
    private Long id;

    @Column(name="question")
    @Size(max=700)
    @ApiModelProperty(notes = "questionName")
    private String questionName;

    @Column(name="explan")
    @Size(max=700)
    @ApiModelProperty(notes = "explan")
    private String explan;

    @Column(name="question_code")
    @ApiModelProperty(notes = "questionCode")
    private String questionCode;

    @Enumerated(EnumType.STRING)
    @Column(name="question_type")
    @ApiModelProperty(notes = "난이도 - enum ( ALL, OX, KNOW, OBJECTIVE, SUBJECTIVE)")
    private CommonConstants.QuestionForm questionForm;

    @Enumerated(EnumType.STRING)
    @Column(name="difficulty")
    @ApiModelProperty(notes = "난이도 - enum (HIGH, MIDDLE, LOW)")
    private CommonConstants.Difficulty difficulty;

    @OneToOne(mappedBy = "question", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private QuestionNormal questionNormal;



}
