package com.qf;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

import java.sql.SQLOutput;
import java.util.List;

/**
 * @author Wuyq
 * @create 2023/3/23 19:06
 */

public class MQConsumer1001 {

    public static void main(String[] args) throws MQClientException {

        DefaultMQPushConsumer pushConsumer = new DefaultMQPushConsumer("my-consumer-group1001");

        pushConsumer.setNamesrvAddr("192.168.49.129:9876");

        pushConsumer.subscribe("MyTopic1001","*");

        pushConsumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                list.forEach(messageExt -> {
                    System.out.println(new String(messageExt.getBody()));
                });
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });

        pushConsumer.start();
        System.out.println("消费者开始消费了...");



    }

}
