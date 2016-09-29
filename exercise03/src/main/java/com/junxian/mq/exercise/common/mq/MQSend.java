package com.junxian.mq.exercise.common.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by KeJunXian on 2016/9/17.
 *
 */
@Component
public class MQSend {

    @Autowired
    private AmqpTemplate template;

    public final String INVENTORY_QUEUE = "inventory";

    public final String ORDER_QUEUE = "order";

    public void sendMsg(String queue, String msg) {
        template.convertAndSend(queue, msg);
    }
}
