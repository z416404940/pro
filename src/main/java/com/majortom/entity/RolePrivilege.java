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
@Table ( name ="role_privilege" )
public class RolePrivilege  implements Serializable {
	public RolePrivilege(Long roleId, Long privilegeId) {
		this.roleId = roleId;
		this.privilegeId = privilegeId;
	}

	public RolePrivilege() {
	}

	private static final long serialVersionUID =  6828012817543737214L;

	@PrimaryKey
	@Column(name = "role_id" )
	private Long roleId;

   	@Column(name = "privilege_id" )
	private Long privilegeId;

}
