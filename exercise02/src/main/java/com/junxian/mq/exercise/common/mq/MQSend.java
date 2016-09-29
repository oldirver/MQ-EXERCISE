package com.junxian.mq.exercise.common.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by KeJunXian on 2016/9/17.
 *
 */
@Component
public class MQSend {

    @Autowired
    private RabbitTemplate template;

    public final String ORDER_QUEUE = "order";

    public void sendMsg(String queue, String msg) {
        template.convertAndSend(queue, msg);
    }
}
