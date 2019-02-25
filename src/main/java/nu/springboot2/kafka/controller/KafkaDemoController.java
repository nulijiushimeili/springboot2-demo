package nu.springboot2.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Program: springboothello
 * @Author: 努力就是魅力
 * @Since: 2019-01-24 15:00
 * Description:
 **/

@RestController
public class KafkaDemoController {


    @Autowired
    private KafkaTemplate<Object, Object> kafkaTemplate;

    @PostMapping(path = "/send/foo/{what}")
    public void sendFoo(@PathVariable String what) {
        this.kafkaTemplate.send("topic1", what);
    }

}
