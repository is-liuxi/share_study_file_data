package cn.hniu.service.impl;

import cn.hniu.mapper.HighNumberMapper;
import cn.hniu.pojo.HNGroup;
import cn.hniu.pojo.HighNumber;
import cn.hniu.service.HighNumberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HighNumberServiceImpl implements HighNumberService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    HighNumberMapper highNumberMapper;

    @Override
    public int updateHighNumberStatus(Integer id) {
        int result = highNumberMapper.updateHighNumberStatus(id);
        return result;
    }


    @Override
    public List<HNGroup> queryAllHighNumber() {
        List<HNGroup> hnGroups = highNumberMapper.queryAllHighNumber();
        logger.info("查询到所有高数数据：" + hnGroups);
        return hnGroups;
    }

    @Override
    public List<HNGroup> queryAllHighNumbers() {
        List<HNGroup> groupList = highNumberMapper.queryAllHighNumbers();
        return groupList;
    }

    @Override
    public List<HNGroup> queryHighNumByGroupNum(Integer groupId) {
        List<HNGroup> groupList = highNumberMapper.queryHighNumByGroupNum(groupId);
        return groupList;
    }

    @Override
    public HighNumber queryHighNumberById(Integer id) {
        HighNumber highNumber = highNumberMapper.queryHighNumberById(id);
        return highNumber;
    }

    @Override
    public int addHighNumber(HighNumber highNumber) {
        int result = highNumberMapper.addHighNumber(highNumber);
        return result;
    }

    @Override
    public int deleteHighNumberStatus(Integer id) {
        int result = highNumberMapper.deleteHigh_numberById(id);
        return result;
    }
}
