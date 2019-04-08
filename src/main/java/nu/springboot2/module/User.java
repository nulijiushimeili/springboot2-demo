package nu.springboot2.module;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @program: spring-boot2-mybatis
 * @author: 努力就是魅力
 * @create: 2018-09-27 21:08
 * description:
 *      使用lombok简化程序开发
 *
 *      -@Data      相当于getter and setter
 *      -@Getter
 *      -@Setter
 *      -@slf4j     可以直接在类里面使用log.info()等日志功能
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    private int id;

    private String name;

    private String password;


    private String gender;
    private String cellphone;
    private String email;



}
