package cn.hniu.controller;

import cn.hniu.pojo.HNGroup;
import cn.hniu.pojo.HighNumber;
import cn.hniu.service.HighNumberService;
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
public class HighNumberController {

    @Autowired
    HighNumberService highNumberService;

    @GetMapping("highNumberList")
    public Map<String, Object> highNumberList() {
        Map<String, Object> map = new HashMap<>();
        List<HNGroup> hnGroups = highNumberService.queryAllHighNumber();
        map.put("highNumberList", hnGroups);

        return map;
    }

    @GetMapping("updateHighNumberStatus/{id}")
    public String updateHighNumberStatus(@PathVariable Integer id) {
        int result = highNumberService.updateHighNumberStatus(id);

        return result > 0 ? ResultUtils.SUCCESS : ResultUtils.FAILD;
    }

    @GetMapping("highNumberLists")
    public Map<String, Object> queryAllHighNumbers() {
        Map<String, Object> map = new HashMap<>();
        List<HNGroup> hnGroups = highNumberService.queryAllHighNumbers();
        map.put("highNumberLists", hnGroups);

        return map;
    }

    @GetMapping("queryHighNumByGroupNum/{highNum}")
    public Map<String, Object> queryHighNumByGroupNum(@PathVariable Integer highNum) {
        Map<String, Object> map = new HashMap<>();
        List<HNGroup> hnGroups = highNumberService.queryHighNumByGroupNum(highNum);
        map.put("queryHighNumByGroupNums", hnGroups);

        return map;
    }

    @DeleteMapping("deleteHighNumberStatus/{id}")
    public String deleteHighNumberStatus(@PathVariable Integer id) {
        int result = highNumberService.deleteHighNumberStatus(id);

        return result > 0 ? ResultUtils.SUCCESS : ResultUtils.FAILD;
    }

    @GetMapping("queryHighNumberById/{id}")
    public Map<String, Object> queryHighNumberById(@PathVariable Integer id) {
        Map<String, Object> map = new HashMap<>();

        HighNumber highNumber = highNumberService.queryHighNumberById(id);
        map.put("highNumber", highNumber);

        return map;
    }
}
