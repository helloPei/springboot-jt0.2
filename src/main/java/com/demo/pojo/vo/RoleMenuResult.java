package com.demo.pojo.vo;

import java.util.List;

import com.demo.pojo.Role;

public class RoleMenuResult {
	
	private Integer id;
	
	/**角色对象*/
	private Role role;
	
	/**角色对应的菜单*/
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