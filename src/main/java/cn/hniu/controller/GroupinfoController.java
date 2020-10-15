package cn.hniu.controller;

import cn.hniu.pojo.English;
import cn.hniu.pojo.Groupinfo;
import cn.hniu.service.GroupinfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class GroupinfoController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    GroupinfoService groupinfoService;

    @GetMapping("queryAllGroupDetaild")
    public Map<String, Object> queryEnglishByGroupNum() {
        Map<String, Object> map = new HashMap<>();
        List<Groupinfo> groupinfoList = groupinfoService.queryAllGroupDetaild();
        map.put("groupinfoList", groupinfoList);

        return map;
    }

    @GetMapping("groupDetailsUnCheckFiles")
    public Map<String, Object> groupDetailsUnCheckFiles() {
        Map<String, Object> map = new HashMap<>();
        List<English> groupDetailsUnCheckFiles = groupinfoService.queryAllGroupDetailsUnCheckFile();
        map.put("groupDetailsUnCheckFiles", groupDetailsUnCheckFiles);
        map.put("total", groupDetailsUnCheckFiles.size());
        return map;
    }

}
