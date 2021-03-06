package nu.springboot2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @program: spring-boot2-mybatis
 * @author: 努力就是魅力
 * @create: 2018-09-28 12:43
 * description:
 *
 *       spring boot hello world !
 *       将根目录直接转向index.html页面。
 **/

@Controller
public class HomeController {

    @RequestMapping("/")
    public String showHomePage(){
        return "html/index.html";
    }


    @GetMapping("/axiosDemo")
    public String showAxiosDemo(){
        return "html/lesson06_vue-resource的基本使用.html";
    }
}
