package com.peng.mapper;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.peng.entity.User;

/**
 * 相当dao层 可以用注解 @select @insert....
 * @author pengcq 412940226@qq.com	
 * @date 2017年7月1日 下午5:00:12
 */
public interface UserMapper {
	//使用UserMapper.xml
	public User queryUserByName(String username);
	public Set<String> queryRolesByName(String username);
	public User findUserById(long id);
	public void deleteUser(long id);
	
	@Select("SELECT id, username, realname, email, mobile, createtime, createby, remarks FROM sys_users")
	@Results({ @Result(property = "id", column = "id"), @Result(property = "username", column = "username"),
			   @Result(property = "realname", column = "realname"), @Result(property = "email", column = "email"),
			   @Result(property = "mobile", column = "mobile"), @Result(property = "createtime", column = "createtime"),
			   @Result(property = "createby", column = "createby"), @Result(property = "remarks", column = "remarks")})
	List<User> listUser();
	
	@Insert("insert into sys_users (username, password, realname, email, mobile, status, createtime, createby, remarks)"
	+ "values (#{username}, #{password}, #{realname}, #{email}, #{mobile}, #{status}, #{createtime}, #{createby}, #{remarks})")
	public int save(User user);
	
	int count(Map<String,Object> map);
	
	int batchRemove(List<Long> list);
	
	public int update(User user);
}
