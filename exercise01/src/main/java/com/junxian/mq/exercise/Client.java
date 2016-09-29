package com.junxian.mq.exercise;

import com.junxian.mq.exercise.common.mq.MQSend;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by KeJunXian on 2016/9/18.
 *
 */
public class Client {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MQSend send = context.getBean(MQSend.class);

        send.sendMsg(send.EMAIL_QUEUE, "");
    }
}
