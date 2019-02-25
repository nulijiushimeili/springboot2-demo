# spring boot + mybatis 读取数据库

#### 创建数据库
```
use testdb;
drop table if exists t_city;
create table t_city(
id int primary key auto_increment,
city varchar(20),
state varchar(10)
)engine = innodb default charset = utf8;

insert into t_city values(1,"zhengzhou","HN");
```

#### maven 的pom 文件
```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>nulijiushimeili</groupId>
    <artifactId>spring-boot2-mybatis</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <packaging>jar</packaging>

    <name>spring-boot2-mybatis</name>
    <description>Demo project for Spring Boot</description>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.0.5.RELEASE</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
        <java.version>1.8</java.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>1.3.2</version>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.apache.commons</groupId>
            <artifactId>commons-lang3</artifactId>
            <version>3.4</version>
        </dependency>

        <!-- alibaba的druid数据库连接池 -->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid-spring-boot-starter</artifactId>
            <version>1.1.9</version>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>

</project>

```

#### spring boot 配置 application.yml
```
#默认使用配置
spring:
  profiles:
    active: dev

#公共配置与profiles选择无关 mapperLocations指的路径是src/main/resources
mybatis:
  typeAliasesPackage: com.xdd.entity
#  mapperLocations: classpath:mapper/*.xml


---

#开发配置
spring:
  profiles: dev

  datasource:
    url: jdbc:mysql://localhost:3306/testdb
    username: root
    password: 123456
    driver-class-name: com.mysql.jdbc.Driver
    # 使用druid数据源
    type: com.alibaba.druid.pool.DruidDataSource


```

#### spring boot 启动器
```

@SpringBootApplication
@EnableTransactionManagement //如果mybatis中service实现类中加入事务注解，需要此处添加该注解
@MapperScan("nulijiushimeili.springboot2mybatis.mapper")  //扫描的是mapper.xml中namespace指向值的包位置
public class SpringBoot2MybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot2MybatisApplication.class, args);
    }
}
```
#### City bean
```
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


``` 

#### mapper

```
@Repository
public interface CityMapper {

    @Select("select * from t_city where state = #{state}")
    City findByState(@Param("state")String state);
}

```

#### controller 
```
@Controller
@RequestMapping(value = "/abv")
public class RegistyController {
 @Autowired
    private CityMapper cityMapper;

    @RequestMapping(value = "/read", method = RequestMethod.GET)
    @ResponseBody
    public City readMybatis(@RequestParam String state) {
        return cityMapper.findByState(state);
    }
}
```
#### 测试url
```
http://localhost:8080/abv/read?state=HN
```

#### spring boot 1 和 spring boot 2 中集成mybatis配置文件application.properties的配置文件的属性有点不同，跨版本的时候要注意


#### lombok  辅助快速开发插件，idea默认支持，eclipse需要额外的插件,在idea中使用总是报错，运行时没有错误
```
@Data             在Entry上使用，相当于Getter and Setter
@Getter           getter
@Setter           setter
@slf4j            相当于private final Logger logger = Logger.getLogger(A.class);  在类上面使用，可以直接在类里面使用log功能

```


## 踩坑记
1. 数据库的字段名和bean的字段名必须保持一致，前后台请求数据的key也必须是一致的。否则会加载不到数据
2. 映射url请求路径不对，比如在类名上添加了@RequestMapping(),在请求的时候只写了类名上了方法上的路径。

