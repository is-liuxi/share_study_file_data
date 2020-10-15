package cn.hniu.exception;

import cn.hniu.util.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *  全局异常处理
 */
@RestController
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String exception(Exception e){
        logger.info("异常信息：" + e.getMessage());
        return ResultUtils.FAILD;
    }

}
