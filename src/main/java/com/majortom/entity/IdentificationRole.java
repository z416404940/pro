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
@Table ( name ="identification_role" )
public class IdentificationRole  implements Serializable {
	public IdentificationRole(Long iId, Long roleId) {
		this.iId = iId;
		this.roleId = roleId;
	}

	public IdentificationRole() {
	}

	private static final long serialVersionUID =  9019849207443752523L;

	@PrimaryKey
	@Column(name = "i_id" )
	private Long iId;

   	@Column(name = "role_id" )
	private Long roleId;

}
