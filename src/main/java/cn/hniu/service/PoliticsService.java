package cn.hniu.service;

import cn.hniu.pojo.Politics;

import java.util.List;

public interface PoliticsService {

    List<Politics> queryPolitics();

    List<Politics> queryAllPolitics();

    int addPolitics(Politics politics);

    int updatePoliticsStatus(Integer id);

    int deletePoliticsById(Integer id);

    Politics queryPoliticsById(Integer id);
}
