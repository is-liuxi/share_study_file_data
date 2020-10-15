package cn.hniu.service.impl;

import cn.hniu.mapper.EnglishMapper;
import cn.hniu.pojo.EGroup;
import cn.hniu.pojo.English;
import cn.hniu.service.EnglishService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnglishServiceImpl implements EnglishService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    EnglishMapper englishMapper;

    @Override
    public List<EGroup> queryAllEnglish() {
        List<EGroup> allEnglish = englishMapper.queryAllEnglish();
        return allEnglish;
    }

    @Override
    public List<EGroup> queryEnglishByGroupNum(Integer groupId) {
        List<EGroup> groupList = englishMapper.queryEnglishByGroupNum(groupId);
        logger.info("查询到的数据：" + groupList);
        return groupList;
    }

    @Override
    public int addEnglish(English english) {
        int result = englishMapper.addEnglish(english);
        return result;
    }

    @Override
    public int updateEnglishStatus(Integer id) {
        int result = englishMapper.updateEnglishStatus(id);
        return result;
    }

    @Override
    public int deleteEnglishById(Integer id) {
        int result = englishMapper.deleteEnglishById(id);
        return result;
    }

    @Override
    public List<English> queryAllEnglishDetails() {
        List<English> englishList = englishMapper.queryAllEnglishDetails();
        return englishList;
    }

    @Override
    public English queryEnglishById(Integer id) {
        English english = englishMapper.queryEnglishById(id);
        return english;
    }

    @Override
    public List<EGroup> queryAllEnglishs() {
        List<EGroup> eGroupList = englishMapper.queryAllEnglishs();
        return eGroupList;
    }

}
