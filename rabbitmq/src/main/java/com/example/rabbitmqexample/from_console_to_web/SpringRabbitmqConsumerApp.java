package com.example.rabbitmqexample.from_console_to_web;

import com.example.rabbitmqexample.from_web_to_console.Cat;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@Slf4j
public class SpringRabbitmqConsumerApp {

    @RabbitListener(queues = "${rabbit.queue.name}")
    public void receiveMessage(Cat cat) {
        log.info("Received message as a generic AMQP 'Message' wrapper: {}", cat.toString());
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringRabbitmqConsumerApp.class, args);
    }
}
