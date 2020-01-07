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
import java.util.List;

/**
 * @Description  
 * @Author  Hunter
 * @Date 2020-01-02 
 */

@Setter
@Getter
@ToString
@Entity
@Table ( name ="user" )
public class User  implements Serializable {

	private static final long serialVersionUID =  6536335674903497764L;

	public User(Long userId, String userName, Integer gender, Long age, Date birthday, String tel, String email, String address, String idNum, String nickName, String password) {
		this.userId = userId;
		this.userName = userName;
		this.gender = gender;
		this.age = age;
		this.birthday = birthday;
		this.tel = tel;
		this.email = email;
		this.address = address;
		this.idNum = idNum;
		this.nickName = nickName;
		this.password = password;
	}

	public User() {
	}

	/**
	 * 用户id
	 */
	@PrimaryKey
   	@Column(name = "user_id" )
	private Long userId;

	/**
	 * 用户名称
	 */
   	@Column(name = "user_name" )
	private String userName;

	/**
	 * 用户性别
	 */
   	@Column(name = "gender" )
	private Integer gender;

	/**
	 * 年龄
	 */
   	@Column(name = "age" )
	private Long age;

	/**
	 * 生日
	 */
   	@Column(name = "birthday" )
	private Date birthday;

	/**
	 * 电话
	 */
   	@Column(name = "tel" )
	private String tel;

	/**
	 * 邮箱
	 */
   	@Column(name = "email" )
	private String email;

	/**
	 * 地址
	 */
   	@Column(name = "address" )
	private String address;

	/**
	 * 身份证号
	 */
   	@Column(name = "id_num" )
	private String idNum;

	/**
	 * 昵称
	 */
   	@Column(name = "nick_name" )
	private String nickName;

	/**
	 * 密码
	 */
   	@Column(name = "password" )
	private String password;
	/**
	 * 权限列表
	 */
	private List<Privilege> privileges;
	/**
	 *  菜单列表
	 */
	private List<Menu> menus;
	/**
	 * 文件夹列表
	 */
	private List<Folder> folders;
	/**
	 * 页面列表
	 */
	private List<PageElements> pageElements;

}
