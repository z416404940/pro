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
@Table ( name ="history_browse" )
public class HistoryBrowse  implements Serializable {
	public HistoryBrowse(Long hBId, Long iId, Long bindId, Integer type, Date browseTime) {
		this.hBId = hBId;
		this.iId = iId;
		this.bindId = bindId;
		this.type = type;
		this.browseTime = browseTime;
	}

	public HistoryBrowse() {
	}

	private static final long serialVersionUID =  5362957978793510394L;

	@PrimaryKey
	@Column(name = "h_b_id" )
	private Long hBId;

   	@Column(name = "i_id" )
	private Long iId;

   	@Column(name = "bind_id" )
	private Long bindId;

   	@Column(name = "type" )
	private Integer type;

   	@Column(name = "browse_time" )
	private Date browseTime;

}
