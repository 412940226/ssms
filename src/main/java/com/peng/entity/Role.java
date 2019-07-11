package com.peng.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Table(name="sys_roles")
public class Role implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id")
	private long id;
	private String rolename;
	private String rolekey;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createtime;
	private String createby;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date updatetime;
	private String updateby;
	private String remarks;
	
	private List<Long> permissionsids;//一个角色可以多个权限
	
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getRolename() {
		return rolename;
	}


	public void setRolename(String rolename) {
		this.rolename = rolename;
	}


	public String getRolekey() {
		return rolekey;
	}


	public void setRolekey(String rolekey) {
		this.rolekey = rolekey;
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


	public List<Long> getPermissionsids() {
		return permissionsids;
	}


	public void setPermissionsids(List<Long> permissionsids) {
		this.permissionsids = permissionsids;
	}


	@Override
	public String toString() {
		return "Role [id=" + id + ", rolename=" + rolename + ", rolekey=" + rolekey + ", createtime=" + createtime
				+ ", createby=" + createby + ", updatetime=" + updatetime + ", updateby=" + updateby + ", remarks="
				+ remarks + "]";
	}
	
}
