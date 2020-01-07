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
@Table ( name ="movie_group" )
public class MovieGroup  implements Serializable {
	public MovieGroup(Long mGId, Long mInfoId, Long level, Long yMoney) {
		this.mGId = mGId;
		this.mInfoId = mInfoId;
		this.level = level;
		this.yMoney = yMoney;
	}

	public MovieGroup() {
	}

	private static final long serialVersionUID =  6847124288630324847L;

	@PrimaryKey
	@Column(name = "m_g_id" )
	private Long mGId;

   	@Column(name = "m_info_id" )
	private Long mInfoId;

   	@Column(name = "level" )
	private Long level;

   	@Column(name = "y_money" )
	private Long yMoney;

}
