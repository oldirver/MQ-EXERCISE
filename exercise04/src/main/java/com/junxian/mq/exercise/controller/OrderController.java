package com.junxian.mq.exercise.controller;

import com.junxian.mq.exercise.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * Created by KeJunXian on 2016/9/18.
 *
 */
@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    public String addOrder(String msg) {
        try {
            orderService.orderQueue(msg);
            return "排队中，请稍后";
        } catch (Exception e) {
            //捕获信息创建失败异常
            return "队列已满";
        }
    }

}
