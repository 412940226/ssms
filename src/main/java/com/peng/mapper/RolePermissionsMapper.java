package com.peng.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

import com.peng.entity.RolePermissions;

public interface RolePermissionsMapper {
	
	@Delete("DELETE FROM  sys_roles_permissions WHERE id=#{id}")
	int remove(Long id);
	
	@Delete("DELETE FROM  sys_roles_permissions WHERE roleid=#{roleid}")
	int removeByRoleId(Long roleid);
	
	@Insert("INSERT INTO sys_roles_permissions(roleid, permissionsid, createtime,createby)" + "VALUES(#{roleid}, #{permissionsid}, #{createtime}, #{createby})")
	int save(RolePermissions rm);
	
	@Insert("<script>" + 
			"INSERT INTO sys_roles_permissions(roleid, permissionsid) values"+
			" <foreach collection=\"list\" item=\"item\" index=\"index\" separator=\",\" >  " + 
			" (#{item.roleid},#{item.permissionsid})" + 
			" </foreach>  "+ 
			"</script>")
	int batchSave(List<RolePermissions> list);
	
}
