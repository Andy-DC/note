package com.demo.common.rabbitmq.consume;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消费者监听类
 */
@Component
public class MyListner {

    @RabbitListener(queues = "my_ttl_queue")
    public void msg(String msg){
        System.out.println("消费者消费消息了："+msg);
    }
}
