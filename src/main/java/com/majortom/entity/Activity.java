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
 * @Date 2020-01-06 
 */

@Setter
@Getter
@ToString
@Entity
@Table ( name ="activity" )
public class Activity  implements Serializable {

	private static final long serialVersionUID =  3042938276695602821L;

	public Activity() {
	}

	public Activity(Long aId, Long mId, Long vId, Long participanId, String title, Date strartTime, Date strartApplyTime, Date endApplyTime, Date endTime, Date movieStrartTime, Long moiveLength, Date moveEndTime, String city, String cinemaAddress, Long places, String content, String tel) {
		this.aId = aId;
		this.mId = mId;
		this.vId = vId;
		this.participanId = participanId;
		this.title = title;
		this.strartTime = strartTime;
		this.strartApplyTime = strartApplyTime;
		this.endApplyTime = endApplyTime;
		this.endTime = endTime;
		this.movieStrartTime = movieStrartTime;
		this.moiveLength = moiveLength;
		this.moveEndTime = moveEndTime;
		this.city = city;
		this.cinemaAddress = cinemaAddress;
		this.places = places;
		this.content = content;
		this.tel = tel;
	}

	/**
	 * 活动id
	 */
	@PrimaryKey
   	@Column(name = "a_id" )
	private Long aId;

	/**
	 * 观影团id
	 */
   	@Column(name = "m_id" )
	private Long mId;

	/**
	 * 影片id
	 */
   	@Column(name = "v_id" )
	private Long vId;

	/**
	 * 参与者id
	 */
   	@Column(name = "participan_id" )
	private Long participanId;

	/**
	 * 标题
	 */
   	@Column(name = "title" )
	private String title;

	/**
	 * 活动开始时间
	 */
   	@Column(name = "strart_time" )
	private Date strartTime;

	/**
	 * 报名开始时间
	 */
   	@Column(name = "strart_apply_time" )
	private Date strartApplyTime;

	/**
	 * 报名结束时间
	 */
   	@Column(name = "end_apply_time" )
	private Date endApplyTime;

	/**
	 * 活动结束时间
	 */
   	@Column(name = "end_time" )
	private Date endTime;

	/**
	 * 电影开始时间
	 */
   	@Column(name = "movie_strart_time" )
	private Date movieStrartTime;

	/**
	 * 影片时长
	 */
   	@Column(name = "moive_length" )
	private Long moiveLength;

	/**
	 * 电影结束时间
	 */
   	@Column(name = "move_end_time" )
	private Date moveEndTime;

	/**
	 * 所在城市
	 */
   	@Column(name = "city" )
	private String city;

	/**
	 * 影院地址
	 */
   	@Column(name = "cinema_address" )
	private String cinemaAddress;

	/**
	 * 名额
	 */
   	@Column(name = "places" )
	private Long places;

	/**
	 * 内容
	 */
   	@Column(name = "content" )
	private String content;

	/**
	 * 举办人手机号码
	 */
   	@Column(name = "tel" )
	private String tel;

}
