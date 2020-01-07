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
@Table ( name ="collection" )
public class Collection  implements Serializable {

	private static final long serialVersionUID =  8023580059540024912L;

	public Collection(Long collectionId, Long iId, Integer type, Long folderId, Date time, Long bindId) {
		this.collectionId = collectionId;
		this.iId = iId;
		this.type = type;
		this.folderId = folderId;
		this.time = time;
		this.bindId = bindId;
	}

	public Collection() {
	}

	@PrimaryKey
	@Column(name = "collection_id" )
	private Long collectionId;

   	@Column(name = "i_id" )
	private Long iId;

   	@Column(name = "type" )
	private Integer type;

   	@Column(name = "folder_id" )
	private Long folderId;

   	@Column(name = "time" )
	private Date time;

   	@Column(name = "bind_id" )
	private Long bindId;

}
