package nu.springboot2.service;


import nu.springboot2.mapper.UserMapper;
import nu.springboot2.module.Page;
import nu.springboot2.module.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Program: spring-boot2-demo
 * @Author: 努力就是魅力
 * @Since: 2019-04-08 22:25
 * Description:  TODO
 **/

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> queryAllUserByPage(Map<String, Integer> map) {
        return userMapper.queryAllUserByPage(map);
    }

    @Override
    public Integer userCount() {
        return userMapper.userCount();
    }
}
