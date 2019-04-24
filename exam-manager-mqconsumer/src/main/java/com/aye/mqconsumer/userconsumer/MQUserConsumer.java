package com.aye.mqconsumer.userconsumer;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * @Author Aye
 * @Description:
 * @Date: Created in 18:10 2019/4/23
 * @Version: V1.0
 */
public class MQUserConsumer {

    public static void main(String[] args) {


        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("test-group");
        consumer.setNamesrvAddr("localhost:9876");
        consumer.setInstanceName("rmq-instance");
        try {
            consumer.subscribe("log-topic", "user-tag");
            consumer.registerMessageListener(new MessageListenerConcurrently() {

                public ConsumeConcurrentlyStatus consumeMessage(
                        List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                    for (MessageExt msg : msgs) {
                        System.out.println("消费者消费数据:"+new String(msg.getBody()));
                    }
                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                }
            });
            consumer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }


    }
}


