package com.demo.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
@Table(name = "sys_roles") //对应数据库表名
public class Role implements Serializable{
	private static final long serialVersionUID = -2113802202295967078L;
	@Id // 表明此列为主键
	@Column(name = "id") //数据库的字段名
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 主键生成规则,当你使用它的添加方法时会用到
	private Integer id;
	@Column(name = "name")
	private String name;
	@Column(name = "note")
	private String note;
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "createdTime")
	private Date createdTime;
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "modifiedTime")
	private Date modifiedTime;
	@Column(name = "createdUser")
	private String createdUser;
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
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
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