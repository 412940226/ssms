package com.peng.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Table(name="sys_permissions")
public class Permissions implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id")
	private long id;
	private String name;
	private String url;
	private String perms;
	private int type;
	private String icon;
	private int ordernum;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createtime;
	private String createby;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date updatetime;
	private String updateby;
	private String remarks;
	private String parentid;
	private String parentids;
	private String isdelete;
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public String getPerms() {
		return perms;
	}
	public void setPerms(String perms) {
		this.perms = perms;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public int getOrdernum() {
		return ordernum;
	}
	public void setOrdernum(int ordernum) {
		this.ordernum = ordernum;
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
	public String getParentid() {
		return parentid;
	}
	public void setParentid(String parentid) {
		this.parentid = parentid;
	}
	public String getParentids() {
		return parentids;
	}
	public void setParentids(String parentids) {
		this.parentids = parentids;
	}
	public String getIsdelete() {
		return isdelete;
	}
	public void setIsdelete(String isdelete) {
		this.isdelete = isdelete;
	}
	@Override
	public String toString() {
		return "Permissions [id=" + id + ", name=" + name + ", url=" + url + ", perms=" + perms + ", type=" + type
				+ ", icon=" + icon + ", ordernum=" + ordernum + ", createtime=" + createtime + ", createby=" + createby
				+ ", updatetime=" + updatetime + ", updateby=" + updateby + ", remarks=" + remarks + ", parentid="
				+ parentid + ", parentids=" + parentids + ", isdelete=" + isdelete + "]";
	}
	
}
