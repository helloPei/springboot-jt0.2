package com.demo.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "sys_logs")
public class Log implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**日志ID*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	/**用户名*/
	@Column(name = "username")
	private String username;
	
	/**用户操作**/
	@Column(name = "operation")
	private String operation;
	
	/**请求方法*/
	@Column(name = "method")
	private String method;
	
	/**请求参数*/
	@Column(name = "params")
	private String params;
	
	/**执行时长(毫秒)*/
	@Column(name = "time")
	private Long time;
	
	/**IP地址*/
	@Column(name = "ip")
	private String ip;
	
	/**创建时间*/
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "createdTime")
	private Date createdTime;
	
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsername() {
		return username;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getOperation() {
		return operation;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getMethod() {
		return method;
	}
	public void setParams(String params) {
		this.params = params;
	}
	public String getParams() {
		return params;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getIp() {
		return ip;
	}
	public void setCreateDate(Date createdTime) {
		this.createdTime = createdTime;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public Long getTime() {
		return time;
	}
	public void setTime(Long time) {
		this.time = time;
	}
}