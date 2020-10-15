package cn.hniu.service.impl;

import cn.hniu.mapper.StudyMapper;
import cn.hniu.pojo.Study;
import cn.hniu.service.StudyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudyServiceImpl implements StudyService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    StudyMapper studyMapper;

    @Override
    public List<Study> queryAllStudys() {
        List<Study> studyList = studyMapper.queryAllStudys();
        logger.info("查询到 study的全部数据：" + studyList);
        return studyList;
    }
}
