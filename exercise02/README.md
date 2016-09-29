# 练习2
####1.OrderService中add()模拟下单，当订单在数据库中创建后，将订单信息写入队列。
####2.add()方法同步返回成功状态，前台页面通知订单提交成功，并等待。
####3.OrderQueueListener监听队列，并调用OrderService中inventoryChange()方法，根据队列信息调整内容。
####4.订单信息为重要信息，队列开启持久化保存，并加入回调通知在ConfirmCallback中做信息异常处理。
####5.依据inventoryChange()方法库存调整结果，通知用户失败或者成功。
