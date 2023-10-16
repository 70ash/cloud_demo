package cn.itcast.mq.listener;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author zlp
 * @date 2023/10/16 14:48
 * TopicExchange的测试
 * TopicExchange与DirectExchange唯一不同的就是TopicExchange可以使用通配符来作为绑定交换机和队列的key
 */
@Component
public class TopicListener {
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "topic.queue1"),
            exchange = @Exchange(name = "70ash.topic",type = ExchangeTypes.TOPIC),
            key = "student.#"
    ))
    public void topicListener1(String msg) {
        System.out.println("接收到来自学生的消息" + msg);
    }
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "topic.queue2"),
            exchange = @Exchange(name = "70ash.topic",type = ExchangeTypes.TOPIC),
            key = "teacher.#"
    ))
    public void topicListener2(String msg) {
        System.out.println("接收到来自老师的消息" + msg);
    }
}
