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
@Table ( name ="user_config" )
public class UserConfig  implements Serializable {
	public UserConfig(Long uCId, Long iId) {
		this.uCId = uCId;
		this.iId = iId;
	}

	public UserConfig() {
	}

	private static final long serialVersionUID =  5908743828178504677L;

	@PrimaryKey
	@Column(name = "u_c_id" )
	private Long uCId;

   	@Column(name = "i_id" )
	private Long iId;

}
