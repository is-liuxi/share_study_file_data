package cn.hniu.mapper;

import cn.hniu.pojo.English;
import cn.hniu.pojo.Groupinfo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GroupinfoMapper {

    @Select("SELECT * FROM groupinfo")
    List<Groupinfo> queryAllGroupDetaild();

    @Select("select id,title,content,f_name as name,filePath,create_date as createDate,`status`,groupId from computer where status = 0 union all " +
            "select id,title,content,f_name as name,filePath,create_date as createDate,`status`,groupId from politics where status = 0 union all " +
            "select id,title,content,f_name as name,filePath,create_date as createDate,`status`,groupId from high_number where status = 0 union all " +
            "select id,title,content,f_name as name,filePath,create_date as createDate,`status`,groupId from english where status = 0")
    List<English> queryAllGroupDetailsUnCheckFile();
}
