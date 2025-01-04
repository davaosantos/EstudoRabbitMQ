package com.udemy.queuepublisher.utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ConnectionRabbit {



    public static Channel createChannel() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        com.rabbitmq.client.Connection connection = factory.newConnection();
        return connection.createChannel();
    }

    public static void closeConnections(com.rabbitmq.client.Channel channel) throws IOException, TimeoutException {
        channel.close();
        channel.getConnection().close();
    }
}
