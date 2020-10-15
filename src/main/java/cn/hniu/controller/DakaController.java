package cn.hniu.controller;

import cn.hniu.pojo.Daka;
import cn.hniu.service.DakaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class DakaController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    DakaService dakaService;

    @GetMapping("queryDakaDetails/{userId}")
    public Map<String, Object> queryDakaDetails(@PathVariable Integer userId) {
        logger.info("打卡的用户：" + userId);
        Map<String, Object> map = new HashMap<>();

        /* 查询用户当天是否已经打卡，没有打卡则打卡，已经打卡了返回打卡时间 */
        Daka daka = dakaService.queryDakaDateils(userId);
        if (daka == null) {
            dakaService.addDaka(userId);
            daka = dakaService.queryDakaDateils(userId);
        }
        logger.info(userId + "用户打开信息：" + daka);

        map.put("dakaDetails", daka);
        map.put("dakaiTotal", dakaService.dakaTotal(userId));

        return map;
    }
}
