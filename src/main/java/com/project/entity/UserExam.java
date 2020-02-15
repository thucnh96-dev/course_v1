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
import java.math.BigDecimal;
import java.util.Date;



@Entity
@Table(name="TB_USER_EXAM")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper=false)
public class UserExam extends AbtractEntity {
	
	@Id
	@Column(name="id", columnDefinition = "INTEGER")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "ID")
    private Long id;

	@Column(name="immediately_result")
	@NotNull
	@ApiModelProperty(notes = "immediatelyResult")
    private boolean immediatelyResult = true;

	
	@Column(name="expect_point", columnDefinition = "DECIMAL")
	@ApiModelProperty(notes =  "expectPoint")
    private BigDecimal expectPoint = BigDecimal.ZERO;
	
	@Column(name="completed_At")
    @Temporal(TemporalType.TIMESTAMP)
    @ApiModelProperty(notes = "completedAt")
    private Date completedAt;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName="id")
	@JsonIgnore
	@ApiModelProperty(notes = "user")
    private User user;

	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exam_Id", referencedColumnName="id")
	@JsonIgnore
	@ApiModelProperty(notes = "exam")
    private Exam exam;

    @Column(name="question_code")
    @ApiModelProperty(notes = "questionCode")
    private String questionCode;

	public boolean isCompleted() {
		return this.completedAt != null;
	}

}
