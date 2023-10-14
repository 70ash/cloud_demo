package cn.itcast.mq.helloworld;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;

/**
 * @author zlp
 * @date 2023/10/14 20:43
 */
@SpringBootTest
public class FanoutExchangeTest {
    @Resource
    private RabbitTemplate rabbitTemplate;
    @Test
    public void fanoutTest() {
        String msg = "发送fanout消息";
        String exchangeName = "70ash.exchange";
        rabbitTemplate.convertAndSend(exchangeName,"",msg);
    }
}
