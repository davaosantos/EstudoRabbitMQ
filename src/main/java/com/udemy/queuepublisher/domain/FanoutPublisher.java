package com.udemy.queuepublisher.domain;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class FanoutPublisher {

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();

        String msgFanout = "Message for Mobile and AC";

        channel.basicPublish("Fanout-Exchange", "", null, msgFanout.getBytes());
        channel.close();
        connection.close();
    }
}
