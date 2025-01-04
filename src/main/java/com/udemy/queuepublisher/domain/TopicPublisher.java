package com.udemy.queuepublisher.domain;

import com.rabbitmq.client.Channel;
import com.udemy.queuepublisher.utils.ConnectionRabbit;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class TopicPublisher {
    public static void main(String[] args) throws IOException, TimeoutException {

        String msg = "Message for Mobile and AC";

        Channel channel = ConnectionRabbit.createChannel();
        channel.basicPublish("Topic-Exchange", "tv.mobile.ac", null, msg.getBytes());
        ConnectionRabbit.closeConnections(channel);

    }
}
