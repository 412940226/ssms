package com.peng.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.peng.entity.UserRole;

public interface UserRoleMapper {
	
	@Select("select roleid from sys_users_roles where userid=#{userid}")
	List<Long> listRoleId(Long userid);
	
	@Delete("DELETE FROM  sys_users_roles WHERE id=#{id}")
	int remove(Long id);

	@Delete("DELETE FROM  sys_users_roles WHERE userid=#{id}")
	int removeByUserId(Long id);
	
	@Insert("INSERT INTO sys_users_roles(id, userid, roleid,createtime,createby)" + "VALUES(#{id}, #{userid}, #{roleid}),#{createtime}, #{createby})")
	int save(UserRole ur);
	
	@Insert("<script>" + 
			"INSERT INTO sys_users_roles(userid, roleid) values"+
			" <foreach collection=\"list\" item=\"item\" index=\"index\" separator=\",\" >  " + 
			" (#{item.userid},#{item.roleid})" + 
			" </foreach>"+ 
			"</script>")
	int batchSave(List<UserRole> list);
}
