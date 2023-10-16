package cn.itcast.mq.helloworld;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zlp
 * @date 2023/10/16 15:26
 * Spring在rabbit中默认的序列化是由org.springframework.amqp.support.converter.MessageConverter处理的,默认实现类是SimpleMessageConverter;
 * 我们要用json序列化,所以需要覆盖这个实现类
 */
@SpringBootTest
public class ObjectPublisher {
    @Resource
    private RabbitTemplate rabbitTemplate;
    @Test
    public void testObjectPublish() {
        Map msg = new HashMap();
        String queueName = "object.queue";
        msg.put("name","zlp");
        msg.put("age",20);
        rabbitTemplate.convertAndSend(queueName,msg);
    }
}
