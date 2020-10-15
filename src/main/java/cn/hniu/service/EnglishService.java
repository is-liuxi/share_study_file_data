package cn.hniu.service;

import cn.hniu.pojo.EGroup;
import cn.hniu.pojo.English;

import java.util.List;

public interface EnglishService {

    List<EGroup> queryAllEnglish();

    List<EGroup> queryEnglishByGroupNum(Integer groupId);

    int addEnglish(English english);

    int updateEnglishStatus(Integer id);

    int deleteEnglishById(Integer id);

    List<English> queryAllEnglishDetails();

    List<EGroup> queryAllEnglishs();

    English queryEnglishById(Integer id);
}
