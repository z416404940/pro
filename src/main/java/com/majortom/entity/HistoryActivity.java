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
@Table ( name ="history_activity" )
public class HistoryActivity  implements Serializable {
	public HistoryActivity(Long hAId, Long aId, Long iId, Date hATime, Integer type) {
		this.hAId = hAId;
		this.aId = aId;
		this.iId = iId;
		this.hATime = hATime;
		this.type = type;
	}

	public HistoryActivity() {
	}

	private static final long serialVersionUID =  1757901119932964940L;

	@PrimaryKey
	@Column(name = "h_a_id" )
	private Long hAId;

   	@Column(name = "a_id" )
	private Long aId;

   	@Column(name = "i_id" )
	private Long iId;

   	@Column(name = "h_a_time" )
	private Date hATime;

   	@Column(name = "type" )
	private Integer type;

}
