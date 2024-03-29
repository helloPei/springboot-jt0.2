package com.demo.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Table(name = "sys_menus")
public class Menu implements Serializable{
	
	private static final long serialVersionUID = -8805983256624854549L;
	
	/**菜单ID*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	/**菜单名称*/
	@Column(name = "name")
	private String  name;
	
	/**菜单对应的url*/
	@Column(name = "url")
	private String  url;
	
	/**菜单类型(按钮还是普通列表)*/
	@Column(name = "type")
	private Integer type;
	
	/**菜单顺序号*/
	@Column(name = "sort")
	private Integer sort;
	
	/**备注*/
	@Column(name = "note")
	private String  note;
	
	/**上级菜单id*/
	@Column(name = "parentId")
	private Integer parentId;
	
	/**资源标识(访问此菜单的权限标识)*/
	@Column(name = "permission")
	private String  permission;
	
	/**创建日期*/
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "createdTime")
	private Date createdTime;
	
	/**修改日期*/
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "modifiedTime")
    private Date modifiedTime;
	
	/**创建用户*/
	@Column(name = "createdUser")
    private String createdUser;
	
	/**修改用户*/
	@Column(name = "modifiedUser")
    private String modifiedUser;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
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