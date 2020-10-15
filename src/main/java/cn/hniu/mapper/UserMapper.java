package cn.hniu.mapper;


import cn.hniu.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 *  userMapper代理接口
 */
public interface UserMapper {

	@Select("SELECT * FROM userinfo WHERE username = #{username} AND PASSWORD = #{password}")
	User checkLoginUser(User user);

	@Insert("INSERT INTO userinfo(username,password,email,create_date) VALUES(#{username},#{password},#{email},now())")
	@Options(useGeneratedKeys = true, keyColumn = "id")
	int addUser(User user);

	@Select("SELECT * FROM userinfo WHERE id = #{id}")
	User queryUserById(Integer id);

	@Update("update userinfo set mobile = #{mobile}, email = #{email}, gender = #{gender} where id = #{id}")
	int updateUserDetails(User user);

	/* 字段注册时间与属性不一致，使用别名处理 */
	@Select("SELECT id, username, `password`, mobile, gender, email, create_date as createDate FROM userinfo")
	List<User> queryAllUser();
}
