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
 * @Date 2020-01-05 
 */

@Setter
@Getter
@ToString
@Entity
@Table ( name ="folder" )
public class Folder  implements Serializable {

	private static final long serialVersionUID =  4158770056606839890L;

	@PrimaryKey
   	@Column(name = "folder_id" )
	private Long folderId;

   	@Column(name = "name" )
	private String name;

   	@Column(name = "i_id" )
	private Long iId;

   	@Column(name = "type" )
	private Long type;

}
