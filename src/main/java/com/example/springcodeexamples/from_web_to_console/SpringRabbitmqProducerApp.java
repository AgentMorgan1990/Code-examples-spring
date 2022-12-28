package com.example.springcodeexamples.from_web_to_console;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Пример взаимодействия спринг продюсера с консольным потребителем через отправку сообщений через рест
 *
 * http://127.0.0.1:15672/#/ - ссылка на админку рэббита
 *
 *
 * */
@SpringBootApplication
@RestController
public class SpringRabbitmqProducerApp {

    @Value("${rabbit.routing.key}")
    private String routingKey;

    private RabbitTemplate rabbitTemplate;

    @Autowired
    public void setRabbitTemplate(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @GetMapping("/{message}")
    public String sendMessage(@PathVariable String message) {

        Cat cat = new Cat("Барсик","Белый",4);
        rabbitTemplate.convertAndSend(routingKey,cat);
        return "OK";
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringRabbitmqProducerApp.class, args);
    }
}
