package com.junxian.mq.exercise.common.mq;

import com.junxian.mq.exercise.bo.UserBO;
import com.junxian.mq.exercise.common.utils.JsonUtil;
import com.junxian.mq.exercise.service.EmailService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by KeJunXian on 2016/9/17.
 *
 */
@Component
public class EmailQueueListener implements MessageListener {

    @Autowired
    private EmailService emailService;

    @Override
    public void onMessage(Message message) {
        UserBO user = JsonUtil.toObj(new String(message.getBody()), UserBO.class);
        emailService.sendEmail(user);
    }
}
