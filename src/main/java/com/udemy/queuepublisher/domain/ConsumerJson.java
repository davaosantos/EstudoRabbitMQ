package com.udemy.queuepublisher.domain;

import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ConsumerJson {

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        Gson gson = new Gson();

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String msg =  new String(delivery.getBody());
            JSONObject jsonObject = gson.fromJson(msg, JSONObject.class);
            System.out.println("Message received from : " + msg);
        };

        channel.basicConsume("Queue-1", true , deliverCallback, consumerTag -> {});
    }
}
