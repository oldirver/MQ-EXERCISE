package com.junxian.mq.exercise.service;

import com.junxian.mq.exercise.bo.OrderBO;
import com.junxian.mq.exercise.common.mq.MQSend;
import com.junxian.mq.exercise.common.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

/**
 * Created by KeJunXian on 2016/9/17.
 *
 */
@Service
public class OrderService {

    @Autowired
    private MQSend mqSend;

    public boolean add(String msg) {
        try {
            //数据库创建订单
            OrderBO order = new OrderBO();

            System.out.println("下达订单");

            mqSend.sendMsg(mqSend.ORDER_QUEUE, JsonUtil.toJson(order));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean inventoryChange(String itemId, int count) {
        try {
            //数据库操作，事务管理
            System.out.println("库存变动");
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
