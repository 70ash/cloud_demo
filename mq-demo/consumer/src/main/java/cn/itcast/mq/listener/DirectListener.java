package cn.itcast.mq.listener;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author zlp
 * @date 2023/10/16 14:26
 */
@Component
public class DirectListener {
    // 使用注解的方式绑定交换机和队列,再绑定到消费者上
    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(name = "direct.queue1"),
                    exchange = @Exchange(name = "70ash.direct",type = ExchangeTypes.DIRECT),
                    key = {"red","blue"}
            )
    )
    public void directListener1(String msg) {
        System.out.println("directListener1接收到消息" + msg);
    }
    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(name = "direct.queue2"),
                    exchange = @Exchange(name = "70ash.direct",type = ExchangeTypes.DIRECT),
                    key = {"red","yellow"}
            )
    )
    public void directListener2(String msg) {
        System.out.println("directListener2接收到消息" + msg);
    }
}
