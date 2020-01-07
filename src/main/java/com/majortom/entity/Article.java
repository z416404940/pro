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
@Table ( name ="article" )
public class Article  implements Serializable {

	private static final long serialVersionUID =  4483033791433840069L;

	public Article() {
	}

	public Article(Long articleId, Long bindId, String title, Date publishTime, String contentText, Long commentCount, Long likedCount, Long forwardCount) {
		this.articleId = articleId;
		this.bindId = bindId;
		this.title = title;
		this.publishTime = publishTime;
		this.contentText = contentText;
		this.commentCount = commentCount;
		this.likedCount = likedCount;
		this.forwardCount = forwardCount;
	}

	@PrimaryKey
	@Column(name = "article_id" )
	private Long articleId;

   	@Column(name = "bind_id" )
	private Long bindId;

   	@Column(name = "title" )
	private String title;

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

}
