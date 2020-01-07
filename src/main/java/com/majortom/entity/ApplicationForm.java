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
@Table ( name ="application_form" )
public class ApplicationForm  implements Serializable {

	private static final long serialVersionUID =  3349388910856126111L;

	public ApplicationForm(Long aFId, Long bindId, Integer type) {
		this.aFId = aFId;
		this.bindId = bindId;
		this.type = type;
	}

	public ApplicationForm() {
	}

	@PrimaryKey
	@Column(name = "a_f_id" )
	private Long aFId;

   	@Column(name = "bind_id" )
	private Long bindId;

   	@Column(name = "type" )
	private Integer type;

}
