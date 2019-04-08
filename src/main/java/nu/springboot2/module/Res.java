package nu.springboot2.module;

/**
 * @Program: spring-boot2-demo
 * @Author: 努力就是魅力
 * @Since: 2019-04-08 22:29
 * Description:  TODO
 **/


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 这是一个用于封装结果的对象
 */
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Res{
    private int code;
    private String message;
}
