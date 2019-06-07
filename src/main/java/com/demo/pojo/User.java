package com.demo.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * User实体类
 * @author Administrator
 *
 */
@Table(name = "sys_users") //对应数据库表名
public class User implements Serializable {
	/**实现序列化接口，生成序列号ID*/
	private static final long serialVersionUID = -3720062967489912501L;
	/**ID号*/
	@Id // 表明此列为主键
	@Column(name = "id") //数据库的字段名
	@GeneratedValue(strategy = GenerationType.IDENTITY) //主键生成规则,当你使用它的添加方法时会用到
	private Integer id;
	/**用户名*/
	@Column(name = "username")
	private String username;
	/**密码*/
	@Column(name = "password")
	private String password;
	/**盐值*/
	@Column(name = "salt")
	private String salt;
	/**邮箱*/
	//@Transient//忽略该字段,也就是该字段在表中不存在
	@Column(name = "email")
	private String email;
	/**电话号码*/
	@Column(name = "mobile")
	private String mobile;
	/**合法性等于1*/
	@Column(name = "valid")
	private Integer valid = 1;
	/**部门id*/
	@Column(name = "deptId")
	private Integer deptId;
	/**创建时间*/
	//@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "createdTime")
	private Date createdTime;
	/**修改时间*/
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "modifiedTime")
	private Date modifiedTime;
	/**创建用户*/
	@Column(name = "createdUser")
	private String createdUser;
	/**修改用户*/
	@Column(name = "modifiedUser")
	private String modifiedUser;
	
	/* getter/setter */
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Integer getValid() {
		return valid;
	}
	public void setValid(Integer valid) {
		this.valid = valid;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public Date getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	public String getCreatedUser() {
		return createdUser;
	}
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}
	public String getModifiedUser() {
		return modifiedUser;
	}
	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}
}