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
@Table ( name ="punish" )
public class Punish  implements Serializable {
	public Punish(Long punishId, Long violationsId, Date time, Long timeLength, Integer type) {
		this.punishId = punishId;
		this.violationsId = violationsId;
		this.time = time;
		this.timeLength = timeLength;
		this.type = type;
	}

	public Punish() {
	}

	private static final long serialVersionUID =  4777780991026412133L;

	@PrimaryKey
	@Column(name = "punish_id" )
	private Long punishId;

   	@Column(name = "violations_id" )
	private Long violationsId;

   	@Column(name = "time" )
	private Date time;

   	@Column(name = "time_length" )
	private Long timeLength;

   	@Column(name = "type" )
	private Integer type;

}
