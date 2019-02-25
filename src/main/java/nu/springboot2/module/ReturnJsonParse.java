package nu.springboot2.module;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Program: spring-boot2-mybatis
 * @Author: 努力就是魅力
 * @Since: 2019-02-22 22:52
 * Description:
 **/


public class ReturnJsonParse extends MappingJackson2HttpMessageConverter {
    public ReturnJsonParse(){
        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.TEXT_PLAIN);
        setSupportedMediaTypes(mediaTypes);
    }
}