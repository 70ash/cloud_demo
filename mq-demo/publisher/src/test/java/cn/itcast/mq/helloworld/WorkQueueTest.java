package cn.itcast.mq.helloworld;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author zlp
 * @date 2023/10/14 19:48
 */
@SpringBootTest
public class WorkQueueTest {
    @Resource
    private RabbitTemplate rabbitTemplate;
    @Test
    public void test() {
        // 发送消息必须要先有队列才可以发送
        String queueName = "simple.queue";
        String message = "hello,nihao";
        rabbitTemplate.convertAndSend(queueName,message);
    }
    @Test
    public void testWorkQueue() throws InterruptedException {
        String queueName = "simple.queue";
        String message = "hello,nihao";
        for (int i = 0; i < 50; i++) {
            rabbitTemplate.convertAndSend(queueName,message+i);
            Thread.sleep(20);
        }
    }
}
