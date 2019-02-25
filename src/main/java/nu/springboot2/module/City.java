package nu.springboot2.module;

import lombok.Data;

/**
 * @program: spring-boot2-mybatis
 * @author: 努力就是魅力
 * @create: 2018-09-29 11:30
 * description:
 *      -@Data      相当于getter and setter
 *      -@Getter
 *      -@Setter
 *      -@slf4j     可以直接在类里面使用log.info()等日志功能
 **/

//@Data
public class City {

    private String city;
    private String state;

    public City(){}

    public City(String city, String state){
        this.city = city ;
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;

    }

}
