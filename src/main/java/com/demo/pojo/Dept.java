package com.demo.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "sys_depts")
public class Dept implements Serializable{
	
	private static final long serialVersionUID = -5259265803332215029L;
	
	/**部门ID*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	/**部门名称*/
	@Column(name = "name")
	private String name;
	
	/**上级部门ID*/
	@Column(name = "parentId")
	private Integer parentId;
	
	/**顺序号*/
	@Column(name = "sort")
	private Integer sort;
	
	/**备注*/
	@Column(name = "note")
	private String note;
	
	/**创建日期*/
	@Column(name = "createdTime")
	private Date createdTime;
	
	/**修改日期*/
	@Column(name = "modifiedTime")
	private Date modifiedTime;
	
	/**创建用户*/
	@Column(name = "createdUser")
	private String createdUser;
	
	/**修改用户*/
	@Column(name = "modifiedUser")
	private String modifiedUser;
	
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
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return "Dept [id=" + id + ", name=" + name + ", parentId=" + parentId + ", sort=" + sort + ", note=" + note+ "]";
	}
}