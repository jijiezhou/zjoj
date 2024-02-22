package com.zjj.zjojbackendjudgeservice.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Classname InitRabbitMqBean
 * @Description TODO
 * @Author zjj
 * @Date 2/18/24 4:34 PM
 */

@Slf4j
@Component
public class InitRabbitMqBean {
    @Value("${spring.rabbitmq.host:localhost}")
    private String host;

    @PostConstruct
    public void init() {
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost(host);
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            String EXCHANGE_NAME = "code_exchange";
            channel.exchangeDeclare(EXCHANGE_NAME, "direct");

            // create queue
            String queueName = "code_queue";
            channel.queueDeclare(queueName, true, false, false, null);
            channel.queueBind(queueName, EXCHANGE_NAME, "my_routingKey");
            log.info("message queue start success");
        } catch (Exception e) {
            log.error("message queue start fail", e);
        }
    }
}
