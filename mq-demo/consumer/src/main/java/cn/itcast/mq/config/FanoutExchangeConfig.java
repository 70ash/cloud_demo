package cn.itcast.mq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zlp
 * @date 2023/10/14 20:43
 */
@Configuration
public class FanoutExchangeConfig {
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("70ash.exchange");
    }
    @Bean
    public Queue fanoutQueue1() {
        return new Queue("fanoutQueue1");
    }
    @Bean
    public Queue fanoutQueue2() {
        return new Queue("fanoutQueue2");
    }
    @Bean
    public Binding bindExchange2queue1(FanoutExchange fanoutExchange, Queue fanoutQueue1) {
        return BindingBuilder.bind(fanoutQueue1).to(fanoutExchange);
    }
    @Bean
    public Binding bindExchange2queue2(FanoutExchange fanoutExchange, Queue fanoutQueue2) {
        return BindingBuilder.bind(fanoutQueue2).to(fanoutExchange);
    }
}
