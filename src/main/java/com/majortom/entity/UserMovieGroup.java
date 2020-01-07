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
@Table ( name ="user_movie_group" )
public class UserMovieGroup  implements Serializable {
	public UserMovieGroup(Long iId, Long mId, Integer type) {
		this.iId = iId;
		this.mId = mId;
		this.type = type;
	}

	public UserMovieGroup() {
	}

	private static final long serialVersionUID =  1903096417692561143L;

	@PrimaryKey
	@Column(name = "i_id" )
	private Long iId;

   	@Column(name = "m_id" )
	private Long mId;

   	@Column(name = "type" )
	private Integer type;

}
