package com.junxian.mq.exercise.common.mq.callback;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.stereotype.Component;

/**
 * Created by KeJunXian on 2016/9/17.
 *
 */
@Component
public class ConfirmCallback implements RabbitTemplate.ConfirmCallback {

    @Override
    public void confirm(CorrelationData correlationData, boolean ask, String s) {
        //错误处理
        if (ask) {
            System.out.println(s);
        } else {
            System.out.println(s);
        }
    }


}
