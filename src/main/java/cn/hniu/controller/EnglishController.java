package cn.hniu.controller;

import cn.hniu.pojo.EGroup;
import cn.hniu.pojo.English;
import cn.hniu.service.EnglishService;
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
public class EnglishController {

    @Autowired
    EnglishService englishService;

    @GetMapping("englishList")
    public Map<String, Object> highNumberList() {
        Map<String, Object> map = new HashMap<>();
        List<EGroup> allEnglish = englishService.queryAllEnglish();
        map.put("englishList", allEnglish);

        return map;
    }

    @GetMapping("queryEnglishByGroupNum/{groupId}")
    public Map<String, Object> queryEnglishByGroupNum(@PathVariable("groupId") Integer groupId) {
        Map<String, Object> map = new HashMap<>();
        List<EGroup> eGroupList = englishService.queryEnglishByGroupNum(groupId);
        map.put("eGroupList", eGroupList);

        return map;
    }

    @GetMapping("updateEnglishStatus/{id}")
    public String updateEnglishStatus(@PathVariable Integer id) {
        int flag = englishService.updateEnglishStatus(id);

        return flag > 0 ? ResultUtils.SUCCESS : ResultUtils.FAILD;
    }

    @DeleteMapping("deleteEnglishById/{id}")
    public String deleteEnglishById(@PathVariable Integer id) {
        int result = englishService.deleteEnglishById(id);

        return result > 0 ? ResultUtils.SUCCESS : ResultUtils.FAILD;
    }

    @GetMapping("englishDetails")
    public Map<String, Object> englishDetails() {
        Map<String, Object> map = new HashMap<>();
        List<EGroup> englishDetails = englishService.queryAllEnglishs();
        map.put("englishDetails", englishDetails);

        return map;
    }

    @GetMapping("queryEnglishById/{id}")
    public Map<String, Object> queryEnglishById(@PathVariable Integer id) {
        Map<String, Object> map = new HashMap<>();

        English english = englishService.queryEnglishById(id);
        map.put("english", english);

        return map;
    }
}
