package com.junxian.mq.exercise.service;

import com.junxian.mq.exercise.bo.OrderBO;
import com.junxian.mq.exercise.common.mq.MQSend;
import com.junxian.mq.exercise.common.utils.JsonUtil;
import org.springframework.amqp.AmqpException;
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

    public void orderQueue(String msg) throws AmqpException, InterruptedException {
        Thread.sleep(100);
        mqSend.sendMsg(mqSend.ORDER_QUEUE,msg);
        System.out.println("收到请求，排队中");
    }

    public boolean addOrder(String msg) {
        try {
            Thread.sleep(1000);

            //数据库创建订单
            OrderBO order = new OrderBO();

            System.out.println("下达订单");

            mqSend.sendMsg(mqSend.INVENTORY_QUEUE, JsonUtil.toJson(order));
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
