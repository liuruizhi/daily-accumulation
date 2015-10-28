package com.rabbit.test.client;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Send {
	private static final String QUEUE_NAME = "hello";
	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		
		//Channel用来发送或接收信息
		Channel channel = connection.createChannel();
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		String message = "hello world";
		channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
		System.out.println("queue message " + message);
		channel.close();
		connection.close();
	}
}