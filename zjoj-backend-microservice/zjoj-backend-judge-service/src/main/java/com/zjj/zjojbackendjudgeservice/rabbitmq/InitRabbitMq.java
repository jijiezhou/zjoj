package com.zjj.zjojbackendjudgeservice.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;

/**
 * @Classname InitRabbitMq
 * @Description Test Exchange and queue(Only execute once when program starts)
 * @Author zjj
 * @Date 2/9/24 3:53 PM
 */
@Slf4j
public class InitRabbitMq {
    public static void doInit(){
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            String EXCHANGE_NAME = "code_exchange";
            channel.exchangeDeclare(EXCHANGE_NAME, "direct");

            // create a queue
            String queueName = "code_queue";
            channel.queueDeclare(queueName, true, false, false, null);
            channel.queueBind(queueName, EXCHANGE_NAME, "my_routingKey");
            log.info("RabbitMQ start success");
        } catch (Exception e) {
            log.error("RabbitMQ start fail");
        }

    }

    public static void main(String[] args){
        doInit();
    }
}
