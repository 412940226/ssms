package com.peng.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Table(name="sys_roles_permissions")
public class RolePermissions implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id")
	private long id;
	private long roleid;
	private long permissionsid;
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
	public long getRoleid() {
		return roleid;
	}
	public void setRoleid(long roleid) {
		this.roleid = roleid;
	}
	public long getPermissionsid() {
		return permissionsid;
	}
	public void setPermissionsid(long permissionsid) {
		this.permissionsid = permissionsid;
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
		return "RolePermissions [id=" + id + ", roleid=" + roleid + ", permissionsid=" + permissionsid + ", createtime="
				+ createtime + ", createby=" + createby + ", updatetime=" + updatetime + ", updateby=" + updateby + "]";
	}
	
}
