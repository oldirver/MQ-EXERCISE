package com.junxian.mq.exercise.service;

import com.junxian.mq.exercise.bo.UserBO;
import org.springframework.stereotype.Service;

/**
 * Created by KeJunXian on 2016/9/17.
 *
 */
@Service
public class EmailService {

    public void sendEmail(UserBO user) {
        try {
            Thread.sleep(1000 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发送邮件");
    }

}
