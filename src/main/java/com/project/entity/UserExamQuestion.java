/* 
 * Copyright 2017 Hunet
 * EULA 라이센스에 의거하여 라이센스가 부여됩니다.
 * 귀하는 라이센스를 준수하는 경우를 제외하고는 이 파일을 사용할 수 없습니다.
 * 귀하는 라이센스의 사본을 다음의 주소에서 확인 가능합니다.
 * http://www.trusteer.com/en/support/end-user-license-agreement
 */

package com.project.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="TB_USER_EXAM_QUESTION")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString(exclude = { "userExamQuestionObjAnswers" })
@EqualsAndHashCode(callSuper=false)
public class UserExamQuestion extends AbtractEntity {
	
	@Id
	@Column(name="id", columnDefinition = "INTEGER")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "ID")
    private Long id;
	
	@Column(name="answered")
	@NotNull
	@ApiModelProperty(notes =  "응답여부")
    private boolean answered = false;
	
	@Column(name="correct")
	@ApiModelProperty(notes =  "correct")
    private Boolean correct;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "User_Id", referencedColumnName="id")
	@JsonIgnore
	@ApiModelProperty(notes = "user")
    private User user;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
    @JoinColumn(name = "exam_question_id", referencedColumnName="id")
	@ApiModelProperty(notes = "examQuestion")
    private ExamQuestion examQuestion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_exam_id", referencedColumnName="id")
    @ApiModelProperty(notes = "userExam")
    private UserExam userExam;

    @OneToOne( mappedBy = "userExamQuestion",fetch = FetchType.LAZY)
    @ApiModelProperty(notes = "examQuestionNormalAnswer")
    private UserExamQuestionNormalAnswer examQuestionNormalAnswer;



}
