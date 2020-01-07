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
@Table ( name ="menu" )
public class Menu  implements Serializable {
	public Menu(Long menuId, String name, String menuUrl, Long parentId) {
		this.menuId = menuId;
		this.name = name;
		this.menuUrl = menuUrl;
		this.parentId = parentId;
	}

	public Menu() {
	}

	private static final long serialVersionUID =  7293551359910985432L;

	@PrimaryKey
	@Column(name = "menu_id" )
	private Long menuId;

   	@Column(name = "name" )
	private String name;

   	@Column(name = "menu_url" )
	private String menuUrl;

   	@Column(name = "parent_id" )
	private Long parentId;

}
