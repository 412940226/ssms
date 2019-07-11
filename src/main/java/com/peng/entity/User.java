package com.peng.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Table(name="sys_users")
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id")
	private long id;
	private String username;
	private String password;
	private String salt;
	private int status;
	private String realname;
	private String email;
	private String mobile;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createtime;
	private String createby;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date updatetime;
	private String updateby;
	private String remarks;
	
	private List<Long> roleids;//一个用户可以多个角色

	public long getId() {
		return id;
	}


	public void setId(long id) {
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


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public String getRealname() {
		return realname;
	}


	public void setRealname(String realname) {
		this.realname = realname;
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


	public Date getCreatetime() {
		return createtime;
	}


	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}


	public String getCreateby() {
		return createby;
	}


	public void setCreateby(String createby) {
		this.createby = createby;
	}


	public Date getUpdatetime() {
		return updatetime;
	}


	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}


	public String getUpdateby() {
		return updateby;
	}


	public void setUpdateby(String updateby) {
		this.updateby = updateby;
	}


	public String getRemarks() {
		return remarks;
	}


	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


	public List<Long> getRoleids() {
		return roleids;
	}


	public void setRoleids(List<Long> roleids) {
		this.roleids = roleids;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", salt=" + salt + ", status="
				+ status + ", realname=" + realname + ", email=" + email + ", mobile=" + mobile + ", createtime="
				+ createtime + ", createby=" + createby + ", updatetime=" + updatetime + ", updateby=" + updateby
				+ ", remarks=" + remarks + "]";
	}
	
}
