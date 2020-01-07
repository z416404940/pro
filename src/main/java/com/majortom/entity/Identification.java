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
@Table ( name ="identification" )
public class Identification  implements Serializable {
	public Identification(Long iId, Long userId, Long cIId, Long level, String autograph, Date registerTime, Long yMoney) {
		this.iId = iId;
		this.userId = userId;
		this.cIId = cIId;
		this.level = level;
		this.autograph = autograph;
		this.registerTime = registerTime;
		this.yMoney = yMoney;
	}

	public Identification() {
	}

	private static final long serialVersionUID =  7964510569641173383L;
	@PrimaryKey
   	@Column(name = "i_id" )
	private Long iId;

   	@Column(name = "user_id" )
	private Long userId;

   	@Column(name = "c_i_id" )
	private Long cIId;

   	@Column(name = "level" )
	private Long level;

   	@Column(name = "autograph" )
	private String autograph;

   	@Column(name = "register_time" )
	private Date registerTime;

   	@Column(name = "y_money" )
	private Long yMoney;

}
