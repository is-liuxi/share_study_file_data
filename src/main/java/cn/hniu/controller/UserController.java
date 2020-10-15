package cn.hniu.controller;

import cn.hniu.pojo.User;
import cn.hniu.service.UserService;
import cn.hniu.util.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @PostMapping("addUser")
    @ResponseBody
    public Map<String, Object> addUser(@RequestBody User user) {
        Map<String, Object> map = new HashMap<>();
        logger.info("注册用户的信息：" + user);
        if (user == null) {
            map.put("data", ResultUtils.FAILD);
            return map;
        }
        int flag = userService.addUser(user);
        if (flag > 0) {
            map.put("data", ResultUtils.SUCCESS);
            map.put("userId", user.getId());
        } else {
            map.put("data", ResultUtils.FAILD);
        }
        return map;
    }

    @GetMapping("queryUserById/{userId}")
    public String queryUserById(@PathVariable Integer userId, HttpServletRequest req) {
        logger.info("查询的用户 id：" + userId);
        User user = userService.queryUserById(userId);
        if (user == null) {
            throw new RuntimeException("服务器异常");
        }
        req.getSession().setAttribute("user", user);
        return "main";
    }

    @GetMapping("queryUserByUserId/{userId}")
    @ResponseBody
    public Map<String, Object> queryUserByUserId(@PathVariable Integer userId) {
        Map<String, Object> map = new HashMap<>();
        logger.info("查询的用户 id：" + userId);
        User user = userService.queryUserById(userId);
        map.put("user", user);
        return map;
    }

    @PostMapping("updateUserDetails")
    @ResponseBody
    public String updateUserDetails(@RequestBody User user) {
        logger.info("修改的用户数据：" + user);
        int result = userService.updateUserDetails(user);
        return result > 0 ? ResultUtils.SUCCESS : ResultUtils.FAILD;
    }

    @GetMapping("logout")
    public String logout(HttpServletRequest req){
        req.getSession().invalidate();
        return "redirect:index";
    }
}
