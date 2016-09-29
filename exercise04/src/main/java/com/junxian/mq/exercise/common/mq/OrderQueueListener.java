package com.junxian.mq.exercise.common.mq;

import com.junxian.mq.exercise.bo.OrderBO;
import com.junxian.mq.exercise.common.utils.JsonUtil;
import com.junxian.mq.exercise.service.OrderService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by KeJunXian on 2016/9/17.
 *
 */
@Component
public class OrderQueueListener implements MessageListener {

    @Autowired
    private OrderService orderService;

    @Override
    public void onMessage(Message message) {
        orderService.addOrder("");
    }
}
