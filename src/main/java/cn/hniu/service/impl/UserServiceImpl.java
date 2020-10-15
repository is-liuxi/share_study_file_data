package cn.hniu.service.impl;

import cn.hniu.mapper.UserMapper;
import cn.hniu.pojo.User;
import cn.hniu.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    UserMapper userMapper;

    @Override
    public int updateUserDetails(User user) {
        return userMapper.updateUserDetails(user);
    }

    @Override
    public List<User> queryAllUser() {
        List<User> userList = userMapper.queryAllUser();
        logger.info("所有用户信息" + userList);
        return userList;
    }

    @Override
    public User queryLoginUser(User user) {
        User loginUser = userMapper.checkLoginUser(user);
        logger.info("登录的用户信息：" + loginUser);
        return loginUser;
    }

    @Override
    public int addUser(User user) {
        int result = userMapper.addUser(user);
        logger.info("添加用户返回值：" + result);
        return result;
    }

    @Override
    public User queryUserById(Integer id) {
        User user = userMapper.queryUserById(id);
        logger.info("查询到的用户数据：" + user);
        return user;
    }
}
