package cn.hniu.service;

import cn.hniu.pojo.Computer;

import java.util.List;

public interface ComputerService {

    List<Computer> queryComputer();

    List<Computer> queryAllComputers();

    int addComputer(Computer computer);

    int updateComputerStatus(Integer id);

    int deleteComputerById(Integer id);

    Computer queryComputerById(Integer id);
}
