package nu.springboot2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * @Program: spring-boot2-mybatis
 * @Author: 努力就是魅力
 * @Since: 2019-02-18 22:22
 * Description:
 *
 *      使用HttpURLConnection实现调用restful接口
 *      下面是提供给测试用的restful interface
 *
 **/


@Controller
public class RestfulTestController {


    /**
     * 修改
     * @param param
     * @return
     */
    @RequestMapping(value = "/put/{param}", method = RequestMethod.PUT)
    @ResponseBody
    public String put(@PathVariable String param){
        return "put : " + param;
    }

    /**
     * 新增
     * @param param
     * @param id
     * @param name
     * @return
     */
    @RequestMapping(value = "/post/{param}",method = RequestMethod.POST)
    @ResponseBody
    public String post(@PathVariable String param, String id, String name ){
        System.out.println("id : " + id);
        System.out.println("name : " + name);
        return "post : " + param;
    }

    /**
     * 删除
     * @param param
     * @return
     */
    @RequestMapping(value = "/delete/{param}", method = RequestMethod.DELETE)
    @ResponseBody
    public String delete (@PathVariable String param){
        return "delete : " + param;
    }

    /**
     * 查找
     * @param param
     * @return
     */
    @RequestMapping(value = "/get/{param}",method = RequestMethod.GET)
    @ResponseBody
    public String get(@PathVariable String param){
        return "get : " + param;
    }


}
