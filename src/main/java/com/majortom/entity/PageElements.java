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
@Table ( name ="page_elements" )
public class PageElements  implements Serializable {
	public PageElements(Long pEId, String name) {
		this.pEId = pEId;
		this.name = name;
	}

	public PageElements() {
	}

	private static final long serialVersionUID =  922208563008835074L;

	@PrimaryKey
	@Column(name = "p_e_id" )
	private Long pEId;

   	@Column(name = "name" )
	private String name;

}
