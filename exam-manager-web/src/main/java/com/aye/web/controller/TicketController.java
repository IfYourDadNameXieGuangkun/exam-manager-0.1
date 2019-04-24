package com.aye.web.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.common.message.Message;
import com.aye.api.provider.TicketProvider;

import com.aye.model.MQUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Aye
 * @Description:
 * @Date: Created in 22:06 2019/4/16
 * @Version: V1.0
 */
@RestController
public class TicketController {

//    @Reference
//    private TicketProvider ticketProvider;
    @GetMapping("hello/{name}")
    public String buyTicket(@PathVariable String name){
        DefaultMQProducer producer = new DefaultMQProducer("test-group");
        producer.setNamesrvAddr("localhost:9876");
        producer.setInstanceName("rmq-instance");
        try {
            producer.start();
            for (int i=0;i<100;i++) {
                MQUser user = new MQUser();
                user.setUsername("abc" + i);
                user.setPassword(String.valueOf(i));
                Message message = new Message("log-topic", "user-tag", JSON.toJSONString(user).getBytes());
                System.out.println("生产者发送消息:" + JSON.toJSONString(user));
                producer.send(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        producer.shutdown();
        return null;
        //return ticketProvider.buyTicket(name);
    }
}
