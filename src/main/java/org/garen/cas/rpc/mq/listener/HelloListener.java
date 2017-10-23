package org.garen.cas.rpc.mq.listener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "hello")
public class HelloListener {
    @RabbitHandler
    public void process(String hello) throws InterruptedException {
        System.out.println("=====================listener : " + hello);
    }
}
