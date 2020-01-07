package com.majortom.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

import com.majortom.annotation.PrimaryKey;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.Date;

/**
 * @Description  
 * @Author  Hunter
 * @Date 2020-01-02 
 */

@Setter
@Getter
@ToString
@Entity
@Table ( name ="expression" )
public class Expression  implements Serializable {
	public Expression(Long expressionId, Long bindId, Date publishTime, String contentText, Long commentCount, Long likedCount, Long forwardCount, Integer type) {
		this.expressionId = expressionId;
		this.bindId = bindId;
		this.publishTime = publishTime;
		this.contentText = contentText;
		this.commentCount = commentCount;
		this.likedCount = likedCount;
		this.forwardCount = forwardCount;
		this.type = type;
	}

	public Expression() {
	}

	private static final long serialVersionUID =  2744466156549767503L;

	@PrimaryKey
	@Column(name = "expression_id" )
	private Long expressionId;

   	@Column(name = "bind_id" )
	private Long bindId;

   	@Column(name = "publish_time" )
	private Date publishTime;

   	@Column(name = "content_text" )
	private String contentText;

   	@Column(name = "comment_count" )
	private Long commentCount;

   	@Column(name = "liked_count" )
	private Long likedCount;

   	@Column(name = "forward_count" )
	private Long forwardCount;

   	@Column(name = "type" )
	private Integer type;

}
