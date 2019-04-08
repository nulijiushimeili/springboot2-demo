package nu.springboot2.module;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * @Program: spring-boot2-demo
 * @Author: 努力就是魅力
 * @Since: 2019-04-08 22:02
 * Description:  bootstrap 分页显示使用的实体类
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Page {
    private Integer total;
    private List<?> rows;
}
