package com.udemy.queuepublisher.domain;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class DirectConsumer {

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();

//        DeliverCallback deliverCallback2 = new DeliverCallback() {
//            @Override
//            public void handle(String s, Delivery delivery) throws IOException {
//                String message = new String( delivery.getBody());
//                System.out.println("Message received = " + message);
//            }
//        };

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String( delivery.getBody());
            System.out.println("Message received = " + message);
        };

        channel.basicConsume("Mobile", true , deliverCallback, consumerTag -> {});
        channel.basicConsume("TV", true , deliverCallback, consumerTag -> {});
        channel.basicConsume("AC", true , deliverCallback, consumerTag -> {});

    }
}
