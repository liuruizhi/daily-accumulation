package com.rabbit.test.server;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.ConsumerCancelledException;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.ShutdownSignalException;

public class RabbitServer {
	
	private final static String RPC_QUEUE = "rpc_queue";
	
	public static String reply(){
		return "hello";
	}
	
	public static void main(String[] args) throws IOException, TimeoutException, ShutdownSignalException, ConsumerCancelledException, InterruptedException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		connectionFactory.setHost("localhost");
		
		Connection connection = connectionFactory.newConnection();
		Channel channel = connection.createChannel();
		
		channel.queueDeclare(RPC_QUEUE, false, false, false, null);
		channel.basicQos(1);
		
		QueueingConsumer queueingConsumer = new QueueingConsumer(channel);
		channel.basicConsume(RPC_QUEUE, false, queueingConsumer);
		
		System.out.println("awaiting request.");
		
		while (true) {
			QueueingConsumer.Delivery delivery = queueingConsumer.nextDelivery();
			BasicProperties basicProperties = delivery.getProperties();
			BasicProperties replayProperties = new BasicProperties.Builder().correlationId(basicProperties.getCorrelationId()).build();
			
			String message = new String(delivery.getBody());
			
			System.out.println("recive message " + message);
			
			System.out.println("ready to return.");
			
			String returnMessage = reply();
			
			channel.basicPublish("", basicProperties.getReplyTo(), replayProperties, returnMessage.getBytes());
			channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
		}
		
	}
}