package cn.hniu.service;

import cn.hniu.pojo.Admin;

public interface AdminService {

    Admin login(Admin admin);

    int addAdmin(Admin admin);
}
