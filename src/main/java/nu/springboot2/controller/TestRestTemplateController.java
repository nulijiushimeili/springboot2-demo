package nu.springboot2.controller;

import nu.springboot2.module.Page;
import nu.springboot2.module.Res;
import nu.springboot2.module.User;
import nu.springboot2.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Program: spring-boot2-mybatis
 * @Author: 努力就是魅力
 * @Since: 2019-02-22 22:17
 * Description:
 **/

@Controller
public class TestRestTemplateController {

    @Autowired
    private IUserService userService;

    /**
     * 这是一个用于测试的rest interface
     * @param name   请求参数1，required
     * @param age    请求参数2, required
     * @return       返回值必须是一个对象，因为使用了@ResponseBody会将对象自动转化为json串。
     *                如果返回字符串，发送请求的接口会解析异常
     *                返回值： {"code":0,"message":"success"}
     */
    @RequestMapping(value = "/requestParam",method = RequestMethod.POST)
    @ResponseBody
    public Res test03(@RequestParam(value = "name") String name,
                      @RequestParam("age") int age){
        System.out.println("收到请求！");
        Res res = new Res(0,"success");
        System.out.println(res);
        return res;
    }

    @Autowired
    private RestTemplate restTemplate;

    /**
     *  在浏览器中访问这个地址调用下面的方法： http://localhost:8080/trtc01
     * @return        返回的值直接映射成对应的对象
     */
    @RequestMapping(value = "/trtc01",method = RequestMethod.GET)
    @ResponseBody
    public Res trtc01(){
        // 定义请求的数据
        MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        map.add("name","xiaoming");
//        map.add("age",20);
        // 也不知道为啥，这里不接收Integer类型的值
        map.add("age","20");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String,Object>> entity = new HttpEntity<>(map,httpHeaders);
        System.out.println(entity);
        // 发送post请求
        // postForEntry(请求的url，请求发送的数据，返回值的类型)
        Res res  = restTemplate.postForEntity("http://localhost:8080/requestParam",entity,Res.class).getBody();
        return res;
    }


    @RequestMapping(value = "/bootstrapTablePage",method = RequestMethod.GET)
    public String toBootstrapTablePage(){
        return "html/bootstrapTablePage.html";
    }

    @RequestMapping(value = "/queryAllUserByPage", method = RequestMethod.POST)
    @ResponseBody
    public Page queryAllUserByPage(HttpServletRequest request){
        int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
        int pageSize = Integer.valueOf(request.getParameter("pageSize"));
        System.out.println("分页： " + pageNumber + "---- " + pageSize);
        Map<String,Integer> map = new HashMap<>();
        map.put("pageNumber", pageNumber);
        map.put("pageSize", pageSize);
        List<User> list =  userService.queryAllUserByPage(map);
        list.forEach(System.out::println);
        int count = userService.userCount();
        System.out.println(count);
        Page page = new Page();
        page.setRows(list);
        page.setTotal(count);
        return page;
    }

}

