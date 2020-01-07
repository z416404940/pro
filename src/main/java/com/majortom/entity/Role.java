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
@Table ( name ="role" )
public class Role  implements Serializable {
	public Role(Long roleId, String name, String displayName, Date createData, String description) {
		this.roleId = roleId;
		this.name = name;
		this.displayName = displayName;
		this.createData = createData;
		this.description = description;
	}

	public Role() {
	}

	private static final long serialVersionUID =  6079184399160159127L;

	/**
	 * id
	 */
	@PrimaryKey
	@Column(name = "role_id" )
	private Long roleId;

	/**
	 * 名称
	 */
   	@Column(name = "name" )
	private String name;

	/**
	 * 显示名
	 */
   	@Column(name = "display_name" )
	private String displayName;

	/**
	 * 创建时间
	 */
   	@Column(name = "create_data" )
	private Date createData;

	/**
	 * 描述
	 */
   	@Column(name = "description" )
	private String description;

}
