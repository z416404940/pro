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
@Table ( name ="folder_privilege" )
public class FolderPrivilege  implements Serializable {
	public FolderPrivilege(Long folderId, Long privilegeId) {
		this.folderId = folderId;
		this.privilegeId = privilegeId;
	}

	public FolderPrivilege() {
	}

	private static final long serialVersionUID =  3036677849497762827L;

	@PrimaryKey
	@Column(name = "folder_id" )
	private Long folderId;

   	@Column(name = "privilege_id" )
	private Long privilegeId;

}
