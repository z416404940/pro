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
@Table ( name ="group_history_activity" )
public class GroupHistoryActivity  implements Serializable {
	public GroupHistoryActivity() {
	}

	public GroupHistoryActivity(Long hAId, Long mId, Long aId) {
		this.hAId = hAId;
		this.mId = mId;
		this.aId = aId;
	}

	private static final long serialVersionUID =  2188534828623696641L;

	@PrimaryKey
	@Column(name = "h_a_id" )
	private Long hAId;

   	@Column(name = "m_id" )
	private Long mId;

   	@Column(name = "a_id" )
	private Long aId;

}
