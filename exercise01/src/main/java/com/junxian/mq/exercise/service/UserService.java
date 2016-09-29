package com.junxian.mq.exercise.service;

import com.junxian.mq.exercise.bo.UserBO;
import com.junxian.mq.exercise.common.mq.MQSend;
import com.junxian.mq.exercise.common.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by KeJunXian on 2016/9/18.
 *
 */
@Service
public class UserService {

    @Autowired
    private MQSend mqSend;

    public boolean register(String username) {
        try {
            //数据库操作
            mqSend.sendMsg(mqSend.EMAIL_QUEUE, JsonUtil.toJson(new UserBO()));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
