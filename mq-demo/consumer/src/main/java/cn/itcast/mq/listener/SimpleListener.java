package cn.itcast.mq.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

import org.springframework.stereotype.Component;

import java.time.LocalTime;

/**
 * @author zlp
 * @date 2023/10/14 20:00
 */
@Component
public class SimpleListener {
    @RabbitListener(queues = "simple.queue")
    public void ListenerMessage1(String msg) throws InterruptedException {
        System.out.println("接收到消息"+msg+ LocalTime.now());
        Thread.sleep(20);
    }
    @RabbitListener(queues = "simple.queue")
    public void ListenerMessage2(String msg) throws InterruptedException {
        System.err.println("接收到消息"+ msg+LocalTime.now());
        Thread.sleep(200);
    }
}
