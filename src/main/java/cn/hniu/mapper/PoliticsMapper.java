package cn.hniu.mapper;

import cn.hniu.pojo.Politics;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface PoliticsMapper {

    @Select("SELECT * FROM politics WHERE STATUS = 1 LIMIT 2;")
    List<Politics> queryPolitics();

    @Select("SELECT * FROM politics WHERE STATUS = 1")
    List<Politics> queryAllPolitics();

    @Insert("insert into politics(title,content,filePath,create_date,status,f_name) " +
            "values(#{title},#{content},#{filePath},now(),0,#{name})")
    @Options(useGeneratedKeys = true, keyColumn = "id")
    int addPolitics(Politics politics);

    @Update("update politics set status = 1 where id = #{id}")
    int updatePoliticsStatus(Integer id);

    @Delete("delete from politics where id = #{id}")
    int deletePoliticsById(Integer id);

    @Select("SELECT id,title,content,filePath,groupId,create_date as createDate, status, f_name as name FROM politics WHERE id = #{id}")
    Politics queryPoliticsById(@Param("id") Integer id);
}
