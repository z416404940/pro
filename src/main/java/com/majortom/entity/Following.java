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
@Table ( name ="following" )
public class Following  implements Serializable {
	public Following(Long followingId, Long iId, Long bindId, Integer type, Date time) {
		this.followingId = followingId;
		this.iId = iId;
		this.bindId = bindId;
		this.type = type;
		this.time = time;
	}

	public Following() {
	}

	private static final long serialVersionUID =  5877671010522377710L;

	@PrimaryKey
	@Column(name = "following_id" )
	private Long followingId;

   	@Column(name = "i_id" )
	private Long iId;

   	@Column(name = "bind_id" )
	private Long bindId;

   	@Column(name = "type" )
	private Integer type;

   	@Column(name = "time" )
	private Date time;

}
