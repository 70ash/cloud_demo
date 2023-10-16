package cn.itcast.mq.helloworld;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author zlp
 * @date 2023/10/16 15:04
 */
@SpringBootTest
public class TopicPublisher {
    @Resource
    private RabbitTemplate rabbitTemplate;
    @Test
    public void testTopicExchange1() {
        String exchangeName = "70ash.topic";
        String routingKey = "student.news";
        String msg = "我勒个豆";
        rabbitTemplate.convertAndSend(exchangeName,routingKey,msg);
    }
    @Test
    public void testTopicExchange2() {
        String exchangeName = "70ash.topic";
        String routingKey = "teacher.news";
        String msg = "你如何形容我";
        rabbitTemplate.convertAndSend(exchangeName,routingKey,msg);
    }
}
