package com.junxian.mq.exercise.common.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by KeJunXian on 2016/9/17.
 *
 */
@Component
public class MQService {

    @Autowired
    private RabbitTemplate template;

    public final String INVENTORY_QUEUE = "inventory.queue";

    public final String ORDER_QUEUE = "order.queue";

    public final String LOG_EXCHANGE = "log.exchange";

    public void sendMsg(String queue, String msg) {
        template.convertAndSend(queue, msg);
    }

    public void sendMsg(String exchange, String key, String msg) {
        template.convertAndSend(exchange, key, msg);
    }

}
