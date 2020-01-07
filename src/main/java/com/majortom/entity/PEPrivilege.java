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
@Table ( name ="p_e_privilege" )
public class PEPrivilege  implements Serializable {
	public PEPrivilege(Long pEId, Long privilegeId) {
		this.pEId = pEId;
		this.privilegeId = privilegeId;
	}

	public PEPrivilege() {
	}

	private static final long serialVersionUID =  5007816470931533769L;

	@PrimaryKey
	@Column(name = "p_e_id" )
	private Long pEId;

   	@Column(name = "privilege_id" )
	private Long privilegeId;

}
