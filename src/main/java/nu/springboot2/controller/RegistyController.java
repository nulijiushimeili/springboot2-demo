package nu.springboot2.controller;

import nu.springboot2.mapper.CityMapper;
import nu.springboot2.module.City;
import nu.springboot2.module.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: spring-boot2-mybatis
 * @author: 努力就是魅力
 * @create: 2018-09-28 13:54
 * description:
 *
 *
 **/


@Controller
//@RequestMapping(value = "/abv")
//@Slf4j
public class RegistyController {


    //ajax请求，返回一个对象
    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    @ResponseBody
    public User registerUser(String username, String password) {
        // 返回对象添加@ResponseBody标签            
        // 访问数据库或处理数据的代码，这里只是简单做个处理            
        User user = new User();
        if (username != null) {
            user.setName(username);
        }
        if (password != null) {
            user.setPassword(password);
        }
        return user;
    }

    /**
     * 测试 bootstrap-table
     *
     * @return
     */
    @RequestMapping(value = "/registry", method = RequestMethod.POST)
    @ResponseBody
    public List<User> registerUser() {
        List<User> list = new ArrayList<User>();
        User user = new User();
        user.setName("dsfsfs");
        user.setPassword("sdfssss");
        user.setGender("s");
        user.setCellphone("tttttttt");
        user.setEmail("gghhhhh");
        list.add(user);

        return list;
    }

    /**
     * 使用自动装配
     */
    @Autowired
    private CityMapper cityMapper;

    /**
     * 读取mysql数据库的数据返回到前端页面，这是一个完整的例子
     * web 访问地址 ：http://localhost:8080/abv/read?state=HN
     *
     * @param state
     * @return
     */
    @RequestMapping(value = "/read", method = RequestMethod.GET)
    @ResponseBody
    public List<City> readMybatis(@RequestParam String state) {
//        log.info("========================================");
        return cityMapper.findByState(state);
    }



    @RequestMapping(value = "/registryTable", method = RequestMethod.GET)
    @ResponseBody
    public User register(HttpServletRequest request) {
        User user = new User();
        user.setName(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        return user;
    }
}

