package cn.hniu.controller;

import cn.hniu.pojo.Admin;
import cn.hniu.service.AdminService;
import cn.hniu.util.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    AdminService adminService;

    @PostMapping("addAdmin")
    public String addAdmin(@RequestBody Admin admin) {
        logger.info("添加管理员的数据：" + admin);

        if (admin == null) {
            return ResultUtils.FAILD;
        }

        int result = adminService.addAdmin(admin);
        return result > 0 ? ResultUtils.SUCCESS : ResultUtils.FAILD;
    }
}
