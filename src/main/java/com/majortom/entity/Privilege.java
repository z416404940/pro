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
@Table ( name ="privilege" )
public class Privilege  implements Serializable {
	public Privilege(Long pId, String type, String description) {
		this.pId = pId;
		this.type = type;
		this.description = description;
	}

	public Privilege() {
	}

	private static final long serialVersionUID =  263906419917476009L;

	@PrimaryKey
	@Column(name = "p_id" )
	private Long pId;

   	@Column(name = "type" )
	private String type;

   	@Column(name = "description" )
	private String description;

}
