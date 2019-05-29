package nu.springboot2.service;

import nu.springboot2.mapper.DemoMapper;
import nu.springboot2.module.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/******************************
 * @ClassName: DemoServiceImpl
 * @time 2019/5/29 21:13
 * @version 1.00
 * @author nulijiushimeili
 * Description: TODO
 ******************************/
@Service
public class DemoServiceImpl implements IDemoService{

    @Autowired
    private DemoMapper demoMapper;

    /**
     * 插入数据返回自增id，如果不成功返回0, 这里是关键
     */
    @Override
    public Integer insertAndReturnId(User user){
         demoMapper.insertAndReturnId(user);
        return user.getId();
    }

}
