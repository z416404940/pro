package com.majortom.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table ( name ="images" )
public class Images  implements Serializable {
	public Images(Long cIId, Long bindId, Integer type, String imgUrl) {
		this.cIId = cIId;
		this.bindId = bindId;
		this.type = type;
		this.imgUrl = imgUrl;
	}

	public Images() {
	}

	private static final long serialVersionUID =  6714990637357037238L;

	@PrimaryKey
   	@Column(name = "c_i_id" )
	private Long cIId;

   	@Column(name = "bind_id" )
	private Long bindId;

   	@Column(name = "type" )
	private Integer type;

   	@Column(name = "img_url" )
	private String imgUrl;

}
