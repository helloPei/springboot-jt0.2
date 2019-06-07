package com.demo.pojo.vo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.demo.pojo.Role;
@Table(name = "sys_role_menus") //对应数据库表名
public class RoleMenuResult {
	@Id // 表明此列为主键
	@GeneratedValue(strategy = GenerationType.IDENTITY) //主键生成规则,当你使用它的添加方法时会用到
	@Column(name = "id") //数据库的字段名
	private Integer id;
	/**角色对象*/
	@Column(name = "role_id")
	private Role role;
	/**角色对应的菜单*/
	@Column(name = "menu_id")
	private List<Integer> menuIds;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public List<Integer> getMenuIds() {
		return menuIds;
	}
	public void setMenuIds(List<Integer> menuIds) {
		this.menuIds = menuIds;
	}
}