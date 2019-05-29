package nu.springboot2.mapper;

import nu.springboot2.module.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/******************************
 * @ClassName: DemoMapper
 * @time 2019/5/29 21:10
 * @version 1.00
 * @author nulijiushimeili
 * Description: TODO
 ******************************/
public interface DemoMapper {

    /**
     * 传入不定参数的条件查询
     * @param map
     * @return
     */
    public List<User> conditionSearch(@Param("map") Map<String,Object> map);


    /**
     * 插入数据返回自增id，如果不成功返回0
     */
    public Integer insertAndReturnId(User user);

}
