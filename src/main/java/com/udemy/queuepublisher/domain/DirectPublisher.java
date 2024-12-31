package com.udemy.queuepublisher.domain;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class DirectPublisher {

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        String messageMOB = "This is mobile";
        String messageTV = "This is tv";
        String messageAC = "This is AC";

        channel.basicPublish("Direct-Exchange", "mobile", null, messageMOB.getBytes());
        channel.basicPublish("Direct-Exchange", "tv", null, messageTV.getBytes());
        channel.basicPublish("Direct-Exchange", "ac", null, messageAC.getBytes());
        channel.close();
        connection.close();
    }
}
