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
@Table ( name ="history_log" )
public class HistoryLog  implements Serializable {
	public HistoryLog(Long hIId, Long iId, Date logTime, Long logIp) {
		this.hIId = hIId;
		this.iId = iId;
		this.logTime = logTime;
		this.logIp = logIp;
	}

	public HistoryLog() {
	}

	private static final long serialVersionUID =  6254724446370890459L;

	@PrimaryKey
	@Column(name = "h_i_id" )
	private Long hIId;

   	@Column(name = "i_id" )
	private Long iId;

   	@Column(name = "log_time" )
	private Date logTime;

   	@Column(name = "log_ip" )
	private Long logIp;

}
