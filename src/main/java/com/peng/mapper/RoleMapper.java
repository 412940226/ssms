package com.peng.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.peng.entity.Role;

public interface RoleMapper {
	
	@Select("SELECT id, rolename, createtime, createby, updatetime, updateby, remarks FROM sys_roles")
	@Results({ @Result(property = "id", column = "id"), @Result(property = "rolename", column = "rolename") })
	List<Role> listRole();
	
	@Delete("DELETE FROM sys_roles WHERE id=#{id}")
	int remove(Long id);
	
	@Select("SELECT id, rolename, rolekey, createtime, createby, updatetime, updateby, remarks FROM sys_roles where id = #{id}")
	@Results({ @Result(property = "id", column = "id"), @Result(property = "rolename", column = "rolename") })
	Role get(Long id);
	
	@Insert("INSERT INTO sys_roles(rolename, rolekey, createtime, createby, remarks)VALUES(#{rolename}, #{rolekey}, #{createtime}, #{createby}, #{remarks})")
	int save(Role role);
	
	@Update("update sys_roles set rolename = #{rolename}, remarks=#{remarks} where id=#{id}")
	int update(Role role);
	
}
