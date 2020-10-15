package cn.hniu.service;

import cn.hniu.pojo.HNGroup;
import cn.hniu.pojo.HighNumber;

import java.util.List;

public interface HighNumberService {

    List<HNGroup> queryAllHighNumber();

    List<HNGroup> queryAllHighNumbers();

    List<HNGroup> queryHighNumByGroupNum(Integer groupId);

    int addHighNumber(HighNumber highNumber);

    int updateHighNumberStatus(Integer id);

    int deleteHighNumberStatus(Integer id);

    HighNumber queryHighNumberById(Integer id);
}
