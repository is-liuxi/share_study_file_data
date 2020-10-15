package cn.hniu.controller;

import cn.hniu.pojo.Admin;
import cn.hniu.pojo.User;
import cn.hniu.service.AdminService;
import cn.hniu.service.UserService;
import cn.hniu.util.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Random;

/**
 * 登录注册处理
 */
@RestController
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private AdminService adminService;

    @PostMapping("login")
    public String login(@RequestBody Map<String, Object> map, HttpServletRequest req) {
        logger.info("用户登录请求的数据：" + map);
        String loginType = String.valueOf(map.get("loginType"));
        String username = String.valueOf(map.get("username"));
        String password = String.valueOf(map.get("password"));
        User user = null;
        if ("user".equals(loginType)) {
            user = userService.queryLoginUser(new User(username, password));
            if (user == null) {
                return ResultUtils.FAILD;
            } else {
                // 查询到的用户不为空，保存到 Session域中
                req.getSession().setAttribute("user", user);
                return "user";
            }
        }

        if ("admin".equals(loginType)) {
            Admin admin = adminService.login(new Admin(username, password));
            if (admin == null) {
                return ResultUtils.FAILD;
            } else {
                req.getSession().setAttribute("admin", admin);
                return "admin";
            }
        }
        return ResultUtils.FAILD;
    }

    @GetMapping("code")
    public String code(){
        Random random = new Random();
        int result = random.nextInt(900000) + 99999;
        return result + "";
    }
}
