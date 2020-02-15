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
import org.springframework.util.StringUtils;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


/**
 * 회원의 학습과정 시험문항 엔티티
 * Answered : 응답여부 - 20181110 추가 (Correct 필드에 null 입력 불가하여 별도의 응답여부 항목 필요)
 * Correct : 정답여부 - '틀린 문제만 보기' 쿼리 대응
 * Duration : 문항에 제한시간 있을 경우 회원의 소요시간 저장
 * Review : 복습 횟수 - 20181217 추가 (오답노트에서 복습 횟수 표시)
 * Wrong_Count : 오답 횟수 - 20181218 추가 (오답노트에서 다시 풀기 옵션)
 * @version 0.0.1 05 Oct 2018
 * @author EnjoyWorks
 */
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

    @OneToOne( mappedBy = "userExamQuestion",fetch = FetchType.LAZY)
    @ApiModelProperty(notes = "examQuestionNormalAnswer")
    private UserExamQuestionNormalAnswer examQuestionNormalAnswer;



}
