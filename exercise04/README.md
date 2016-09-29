# 练习4
1. 继续采用练习3、4中例子，但在关键步骤加入日志。
2. 日志不再存储到本地磁盘，而是写入消息队列。
3. 创建日志Exchange，以及日志队列（log.error.queue、log.other.queue、log.queue）
4. 创建binding规则，将日志分为error、info、warning等级,所有日志均落入log.queue队列，error信息额外落入log.error.queue队列。
5. 根据日志重要级别，开启本地持久化、ASK确保不会丢失。 
6. 日志服务器订阅各个队列，并将信息写入本地磁盘，另外可以根据日志级别做额外通知、处理。
