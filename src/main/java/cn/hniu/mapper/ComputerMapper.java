package cn.hniu.mapper;

import cn.hniu.pojo.Computer;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ComputerMapper {

    @Select("SELECT * FROM computer WHERE STATUS = 1 LIMIT 2;")
    List<Computer> queryComputer();

    @Select("SELECT * FROM computer WHERE STATUS = 1 ;")
    List<Computer> queryAllComputers();

    @Insert("insert into computer(title,content,filePath,create_date,status,f_name) " +
            "values(#{title},#{content},#{filePath},now(),0,#{name})")
    @Options(useGeneratedKeys = true, keyColumn = "id")
    int addComputer(Computer computer);

    @Update("update computer set status = 1 where id = #{id}")
    int updateComputerStatus(Integer id);

    @Delete("delete from computer where id = #{id}")
    int deleteComputerById(Integer id);

    @Select("SELECT id,title,content,filePath,groupId,create_date as createDate, status, f_name as name FROM computer WHERE id = #{id}")
    Computer queryComputerById(@Param("id") Integer id);
}
