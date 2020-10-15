package cn.hniu.controller;

import cn.hniu.pojo.Politics;
import cn.hniu.service.PoliticsService;
import cn.hniu.util.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PoliticsController {

    @Autowired
    PoliticsService politicsService;

    @GetMapping("politicsList")
    public Map<String, Object> highNumberList() {
        Map<String, Object> map = new HashMap<>();
        List<Politics> politicsList = politicsService.queryPolitics();
        map.put("politicsList", politicsList);

        return map;
    }

    @GetMapping("queryAllPolitics")
    public Map<String, Object> queryAllPolitics() {
        Map<String, Object> map = new HashMap<>();
        List<Politics> politicsList = politicsService.queryAllPolitics();
        map.put("queryAllPolitics", politicsList);

        return map;
    }

    @GetMapping("updatePoliticsStatus/{id}")
    public String updatePoliticsStatus(@PathVariable Integer id) {
        int result = politicsService.updatePoliticsStatus(id);

        return result > 0 ? ResultUtils.SUCCESS : ResultUtils.FAILD;
    }

    @DeleteMapping("deletePoliticsById/{id}")
    public String deletePoliticsById(@PathVariable Integer id) {
        int result = politicsService.deletePoliticsById(id);

        return result > 0 ? ResultUtils.SUCCESS : ResultUtils.FAILD;
    }

    @GetMapping("queryPoliticsById/{id}")
    public Map<String, Object> queryPoliticsById(@PathVariable Integer id) {
        Map<String, Object> map = new HashMap<>();

        Politics politics = politicsService.queryPoliticsById(id);
        map.put("politics", politics);

        return map;
    }
}
