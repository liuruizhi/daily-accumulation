package com.rabbit.test.client;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.ConsumerCancelledException;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.ShutdownSignalException;

public class RPCClient {

	private ConnectionFactory connectionFactory = null;
	private String requestQueue = "rpc_queue";

	private Connection connection = null;
	private Channel channel = null;

	private String returnQueue = null;

	private QueueingConsumer queueingConsumer = null;

	public String call() throws IOException, ShutdownSignalException, ConsumerCancelledException, InterruptedException {
		String result = null;
		String corrId = UUID.randomUUID().toString();

		BasicProperties basicProperties = new BasicProperties.Builder()
				.correlationId(corrId).replyTo(returnQueue).build();
		
		channel.basicPublish("", requestQueue, basicProperties, null);
		
		while(true){
			QueueingConsumer.Delivery delivery = queueingConsumer.nextDelivery();
			if(delivery.getProperties().getCorrelationId().equals(corrId)){
				result = new String(delivery.getBody());
				break;
			}
		}

		return result;
	}

	public RPCClient() throws IOException, TimeoutException, ShutdownSignalException, ConsumerCancelledException, InterruptedException {

		connectionFactory = new ConnectionFactory();
		connectionFactory.setHost("localhost");

		connection = connectionFactory.newConnection();
		channel = connection.createChannel();

		returnQueue = channel.queueDeclare().getQueue();

		queueingConsumer = new QueueingConsumer(channel);
		channel.basicConsume(returnQueue, true, queueingConsumer);

		// connection.close();
	}
	
	public void close() throws IOException{
		connection.close();
	}
	
	public static void main(String[] args) throws ShutdownSignalException, ConsumerCancelledException, IOException, TimeoutException, InterruptedException {
		RPCClient rpcClient = new RPCClient();
		String result = rpcClient.call();
		System.out.println(result);
		
		rpcClient.close();
	}
}
