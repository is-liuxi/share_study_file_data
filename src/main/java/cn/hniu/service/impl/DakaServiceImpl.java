package cn.hniu.service.impl;

import cn.hniu.mapper.DakaMapper;
import cn.hniu.pojo.Daka;
import cn.hniu.service.DakaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DakaServiceImpl implements DakaService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    DakaMapper dakaMapper;

    @Override
    public int dakaTotal(Integer userid) {
        int result = dakaMapper.dakaTotal(userid);
        return result;
    }

    @Override
    public Daka queryDakaDateils(Integer userId) {
        Daka daka = dakaMapper.queryDakaDateils(userId);
        return daka;
    }

    @Override
    public int addDaka(Integer userId) {
        Daka daka = new Daka(new Date(),userId);
        logger.info("用户打卡添加的数据：" + daka);
        int result = dakaMapper.addDaka(daka);
        return result;
    }
}
