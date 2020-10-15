package cn.hniu.service;

import cn.hniu.pojo.User;

import java.util.List;

public interface UserService {

    User queryLoginUser(User user);

    int addUser(User user);

    User queryUserById(Integer id);

    int updateUserDetails(User user);

    List<User> queryAllUser();
}
