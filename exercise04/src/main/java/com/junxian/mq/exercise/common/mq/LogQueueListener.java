package com.junxian.mq.exercise.common.mq;

import com.junxian.mq.exercise.service.LogService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by KeJunXian on 2016/9/17.
 *
 */
@Component
public class LogQueueListener implements MessageListener {

    @Autowired
    private LogService logger;

    @Override
    public void onMessage(Message message) {
        String msg = new String(message.getBody());
        logger.log(msg);
    }
}
