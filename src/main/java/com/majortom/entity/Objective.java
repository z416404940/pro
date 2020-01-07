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
 * @Date 2020-01-07 
 */

@Setter
@Getter
@ToString
@Entity
@Table ( name ="objective" )
public class Objective  implements Serializable {

	private static final long serialVersionUID =  6442929735611129279L;

    public Objective() {
    }

    public Objective(Long sSId, String questionText, String choiceA, Long typeA, String choiceB, Long typeB, String choiceC, Long typeC, String choiceD, Long typeD, Long aId) {
        this.sSId = sSId;
        this.questionText = questionText;
        this.choiceA = choiceA;
        this.typeA = typeA;
        this.choiceB = choiceB;
        this.typeB = typeB;
        this.choiceC = choiceC;
        this.typeC = typeC;
        this.choiceD = choiceD;
        this.typeD = typeD;
        this.aId = aId;
    }

    @PrimaryKey
   	@Column(name = "s_s_id" )
	private Long sSId;

   	@Column(name = "question_text" )
	private String questionText;

   	@Column(name = "choice_a" )
	private String choiceA;

   	@Column(name = "type_a" )
	private Long typeA;

   	@Column(name = "choice_b" )
	private String choiceB;

   	@Column(name = "type_b" )
	private Long typeB;

   	@Column(name = "choice_c" )
	private String choiceC;

   	@Column(name = "type_c" )
	private Long typeC;

   	@Column(name = "choice_d" )
	private String choiceD;

   	@Column(name = "type_d" )
	private Long typeD;

   	@Column(name = "a_id" )
	private Long aId;

}
