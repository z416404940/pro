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
@Table ( name ="videos" )
public class Videos  implements Serializable {
	public Videos(Long vId, Long cIId, String name, String intro) {
		this.vId = vId;
		this.cIId = cIId;
		this.name = name;
		this.intro = intro;
	}

	public Videos() {
	}

	private static final long serialVersionUID =  8772518301776583201L;

	@PrimaryKey
	@Column(name = "v_id" )
	private Long vId;

   	@Column(name = "c_i_id" )
	private Long cIId;

   	@Column(name = "name" )
	private String name;

   	@Column(name = "intro" )
	private String intro;

}
