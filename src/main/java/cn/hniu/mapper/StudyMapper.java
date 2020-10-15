package cn.hniu.mapper;

import cn.hniu.pojo.Study;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudyMapper {

    @Select("SELECT * FROM study")
    List<Study> queryAllStudys();
}
