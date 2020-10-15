package cn.hniu.service.impl;

import cn.hniu.mapper.ComputerMapper;
import cn.hniu.pojo.Computer;
import cn.hniu.service.ComputerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComputerServiceImpl implements ComputerService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    ComputerMapper computerMapper;

    @Override
    public List<Computer> queryComputer() {
        List<Computer> computerList = computerMapper.queryComputer();
        return computerList;
    }

    @Override
    public int addComputer(Computer computer) {
        int result = computerMapper.addComputer(computer);
        return result;
    }

    @Override
    public List<Computer> queryAllComputers() {
        List<Computer> computerList = computerMapper.queryAllComputers();
        return computerList;
    }

    @Override
    public Computer queryComputerById(Integer id) {
        Computer computer = computerMapper.queryComputerById(id);
        logger.info(id + " 查询到的数据："+ computer);
        return computer;
    }

    @Override
    public int updateComputerStatus(Integer id) {
        int result = computerMapper.updateComputerStatus(id);
        return result;
    }

    @Override
    public int deleteComputerById(Integer id) {
        int result = computerMapper.deleteComputerById(id);
        return result;
    }
}
