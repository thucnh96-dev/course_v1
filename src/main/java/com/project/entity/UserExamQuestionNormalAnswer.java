/* 
 * Copyright 2017 Hunet
 * EULA 라이센스에 의거하여 라이센스가 부여됩니다.
 * 귀하는 라이센스를 준수하는 경우를 제외하고는 이 파일을 사용할 수 없습니다.
 * 귀하는 라이센스의 사본을 다음의 주소에서 확인 가능합니다.
 * http://www.trusteer.com/en/support/end-user-license-agreement
 */

package com.project.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;


/**
 * 회원의 시험 - 문항 주관식 응답
 * User_Answer : 회원의 답
 * @version 0.0.1 05 Oct 2018
 * @author EnjoyWorks
 */
@Entity
@Table(name="TB_USER_EQ_NO_ANSWER")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserExamQuestionNormalAnswer extends AbtractEntity{
	
	@Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "ID")
    private Long id;
	
	@Column(name="user_answer")
	@Size(max=255)
	@ApiModelProperty(notes = "회원의 답")
    private String userAnswer;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_exam_question_id")
	@MapsId
	@ApiModelProperty(notes = "userExamQuestion")
    private UserExamQuestion userExamQuestion;

}
