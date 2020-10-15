package cn.hniu.service;

import cn.hniu.pojo.English;
import cn.hniu.pojo.Groupinfo;

import java.util.List;

public interface GroupinfoService {

    List<Groupinfo> queryAllGroupDetaild();

    List<English> queryAllGroupDetailsUnCheckFile();
}
