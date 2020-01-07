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
@Table ( name ="participant" )
public class Participant  implements Serializable {
	public Participant(Long participanId, Long iId, Long aId, Long aFId, Integer type) {
		this.participanId = participanId;
		this.iId = iId;
		this.aId = aId;
		this.aFId = aFId;
		this.type = type;
	}

	public Participant() {
	}

	private static final long serialVersionUID =  4186071980477807575L;

	@PrimaryKey
	@Column(name = "participan_id" )
	private Long participanId;

   	@Column(name = "i_id" )
	private Long iId;

   	@Column(name = "a_id" )
	private Long aId;

   	@Column(name = "a_f_id" )
	private Long aFId;

   	@Column(name = "type" )
	private Integer type;

}
