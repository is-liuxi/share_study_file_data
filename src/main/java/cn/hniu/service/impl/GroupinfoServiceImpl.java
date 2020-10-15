package cn.hniu.service.impl;

import cn.hniu.mapper.GroupinfoMapper;
import cn.hniu.pojo.English;
import cn.hniu.pojo.Groupinfo;
import cn.hniu.service.GroupinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupinfoServiceImpl implements GroupinfoService {

    @Autowired
    private GroupinfoMapper groupinfoMapper;

    @Override
    public List<Groupinfo> queryAllGroupDetaild() {
        List<Groupinfo> groupinfoList = groupinfoMapper.queryAllGroupDetaild();
        return groupinfoList;
    }

    @Override
    public List<English> queryAllGroupDetailsUnCheckFile() {
        List<English> allGroupDetails = groupinfoMapper.queryAllGroupDetailsUnCheckFile();
        return allGroupDetails;
    }
}
