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
@Table ( name ="message" )
public class Message  implements Serializable {
	public Message(Long messageId, Long bindId, String title, String contentText, Integer type) {
		this.messageId = messageId;
		this.bindId = bindId;
		this.title = title;
		this.contentText = contentText;
		this.type = type;
	}

	public Message() {
	}

	private static final long serialVersionUID =  5852746588176390711L;

	@PrimaryKey
	@Column(name = "message_id" )
	private Long messageId;

   	@Column(name = "bind_id" )
	private Long bindId;

   	@Column(name = "title" )
	private String title;

   	@Column(name = "content_text" )
	private String contentText;

   	@Column(name = "type" )
	private Integer type;

}
