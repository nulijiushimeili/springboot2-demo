# Spring Boot hello word

## spring boot 的基本环境搭建
1. 创建一个maven项目，添加pom中的依赖
```
  <!--spring boot 父节点依赖，引入这个以后相关的引用就需要添加version配置，spring boot 自动选择合适的版本进行添加-->
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>1.4.0.RELEASE</version>
    </parent>

    <properties>
        <!--指定jdk的版本号，默认是1.6-->
        <java.version>1.8</java.version>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <!--因为上面指定了spring boot 父节点依赖，，所以不需要指定version-->
        <!--<version></version>-->
    </properties>


    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
    </dependencies>
```

2. 创建一个Controller的类，添加映射@RequestController
```
/**
 * 这里使用@RestController， 相当于@Controller & @RequestBody的组合
 */
@RestController
public class HelloController {

    /**
     * 通过RequestMapping 建立请求映射，
     * 在浏览器地址栏输入 http://localhost:8080/hello         节可以访问页面了
     * @return
     */
    @RequestMapping("/hello")
    public String sayHello(){
        return "hello";
    }
}

```
3. 创建一个spring boot程序的入口程序，启动spring boot
```
 /** 
 在这里我们使用@SpringBootApplication来指定这是一个Spring boot程序
 */
@SpringBootApplication
public class BootClass {
    public static void main(String[] args) {
        /**
         * 在main方法中开始spring boot程序的运行
         *
         */
        SpringApplication.run(BootClass.class,args);
    }
}
```

### spring boot 的多环境配置
- application-dev.properties      创建开发环境
- application-test.properties      创建测试环境
- application-product.properties   创建生产环境 
- java运行spring-boot程序的命令：
```
java -jar spring-boot-hello-0.0.1.jar --spring.profiles=dev
java -jar spring-boot-hello-0.0.1.jar --spring.profiles=test
java -jar spring-boot-hello-0.0.1.jar --spring.profiles=product
```

### 全局异常的处理
```
@ControllerAdvice
public class MyControllerAdvice {


    /**
     * 全局异常捕获类， 所有的全局异常都会被捕获到
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Map<String, Object> exceptionHandler(Exception ex){
        Map<String, Object> map = new HashMap<>();
        map.put("code",-1);
        map.put("msg", ex.getMessage());
        return map;
    }
}
```




### tips
#### bean,dao,service,action业务分层设计

- bean 是实体类，对应实际当中要操作的对象；

- dao是接口层，定义共用的接口方法等；对应的还会有dao的实现类，实现类里会私有一个hibernateTemplate对象，直接对数据库增删改查；

- service是对外的接口层，对应的还有service的实现类，其实service实现类里调用的还是dao的实现类里的方法，

- action就是具体的处理，如果有service层，action里调用service层的实现类方法，没有service，就直接调用dao的实现类方法。

- 不管页面是jsp或者html+css+js/jquery, 页面这块会发出请求到action（这里会有配置文件或者注解指到某一个action），action就和上边的关联起来了

#### spring boot cache manager 
```
Cache : 
缓存接口，定义缓存操作，实现有： RedisCache,EhCacheCache,ConcurrentMapCache

CacheManager :
缓存管理器，管理各种缓存插件

@Cacheable  主要对方法配置，能够根据方法的请求参数对其结果进行缓存

@CacheEvict 清空缓存

@CachePut 保证方法被调用，又希望结果会被缓存

@EnableCaching 开启基于注解的缓存

@keyGenerator 缓存数据时key生成策略

serialize 缓存数据时value序列化生成策略    
```