package cn.hniu.controller;

import cn.hniu.pojo.Computer;
import cn.hniu.service.ComputerService;
import cn.hniu.util.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ComputerController {

    @Autowired
    ComputerService computerService;

    @GetMapping("computerList")
    public Map<String, Object> highNumberList() {
        Map<String, Object> map = new HashMap<>();
        List<Computer> computerList = computerService.queryComputer();
        map.put("computerList", computerList);

        return map;
    }

    @GetMapping("queryAllComputers")
    public Map<String, Object> queryAllComputers() {
        Map<String, Object> map = new HashMap<>();
        List<Computer> computerList = computerService.queryAllComputers();
        map.put("queryAllComputers", computerList);

        return map;
    }

    @GetMapping("updateComputerStatus/{id}")
    public String updateComputerStatus(@PathVariable Integer id) {
        Integer result = computerService.updateComputerStatus(id);

        return result > 0 ? ResultUtils.SUCCESS : ResultUtils.FAILD;
    }

    @DeleteMapping("deleteComputerById/{id}")
    public String deleteComputerById(@PathVariable Integer id) {
        int result = computerService.deleteComputerById(id);

        return result > 0 ? ResultUtils.SUCCESS : ResultUtils.FAILD;
    }

    @GetMapping("queryComputerById/{id}")
    public Map<String, Object> queryComputerById(@PathVariable Integer id) {
        Map<String, Object> map = new HashMap<>();

        Computer computer = computerService.queryComputerById(id);
        map.put("computer", computer);

        return map;
    }
}
