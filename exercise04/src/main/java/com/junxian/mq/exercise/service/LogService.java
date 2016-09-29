package com.junxian.mq.exercise.service;

import com.junxian.mq.exercise.common.mq.MQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.logging.Logger;

/**
 * Created by KeJunXian on 2016/9/18.
 *
 */
@Service
public class LogService {

    @Autowired
    private MQService mqService;

    public void log(String log) {
        System.out.println(log);
    }

    public void sendLog(String msg, String type) {
        msg = "[" + type + "]" + ":" + new Date().getTime() + " " + msg;
        mqService.sendMsg(mqService.LOG_EXCHANGE, "log." + type, msg);
    }
}
