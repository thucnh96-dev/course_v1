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
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name="TB_EXAM")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper=false)
public class Exam extends AbtractEntity {
	
	@Id
	@Column(name="id", columnDefinition = "SMALLINT")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "ID")
    private Long id;
	
	@Column(name="Title")
	@NotNull
	@Size(min=1, max=255)
	@ApiModelProperty(notes = "title")
    private String title;

	@Column(name="start_At")
    @Temporal(TemporalType.TIMESTAMP)
    @ApiModelProperty(notes = "startAt")
    private Date startAt;
	
	@Column(name="end_At")
    @Temporal(TemporalType.TIMESTAMP)
    @ApiModelProperty(notes = "endAt")
    private Date endAt;
	
	@Column(name="announce_At")
    @Temporal(TemporalType.TIMESTAMP)
    @ApiModelProperty(notes = "announceAt")
    private Date announceAt;
	
	@Column(name="question_average_time", columnDefinition = "SMALLINT")
	@ApiModelProperty(notes = "questionAverageTime")
    private Integer questionAverageTime = 60;

	@Column(name="exam_cutoff_time", columnDefinition = "SMALLINT")
	@ApiModelProperty(notes = "examCutoffTime")
    private boolean examCutoffTime ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName="id")
    @JsonIgnore
    @ApiModelProperty(notes = "user")
    private User user;

    @OneToMany(mappedBy = "exam",fetch = FetchType.LAZY,orphanRemoval = true)
    List<ExamQuestion> examQuestions = new ArrayList<>();

}
