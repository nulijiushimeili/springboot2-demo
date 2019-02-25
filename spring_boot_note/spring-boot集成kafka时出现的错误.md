# spring boot 集成 kafka 时 出现jar 包冲突，项目无法启动

1. 错误描述：

   ```log
   [ERROR] 2019-02-25 22:32:42 [main] o.s.boot.SpringApplication - Application run failed
   org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'kafkaListenerContainerFactoryConfigurer' defined in class path resource [org/springframework/boot/autoconfigure/kafka/KafkaAnnotationDrivenConfiguration.class]: Post-processing of merged bean definition failed; nested exception is java.lang.IllegalStateException: Failed to introspect Class [org.springframework.boot.autoconfigure.kafka.ConcurrentKafkaListenerContainerFactoryConfigurer] from ClassLoader [sun.misc.Launcher$AppClassLoader@18b4aac2]
   
   ```

   

2. 错误原因：版本冲突

   ```xml
    <!-- spring boot 集成 kafka -->
           <dependency>
               <groupId>org.springframework.kafka</groupId>
               <artifactId>spring-kafka</artifactId>
               <version>2.2.3.RELEASE</version>
           </dependency>
   ```

   

3.  解决方案:删除kafka的版本号

   ```xml
    <!-- spring boot 集成 kafka -->
           <dependency>
               <groupId>org.springframework.kafka</groupId>
               <artifactId>spring-kafka</artifactId>
           </dependency>
   ```

   