package com.peng.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.peng.entity.Permissions;

public interface PermissionsMapper {
	@Select("SELECT  id, name, url, perms, `type`, icon, ordernum, createtime, createby,updatetime,updateby,remarks,parentid FROM sys_permissions where id =#{id}")
	Permissions getPermissions(Long id);
	
	@Delete("delete from sys_permissions where id = #{id}")
	int remove(Long id);
	
	@Select("SELECT id, name, url, perms, `type`, icon, ordernum, createtime, createby,updatetime,updateby,remarks,parentid FROM sys_permissions order by type")
	List<Permissions> listPermissions();
	
	@Insert("insert sys_permissions(name,url,perms,type,parentId) values(#{name},#{url},#{perms},#{type},#{parentId})")
	int save(Permissions permissions);

	@Update("UPDATE sys_permissions SET  name=#{name}, url=#{url},  icon=#{icon},type=#{type},perms=#{perms} WHERE id=#{id}")
	int update(Permissions permissions);
}
