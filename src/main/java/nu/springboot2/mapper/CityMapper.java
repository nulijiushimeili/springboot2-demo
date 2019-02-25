package nu.springboot2.mapper;

import nu.springboot2.module.City;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: spring-boot2-mybatis
 * @author: 努力就是魅力
 * @create: 2018-09-29 11:29
 * description:
 **/

public interface CityMapper {


//    @Select("select * from t_city where state = #{state}")
    public List<City> findByState(@Param("state")String state);
}
