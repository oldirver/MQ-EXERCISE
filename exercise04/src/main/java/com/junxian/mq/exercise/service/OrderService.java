package com.junxian.mq.exercise.service;

import com.junxian.mq.exercise.bo.OrderBO;
import com.junxian.mq.exercise.common.mq.MQService;
import com.junxian.mq.exercise.common.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by KeJunXian on 2016/9/17.
 *
 */
@Service
public class OrderService {

    @Autowired
    private MQService mqService;

    @Autowired
    private LogService logService;

    public void orderQueue(String msg) throws Exception{
        Thread.sleep(100);

        mqService.sendMsg(mqService.ORDER_QUEUE,msg);
//        System.out.println("收到请求，排队中");
        logService.sendLog("收到请求，排队中", "info");
    }

    public boolean addOrder(String msg) {
        try {
            Thread.sleep(1000);

            //数据库创建订单
            OrderBO order = new OrderBO();

            mqService.sendMsg(mqService.INVENTORY_QUEUE, JsonUtil.toJson(order));
            logService.sendLog("下达订单", "info");
            return true;
        } catch (Exception e) {
            logService.sendLog("订单处理失败", "error");
            return false;
        }
    }

    public boolean inventoryChange(String itemId, int count) {
        try {
            //数据库操作，事务管理
//            System.out.println("库存变动");
            logService.sendLog("库存变动成功", "info");
            return true;
        } catch (Exception e) {
            logService.sendLog("库存变动失败", "error");
            return false;
        }
    }
}
