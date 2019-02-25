package nu.springboot2.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Program: springboothello
 * @Author: 努力就是魅力
 * @Since: 2018-11-19 10:46
 * Description:
 *     这是一个异常处理的类
 **/

@ControllerAdvice
public class MyControllerAdvice {


    /**
     * 全局异常捕获类， 所有的全局异常都会被捕获到
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Map<String, Object> globalExceptionHandler(Exception ex){
        Map<String, Object> map = new HashMap<>();
        map.put("code",-1);
        map.put("msg", ex.getMessage());
        return map;
    }


    /**
     * 自定义异常。
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = BusinessException.class)
    public Map<String, Object> diyExceptionHandler(BusinessException ex){
        Map<String, Object> map = new HashMap<>();
        map.put("code",ex.getCode());
        map.put("msg", ex.getMsg());
        return map;
    }
}
