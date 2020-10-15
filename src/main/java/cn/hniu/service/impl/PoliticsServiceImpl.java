package cn.hniu.service.impl;

import cn.hniu.mapper.PoliticsMapper;
import cn.hniu.pojo.Politics;
import cn.hniu.service.PoliticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoliticsServiceImpl implements PoliticsService {

    @Autowired
    PoliticsMapper politicsMapper;

    @Override
    public List<Politics> queryPolitics() {
        List<Politics> politicsList = politicsMapper.queryPolitics();
        return politicsList;
    }

    @Override
    public int addPolitics(Politics politics) {
        int result = politicsMapper.addPolitics(politics);
        return result;
    }

    @Override
    public List<Politics> queryAllPolitics() {
        List<Politics> politicsList = politicsMapper.queryAllPolitics();
        return politicsList;
    }

    @Override
    public int updatePoliticsStatus(Integer id) {
        int result = politicsMapper.updatePoliticsStatus(id);
        return result;
    }

    @Override
    public int deletePoliticsById(Integer id) {
        int result = politicsMapper.deletePoliticsById(id);
        return result;
    }

    @Override
    public Politics queryPoliticsById(Integer id) {
        Politics politics = politicsMapper.queryPoliticsById(id);
        return politics;
    }
}
