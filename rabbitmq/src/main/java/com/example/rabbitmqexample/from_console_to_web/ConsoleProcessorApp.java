package com.example.rabbitmqexample.from_console_to_web;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConsoleProcessorApp {
    public static final String EXCHANGER_FOR_PROCESSING_RESULTS = "disposal_v2";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setPort(9090);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        for (int i = 0; i < 10; i++) {
            log.info("Сообщение отправлено");
            channel.basicPublish(EXCHANGER_FOR_PROCESSING_RESULTS, "sms", null, "Task ready".getBytes());
        }
    }
}
