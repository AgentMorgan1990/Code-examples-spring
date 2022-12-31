package com.example.springcodeexamples.from_web_to_console;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class ConsoleProcessorApp {

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setPort(9090);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {

            Cat deserializedTree = new ObjectMapper().readValue(new String(delivery.getBody()), Cat.class);
            System.out.println(deserializedTree);

        };
        channel.basicConsume("DISPOSAL2_CREATE_BATCH_EXCHANGE", true, deliverCallback, consumerTag -> {
        });
    }
}
