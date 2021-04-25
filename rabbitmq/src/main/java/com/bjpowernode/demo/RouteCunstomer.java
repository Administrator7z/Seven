package com.bjpowernode.demo;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RouteCunstomer {
                                               //临时队列                                         //自定交换机名称和类型
    @RabbitListener(bindings = @QueueBinding(value = @Queue,exchange = @Exchange(value = "directs",type = "direct"),key = {"info","error","warn"}))
    public void receive1(String message){
        System.out.println("message1"+ message);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue,exchange = @Exchange(value = "directs",type = "direct"),key = {"error"}))
    public void receive2(String message){
        System.out.println("message2"+ message);
    }
}