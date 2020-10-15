package cn.hniu.controller;

import cn.hniu.pojo.Study;
import cn.hniu.service.StudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StudyController {

    @Autowired
    StudyService studyService;

    @GetMapping("queryAllStudys")
    public Map<String,Object> queryAllStudys(){
        Map<String,Object> map = new HashMap<>();

        List<Study> studyList = studyService.queryAllStudys();
        map.put("studyList", studyList);

        return map;
    }
}
