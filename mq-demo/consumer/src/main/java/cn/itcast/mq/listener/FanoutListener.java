package cn.itcast.mq.listener;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author zlp
 * @date 2023/10/16 14:26
 */
@Component
public class FanoutListener {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "fanoutQueue1"),
            exchange = @Exchange(name="70ash.fanout", type = ExchangeTypes.FANOUT)
    ))
    public void ListenerFanoutMessage1(String msg) {
        System.out.println("接收到消息"+ msg);
    }
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "fanoutQueue2"),
            exchange = @Exchange(name="70ash.fanout", type = ExchangeTypes.FANOUT)
    ))
    public void ListenerFanoutMessage2(String msg) {
        System.out.println("接收到消息"+ msg);
    }
}
