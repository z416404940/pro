package com.majortom.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

import com.majortom.annotation.PrimaryKey;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Description  
 * @Author  Hunter
 * @Date 2020-01-02 
 */

@Setter
@Getter
@ToString
@Entity
@Table ( name ="objective" )
public class Objective  implements Serializable {
	public Objective(Long sSId, String questionText, String choiceA, Long scoreA, String choiceB, Long scoreB, String choiceC, Long scoreC, String choiceD, Long scoreD, Integer type) {
		this.sSId = sSId;
		this.questionText = questionText;
		this.choiceA = choiceA;
		this.scoreA = scoreA;
		this.choiceB = choiceB;
		this.scoreB = scoreB;
		this.choiceC = choiceC;
		this.scoreC = scoreC;
		this.choiceD = choiceD;
		this.scoreD = scoreD;
		this.type = type;
	}

	public Objective() {
	}

	private static final long serialVersionUID =  7025199684121527075L;

	@PrimaryKey
	@Column(name = "s_s_id" )
	private Long sSId;

   	@Column(name = "question_text" )
	private String questionText;

   	@Column(name = "choice_a" )
	private String choiceA;

   	@Column(name = "score_a" )
	private Long scoreA;

   	@Column(name = "choice_b" )
	private String choiceB;

   	@Column(name = "score_b" )
	private Long scoreB;

   	@Column(name = "choice_c" )
	private String choiceC;

   	@Column(name = "score_c" )
	private Long scoreC;

   	@Column(name = "choice_d" )
	private String choiceD;

   	@Column(name = "score_d" )
	private Long scoreD;

   	@Column(name = "type" )
	private Integer type;

}
