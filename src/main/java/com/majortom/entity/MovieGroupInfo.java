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
@Table ( name ="movie_group_info" )
public class MovieGroupInfo  implements Serializable {
	public MovieGroupInfo(Long mInfoId, Long cIId, String name, String autograph, String synopsis, Date registerTime, String activeCity) {
		this.mInfoId = mInfoId;
		this.cIId = cIId;
		this.name = name;
		this.autograph = autograph;
		this.synopsis = synopsis;
		this.registerTime = registerTime;
		this.activeCity = activeCity;
	}

	public MovieGroupInfo() {
	}

	private static final long serialVersionUID =  2291556671011223178L;

	@PrimaryKey
	@Column(name = "m_info_id" )
	private Long mInfoId;

   	@Column(name = "c_i_id" )
	private Long cIId;

   	@Column(name = "name" )
	private String name;

   	@Column(name = "autograph" )
	private String autograph;

   	@Column(name = "synopsis" )
	private String synopsis;

   	@Column(name = "register_time" )
	private Date registerTime;

   	@Column(name = "active_city" )
	private String activeCity;

}
