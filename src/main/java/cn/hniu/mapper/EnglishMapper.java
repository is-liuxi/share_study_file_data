package cn.hniu.mapper;

import cn.hniu.pojo.EGroup;
import cn.hniu.pojo.English;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface EnglishMapper {

    /* 分组的 */
    List<EGroup> queryAllEnglish();

    /* 英语和所属组的全部数据 */
    List<EGroup> queryAllEnglishs();

    List<EGroup> queryEnglishByGroupNum(@Param("groupId") Integer groupId);

    @Insert("insert into english(title,content,filePath,groupId,create_date,status,f_name) " +
            "values(#{title},#{content},#{filePath},#{groupId},now(),0,#{name})")
    @Options(useGeneratedKeys = true, keyColumn = "id")
    int addEnglish(English english);

    @Update("update english set status = 1 where id = #{id}")
    int updateEnglishStatus(Integer id);

    @Delete("delete from english where id = #{id}")
    int deleteEnglishById(Integer id);

    /* 英语全部数据 */
    @Select("SELECT * FROM english")
    List<English> queryAllEnglishDetails();

    @Select("SELECT id,title,content,filePath,groupId,create_date as createDate, status, f_name as name FROM english WHERE id = #{id}")
    English queryEnglishById(@Param("id") Integer id);
}
