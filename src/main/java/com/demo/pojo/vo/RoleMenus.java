package com.demo.pojo.vo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "sys_role_menus") //对应数据库表名
public class RoleMenus {
	
	@Id // 表明此列为主键
	@GeneratedValue(strategy = GenerationType.IDENTITY) //主键生成规则,当你使用它的添加方法时会用到
	@Column(name = "id") //数据库的字段名
	private Integer id;
	
	@Column(name = "role_id")
	private Integer roleId;
	
	@Column(name = "menu_id")
	private Integer menuId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
}