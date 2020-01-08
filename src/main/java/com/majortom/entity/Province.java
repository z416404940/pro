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
 * @Date 2020-01-07 
 */

@Setter
@Getter
@ToString
@Entity
@Table ( name ="province" )
public class Province  implements Serializable {

	private static final long serialVersionUID =  1771785743315798817L;

	@PrimaryKey
	@Column(name = "id" )
	private Long id;

   	@Column(name = "name" )
	private String name;

}
