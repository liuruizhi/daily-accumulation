package com.rabbit.test.server;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class NewTask {
	
	private static final String QUEUE_NAME = "queue";
	
	public static String getMessage(){
		return "";
	}
	
	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		connectionFactory.setHost("localhost");
		
		Connection connection = connectionFactory.newConnection();
		
		//获取channel,Channel用来收发信息
		Channel channel = connection.createChannel();
		
		channel.queueDeclare(QUEUE_NAME, true, false, false, null);
		
		String message = getMessage();
		
		channel.basicPublish(arg0, arg1, arg2, arg3, arg4, arg5);
		
	}
}
