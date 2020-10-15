package cn.hniu.service.impl;

import cn.hniu.mapper.AdminMapper;
import cn.hniu.pojo.Admin;
import cn.hniu.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;

    @Override
    public Admin login(Admin admin) {
        if (admin == null){
            return null;
        }
        Admin result = adminMapper.login(admin.getName(), admin.getPwd());
        return result;
    }

    @Override
    public int addAdmin(Admin admin) {
        int result = adminMapper.addAdmin(admin);
        return result;
    }
}
