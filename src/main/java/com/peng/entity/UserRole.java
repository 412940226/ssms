package com.peng.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Table(name="sys_users_roles")
public class UserRole implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id")
	private long id;
	private long userid;
	private long roleid;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createtime;
	private String createby;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date updatetime;
	private String updateby;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public long getRoleid() {
		return roleid;
	}
	public void setRoleid(long roleid) {
		this.roleid = roleid;
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
	@Override
	public String toString() {
		return "UserRole [id=" + id + ", userid=" + userid + ", roleid=" + roleid + ", createtime=" + createtime
				+ ", createby=" + createby + ", updatetime=" + updatetime + ", updateby=" + updateby + "]";
	}
	
}
