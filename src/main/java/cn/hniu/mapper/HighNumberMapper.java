package cn.hniu.mapper;

import cn.hniu.pojo.HNGroup;
import cn.hniu.pojo.HighNumber;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface HighNumberMapper {

    List<HNGroup> queryAllHighNumber();

    List<HNGroup> queryAllHighNumbers();

    List<HNGroup> queryHighNumByGroupNum(Integer groupId);

    @Insert("insert into high_number(title,content,filePath,groupId,create_date,status,f_name) " +
            "values(#{title},#{content},#{filePath},#{groupId},now(),0,#{name})")
    @Options(useGeneratedKeys = true, keyColumn = "id")
    int addHighNumber(HighNumber highNumber);

    @Update("update high_number set status = 1 where id = #{id}")
    int updateHighNumberStatus(Integer id);

    @Delete("delete high_number computer where id = #{id}")
    int deleteHigh_numberById(Integer id);

    @Select("SELECT id,title,content,filePath,groupId,create_date as createDate, status, f_name as name FROM high_number WHERE id = #{id}")
    HighNumber queryHighNumberById(@Param("id") Integer id);
}
