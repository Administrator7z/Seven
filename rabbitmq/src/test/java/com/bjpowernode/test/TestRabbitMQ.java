package com.bjpowernode.test;


import com.bjpowernode.RabbitmqApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import javax.annotation.Resource;

@SpringBootTest(classes = RabbitmqApplication.class)
@RunWith(SpringRunner.class)
public class TestRabbitMQ {

    @Resource
    private RabbitTemplate rabbitTemplate;

    @Test
    public void test(){
        rabbitTemplate.convertAndSend("hello","hello word");
    }
    //work模型
    @Test
    public void workTest(){
        rabbitTemplate.convertAndSend("work","work模型");
    }
    //fanout广播模型
    @Test
    public void fanoutTest(){
        rabbitTemplate.convertAndSend("log","","fanout模型发送的消息");
    }
    //route路由模型
    @Test
    public void routeTest(){
        rabbitTemplate.convertAndSend("directs","info","direct发送info的key路由信息");
    }
    //topic 动态路由 订阅模式
    @Test
    public void topicTest(){
        rabbitTemplate.convertAndSend("topics","user.save","user.save路由信息");
    }

}
