package nu.springboot2.test;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
 * @Since: 2019-02-18 22:57
 * @Description:
 *
 *     使用 HttpURLConnection 实现调用restful接口
 *
 *     restful interface :
 * @See nulijiushimeili.springboot2mybatis.controller.RestfulTestController
 **/


public class RequestRestfulDemo {
    public static void main(String[] args) {
//        restfulReq("put");
        restfulReq("post");
//        restfulReq("delete");
//        restfulReq("get");
    }


//    /**
//     * http://localhost:8080/restfulReq/put
//     * http://localhost:8080/restfulReq/post
//     * http://localhost:8080/restfulReq/delete
//     * http://localhost:8080/restfulReq/get
//     * @param param
//     * @return
//     */
//    @RequestMapping(value = "/restfulReq/{param}")
//    @ResponseBody
//    public String restfulReq(@PathVariable String param ){
    public static String restfulReq( String param ){

        try{
            String url = "http://localhost:8080/";
            url += (param + "/xxx");
            URL restServiceURL = new URL(url);
            HttpURLConnection httpURLConnection = (HttpURLConnection)restServiceURL.openConnection();

            // 将请求方式的小写转换为大写
            httpURLConnection.setRequestMethod(param.toUpperCase());

            if("post".equals(param)){
                // 打开输出开关
                httpURLConnection.setDoOutput(true);

                String input = "id : " + URLEncoder.encode("abc","UTF-8");
                input+="&name="+ URLEncoder.encode("啊啊啊", "UTF-8");
                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(input.getBytes());
                outputStream.flush();
            }


            if (httpURLConnection.getResponseCode() != 200) {
                throw new RuntimeException(
                        "HTTP GET Request Failed with Error code : "
                                + httpURLConnection.getResponseCode());
            }
            BufferedReader responseBuffer = new BufferedReader(
                    new InputStreamReader((httpURLConnection.getInputStream())));
            String output;
            System.out.println("Output from Server:  \n");
            while ((output = responseBuffer.readLine()) != null) {
                System.out.println(output);
            }
            httpURLConnection.disconnect();

        }catch (Exception e){
            e.printStackTrace();
        }

        return "success";
    }

}
