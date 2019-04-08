package nu.springboot2.mapper;

import nu.springboot2.module.Page;
import nu.springboot2.module.User;

import java.util.List;
import java.util.Map;

/**
 * @Program: spring-boot2-demo
 * @Author: 努力就是魅力
 * @Since: 2019-04-08 22:21
 * Description:  TODO
 **/


public interface UserMapper {

    List<User> queryAllUserByPage(Map<String,Integer> map);

    Integer userCount();
}
