package cn.hniu.mapper;

import cn.hniu.pojo.Daka;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface DakaMapper {

    @Select("select * from daka where userid = #{userId} and date(daka_date) = date(now())")
    Daka queryDakaDateils(Integer userId);

    @Insert("INSERT INTO daka (daka_date, userid) VALUES(#{daka_date}, #{userid})")
    int addDaka(Daka daka);

    @Select("SELECT count(*) FROM daka WHERE userid = #{userid};")
    int dakaTotal(@Param("userid") Integer userid);
}
