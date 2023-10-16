package cn.itcast.mq.helloworld;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author zlp
 * @date 2023/10/16 14:33
 */
@SpringBootTest
public class DirectPublisher {
    @Resource
    private RabbitTemplate rabbitTemplate;
    @Test
    public void testDirectExchange1() {
        String exchangeName = "70ash.direct";
        String routingKey = "yellow";
        String msg = "hello,yellow";
        rabbitTemplate.convertAndSend(exchangeName,routingKey,msg);
    }
    @Test
    public void testDirectExchange2() {
        String exchangeName = "70ash.direct";
        String routingKey = "blue";
        String msg = "hello,blue";
        rabbitTemplate.convertAndSend(exchangeName,routingKey,msg);
    }
}
