package com.stackroute.auth.authapp.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;//
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*
@Configuration
public class MessageConfiguration {
    // exchange, queue, Jackson, RabbitTemplate, binding
    private String exchange_name="mail_exchange";
    private String queue_name="mail_queue";
    @Bean
    public DirectExchange getDirectExchange(){
        return new DirectExchange(exchange_name);
    }
    @Bean
    public Queue getQueue(){
        return new Queue(queue_name);
    }
    @Bean
    public Jackson2JsonMessageConverter getProducerJacksonConverter(){
        return new Jackson2JsonMessageConverter();
    }
    @Bean
    public RabbitTemplate getRabbitTemplate(final ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(getProducerJacksonConverter());
        return rabbitTemplate;
    }
    @Bean
    public Binding getBinding(Queue q, DirectExchange directExchange){
        return BindingBuilder.bind(q).to(directExchange).with("mail_routing");
    }
}
*/