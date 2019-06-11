package com.demo.pojo.vo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "sys_user_roles") //对应数据库表名
public class UserRoles {
	@Id // 表明此列为主键
	@GeneratedValue(strategy = GenerationType.IDENTITY) //主键生成规则,当你使用它的添加方法时会用到
	@Column(name = "id") //数据库的字段名
	private Integer id;
	@Column(name = "user_id")
	private Integer userId;
	@Column(name = "role_id")
	private Integer roleId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
}
