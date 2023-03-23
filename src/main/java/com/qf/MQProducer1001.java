package com.qf;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

/**
 * @author Wuyq
 * @time 2023/3/23-18:52
 */

public class MQProducer1001 {

    public static void main(String[] args) throws Exception {

        DefaultMQProducer mqProducer = new DefaultMQProducer("my-producer-group1001");

        mqProducer.setNamesrvAddr("192.168.49.129:9876");

        mqProducer.start();

        for (int i = 0; i < 10; i++) {

            Message message = new Message("MyTopic1001","Tag1001",("hello 第"+i+"个雪乃,rocketmq...").getBytes());

            SendResult send = mqProducer.send(message);

            System.out.println(send);

        }

        mqProducer.shutdown();

    }

}
