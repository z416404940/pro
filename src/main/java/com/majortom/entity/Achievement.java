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
@Table ( name ="achievement" )
public class Achievement  implements Serializable {

	private static final long serialVersionUID =  8000296755669654042L;

    public Achievement() {
    }

    public Achievement(Long achievementId, Long iId, String name, String description, Integer state) {
        this.achievementId = achievementId;
        this.iId = iId;
        this.name = name;
        this.description = description;
        this.state = state;
    }

    /**
	 * 成就表id
	 */
    @PrimaryKey
    @Column(name = "achievement_id" )
	private Long achievementId;

	/**
	 * 用户id
	 */
   	@Column(name = "i_id" )
	private Long iId;

	/**
	 * 成就名称
	 */
   	@Column(name = "name" )
	private String name;

	/**
	 * 描述
	 */
   	@Column(name = "description" )
	private String description;

	/**
	 * 状态
	 */
   	@Column(name = "state" )
	private Integer state;

}
