package nu.springboot2;

import nu.springboot2.kafka.SpringBootKafkaDemo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *      如果有@SpringBootApplication 就不需要指定下面的扫包范围了
 *      @ComponentScan(basePackages = {"nulijiushimeili.springboot2mybatis.controller","nulijiushimeili.springboot2mybatis.order.controller"})               // 加上扫包范围
 */

@SpringBootApplication          // 这是spring boot 最核心的注解， 如果我有这个注解，默认是扫同级包，包括子包
@EnableTransactionManagement //如果mybatis中service实现类中加入事务注解，需要此处添加该注解
//@ComponentScan(basePackages = {"nulijiushimeili.springboot2mybatis.controller",""})               // 加上扫包范围
@MapperScan({"nu.springboot2.mapper",""})  //扫描的是mapper.xml中namespace指向值的包位置
public class SpringBootMainClass implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMainClass.class, args);
    }


    @Autowired
    private SpringBootKafkaDemo springBootKafkaDemo;


    @Override
    public void run(String... args) throws Exception {

        /**
         * 测试spring boot 集成 kafka 的 demo
         */
//        int i = 0;
//        while(true){
//            springBootKafkaDemo.produceData("topic05",String.format("msg_%s,id,name,age,phoneNumber", i++));
//            Thread.sleep(1000);
//        }


    }

}


