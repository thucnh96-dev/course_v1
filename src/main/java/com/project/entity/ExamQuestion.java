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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * 시험의 문항 관계 엔티티
 * Question_Order : 문항 순서
 * Question_Point : 문항 배점
 * @version 0.0.1 01 Oct 2018
 * @author EnjoyWorks
 */
@Entity
@Table(name="TB_EXAM_QUESTION")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper=false)
public class ExamQuestion extends AbtractEntity {
	
	@Id
	@Column(name="Id", columnDefinition = "INTEGER")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "관계 ID")
    private Long id;

    @Column(name="code")
	private String code;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exam_id", referencedColumnName="id")
	@JsonIgnore
	@ApiModelProperty(notes = "exam")
    private Exam exam;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Question_Id", referencedColumnName="id")
	@JsonIgnore
	@ApiModelProperty(notes = "문항")
    private Question question;


}
