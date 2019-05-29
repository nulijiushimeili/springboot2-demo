package nu.springboot2.service;

import nu.springboot2.module.User;

import java.util.Map;

/******************************
 * @ClassName: IDemoService
 * @time 2019/5/29 21:12
 * @version 1.00
 * @author nulijiushimeili
 * Description: TODO
 ******************************/
public interface IDemoService {

    /**
     * 插入数据返回自增id，如果不成功返回0
     */
    public Integer insertAndReturnId(User user);
}
