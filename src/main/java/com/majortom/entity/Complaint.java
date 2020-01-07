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
@Table ( name ="complaint" )
public class Complaint  implements Serializable {
	public Complaint(Long complaintId, Long toComplaintId, Long bindId, Integer type, Long contentId, Integer dispose) {
		this.complaintId = complaintId;
		this.toComplaintId = toComplaintId;
		this.bindId = bindId;
		this.type = type;
		this.contentId = contentId;
		this.dispose = dispose;
	}

	public Complaint() {
	}

	private static final long serialVersionUID =  7060479083448165153L;

	@PrimaryKey
	@Column(name = "complaint_id" )
	private Long complaintId;

   	@Column(name = "to_complaint_id" )
	private Long toComplaintId;

   	@Column(name = "bind_id" )
	private Long bindId;

   	@Column(name = "type" )
	private Integer type;

   	@Column(name = "content_id" )
	private Long contentId;

   	@Column(name = "dispose" )
	private Integer dispose;

}
