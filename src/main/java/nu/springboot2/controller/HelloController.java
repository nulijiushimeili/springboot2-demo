package nu.springboot2.controller;



import nu.springboot2.exception.BusinessException;
import nu.springboot2.module.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 这里使用@RestController， 相当于@Controller & @RequestBody的组合
 */
@RestController
public class HelloController {

    /**
     * 读取application.properties 中自定义的属性
     */
    @Value("${nulijiushimeili.helloWorld}")
    private String str;

    /**
     * 在 application.properties-temp 中添加自定义配置，使用定义过的变量。
     * 详情：见application.properties
     */
    @Value("${nulijiushimeili.helloWorld.append}")
    private String appendStr;

    /**
     * 在配置文件中获取随机值
     */
    @Value("${nulijiushimeili.randomInt}")
    private int randomInt;


    /**
     * 通过RequestMapping 建立请求映射，
     * 在浏览器地址栏输入 http://localhost:8080/hello         节可以访问页面了
     * @return
     */
    @RequestMapping("/hello")
    public String sayHello(){
        return "hello";
    }

    /**
     * 返回json数据
     * srping boot 底层使用的是 Jackson 框架
     * @return
     */
    @RequestMapping("/getUser")
    public User getUser(){
        User user = new User();
        user.setId(1);
        user.setName("小明");
        return user;
    }

    @RequestMapping("/str")
    public String getStr(){
        return str;
    }


    @RequestMapping("/appendStr")
    public String getAppendStr(){
        return appendStr;
    }

    @RequestMapping("/randomInt")
    public int getRandomIntFromConfig(){
        return randomInt;
    }


    /**
     *  测试全局异常处理
     */
    @RequestMapping("/exHandler")
    public String testGlobalExceptionHandler(){
        int aa = 1 / 0;
        return "exception";
    }

    /**
     * 自定义异常处理
     * @return
     */
    @RequestMapping("/diyException")
    public String testDiyExceptionHandler(){
        throw new BusinessException("-50", "自定义异常！");
    }

}
