package nu.springboot2.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @Program: springboothello
 * @Author: 努力就是魅力
 * @Since: 2019-01-24 14:33
 * Description:
 **/


@Component
public class SpringBootKafkaDemo {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    /**
     * kafka 生产者
     * @param topic        topic name
     * @param message      message
     */
    public void produceData(String topic, String message){
        kafkaTemplate.send(topic, message);
    }


//    /**
//     * kafka 消费者
//     * @param record  监听到的每一条 kafka message
//     */
//    @Async
//    @KafkaListener(topics = "topic05", groupId = "group1" )
//    public void receiveData(String record){
//        System.out.println(record);
//    }

}
