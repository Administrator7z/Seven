package com.bjpowernode.demo;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FanoutCunstomer {
                                                        //创建临时队列                      //绑定的交换机
    @RabbitListener(bindings = @QueueBinding(value = @Queue, exchange = @Exchange(value = "log", type = "fanout")))
    public void receive1(String messgae) {
        System.out.println("message" + messgae);
    }


}
