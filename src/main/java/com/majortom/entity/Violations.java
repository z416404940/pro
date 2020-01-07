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
@Table ( name ="violations" )
public class Violations  implements Serializable {
	public Violations(Long violationsId, Long bindId, Integer type, String concreteContent, Date violationsTime) {
		this.violationsId = violationsId;
		this.bindId = bindId;
		this.type = type;
		this.concreteContent = concreteContent;
		this.violationsTime = violationsTime;
	}

	public Violations() {
	}

	private static final long serialVersionUID =  1261270277650053114L;

	@PrimaryKey
	@Column(name = "violations_id" )
	private Long violationsId;

   	@Column(name = "bind_id" )
	private Long bindId;

   	@Column(name = "type" )
	private Integer type;

   	@Column(name = "concrete_content" )
	private String concreteContent;

   	@Column(name = "violations_time" )
	private Date violationsTime;

}
