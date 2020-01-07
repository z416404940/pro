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
@Table ( name ="menu_privilege" )
public class MenuPrivilege  implements Serializable {
	public MenuPrivilege(Long menuId, Long privilegeId) {
		this.menuId = menuId;
		this.privilegeId = privilegeId;
	}

	public MenuPrivilege() {
	}

	private static final long serialVersionUID =  7718340586805707398L;
	@PrimaryKey
   	@Column(name = "menu_id" )
	private Long menuId;

   	@Column(name = "privilege_id" )
	private Long privilegeId;

}
