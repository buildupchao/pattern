package com.pattern.tutor.syntax.collection.mq;

import java.util.concurrent.ArrayBlockingQueue;

import com.pattern.tutor.syntax.collection.entity.Message;

public class MessageSimulator {
	
	private static ArrayBlockingQueue<Message> messageQueue = new ArrayBlockingQueue<>(100);
	
	public static void main(String[] args) {
		WindowSimulator generator = new WindowSimulator(messageQueue);
		
		generator.generateMessage();
		
		Message msg = null;
		while ((msg = messageQueue.poll()) != null) {
			((MessageProcess) msg.getSource()).doMessage(msg);
		}
	}
}
