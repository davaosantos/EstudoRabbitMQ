package com.udemy.queuepublisher.domain;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.BasicProperties;
import com.rabbitmq.client.Channel;
import com.udemy.queuepublisher.utils.ConnectionRabbit;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeoutException;

public class HeadersPublisher {
    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = ConnectionRabbit.createChannel();

        String msg = "Message for Mobile and TV";

        Map<String, Object> headersMap = new HashMap<>();
        headersMap.put("item1", "mobile");
        headersMap.put("item2", "television");

        AMQP.BasicProperties bp = new AMQP.BasicProperties();
        bp = bp.builder().headers(headersMap).build();

        channel.basicPublish("Headers-Exchange", "", bp, msg.getBytes());

        ConnectionRabbit.closeConnections(channel);
    }
}
