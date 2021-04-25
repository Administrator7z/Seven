package com.bjpowernode.demo;


import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component       //默认常用持久化非独占不自动删除//是否持久化//是否自动删除durable = "false", autoDelete = "true"
@RabbitListener(queuesToDeclare = @Queue(value = "hello"))
public class HelloCunstomer {



    @RabbitHandler
    public void receivel(String message){
        System.out.println("message" + message);

    }
}
