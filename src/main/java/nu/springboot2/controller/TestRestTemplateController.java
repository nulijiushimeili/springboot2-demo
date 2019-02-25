package nu.springboot2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Program: spring-boot2-mybatis
 * @Author: 努力就是魅力
 * @Since: 2019-02-22 22:17
 * Description:
 **/

@RestController
public class TestRestTemplateController {

    /**
     * 这是一个用于测试的rest interface
     * @param name   请求参数1，required
     * @param age    请求参数2, required
     * @return       返回值必须是一个对象，因为使用了@ResponseBody会将对象自动转化为json串。
     *                如果返回字符串，发送请求的接口会解析异常
     *                返回值： {"code":0,"message":"success"}
     */
    @RequestMapping(value = "/requestParam",method = RequestMethod.POST)
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


}

/**
 * 这还是一个用于封装结果的对象
 */
class Res{
    private int code;
    private String message;

    public Res(){}

    public Res(int code, String message){
        this.code = code;
        this.message = message;
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Res{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}