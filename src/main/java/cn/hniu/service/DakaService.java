package cn.hniu.service;

import cn.hniu.pojo.Daka;

public interface DakaService {

    Daka queryDakaDateils(Integer userId);

    int addDaka(Integer userId);

    int dakaTotal(Integer userid);
}
