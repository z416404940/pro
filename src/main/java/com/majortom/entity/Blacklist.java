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
@Table ( name ="blacklist" )
public class Blacklist  implements Serializable {

	private static final long serialVersionUID =  362725661646740261L;

	public Blacklist(Long blacklistId, Long iId, Long id, Date time, int type) {
		this.blacklistId = blacklistId;
		this.iId = iId;
		this.id = id;
		this.time = time;
		this.type = type;
	}

	public Blacklist() {
	}

	@PrimaryKey
	@Column(name = "blacklist_id" )
	private Long blacklistId;

   	@Column(name = "i_id" )
	private Long iId;

   	@Column(name = "id" )
	private Long id;

   	@Column(name = "time" )
	private Date time;

	@Column(name = "type" )
	private int type;

}
