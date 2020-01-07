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
@Table ( name ="comment" )
public class Comment  implements Serializable {
	public Comment(Long commentId, Long bindId, Long publishId, String contentText, Date publishTime, Long likedCount, Integer type) {
		this.commentId = commentId;
		this.bindId = bindId;
		this.publishId = publishId;
		this.contentText = contentText;
		this.publishTime = publishTime;
		this.likedCount = likedCount;
		this.type = type;
	}

	public Comment() {
	}

	private static final long serialVersionUID =  5924698603287087665L;

	@PrimaryKey
	@Column(name = "comment_id" )
	private Long commentId;

   	@Column(name = "bind_id" )
	private Long bindId;

   	@Column(name = "publish_id" )
	private Long publishId;

   	@Column(name = "content_text" )
	private String contentText;

   	@Column(name = "publish_time" )
	private Date publishTime;

   	@Column(name = "liked_count" )
	private Long likedCount;

   	@Column(name = "type" )
	private Integer type;

}
