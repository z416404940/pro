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
@Table ( name ="question" )
public class Question  implements Serializable {
	public Question(Long questionId, String questionText, String contentText, Integer type) {
		this.questionId = questionId;
		this.questionText = questionText;
		this.contentText = contentText;
		this.type = type;
	}

	public Question() {
	}

	private static final long serialVersionUID =  6369175203696396046L;

	@PrimaryKey
	@Column(name = "question_id" )
	private Long questionId;

   	@Column(name = "question_text" )
	private String questionText;

   	@Column(name = "content_text" )
	private String contentText;

   	@Column(name = "type" )
	private Integer type;

}
