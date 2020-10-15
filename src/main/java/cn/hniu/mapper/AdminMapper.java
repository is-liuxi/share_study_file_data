package cn.hniu.mapper;

import cn.hniu.pojo.Admin;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface AdminMapper {

    @Select("SELECT * FROM admin WHERE NAME = #{name} AND PWD = #{pwd}")
    Admin login(@Param("name")String username, @Param("pwd")String password);

    @Insert("INSERT INTO admin(name,pwd) VALUES(#{name}, #{pwd})")
    @Options(useGeneratedKeys = true, keyColumn = "id")
    int addAdmin(Admin admin);
}
