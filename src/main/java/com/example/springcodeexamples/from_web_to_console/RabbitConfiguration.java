package com.example.springcodeexamples.from_web_to_console;


import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.DefaultClassMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Пример настройки рэббита, создание эксченджеров, очередей и их связывание
 *
 * Существует три видв обменников:
 *
 *  DirectExchange - рассылка по ключу
 *
 *  TopicExchange - рассылка с возможностью более тонкой настройки
 *
 *  FanoutExchange - рассылка всем
 *
 * */
@EnableRabbit
@Configuration
public class RabbitConfiguration {

    @Value("${rabbit.host}")
    private String host;

    @Value("${rabbit.port}")
    private int port;

    @Value("${rabbit.exchanger.name}")
    private String exchangerName;

    @Value("${rabbit.queue.name}")
    private String queueName;

    @Value("${rabbit.routing.key}")
    private String routingKey;


    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory =
                new CachingConnectionFactory(host, port);
        return connectionFactory;
    }


//    @Bean
//    public AmqpAdmin amqpAdmin() {
//        RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory());
//        return rabbitAdmin;
//    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
        rabbitTemplate.setExchange(exchangerName);
        rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Queue myQueue() {
        return new Queue(queueName);
    }

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange(exchangerName);
    }

    @Bean
    public Binding binding(){
        return BindingBuilder.bind(myQueue()).to(directExchange()).with(routingKey);
    }
}
