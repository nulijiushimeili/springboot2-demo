package nu.springboot2.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Program: springboothello
 * @Author: 努力就是魅力
 * @Since: 2018-11-19 10:58
 * Description:
 *      自定义异常类
 **/


public class BusinessException  extends RuntimeException{
    private String code ;
    private String msg;

    public BusinessException(String code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
