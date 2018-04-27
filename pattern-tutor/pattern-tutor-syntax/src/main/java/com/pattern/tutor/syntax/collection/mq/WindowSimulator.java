package com.pattern.tutor.syntax.collection.mq;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

import com.pattern.tutor.syntax.collection.entity.Message;

public class WindowSimulator implements MessageProcess {

	private ArrayBlockingQueue<Message> messageQueue;

	public WindowSimulator(ArrayBlockingQueue<Message> messageQueue) {
		super();
		this.messageQueue = messageQueue;
	}
	
	public void generateMessage() {
		while (true) {
			System.out.println("Please entry number/>");
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			int msgType = scanner.nextInt();
			if (msgType < 0) {
				break;
			}
			String msgInfo = scanner.next();
			Message message = new Message(this, msgType, msgInfo);
			try {
				messageQueue.put(message);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void doMessage(Message msg) {
		switch (msg.getType()) {
		case Message.KEY_MSG:
			onKeyDown(msg);
			break;
		case Message.MOUSE_MSG:
			onMouseDown(msg);
			break;
		case Message.SYS_MSG:
			onSysEvent(msg);
			break;
		default:
			onSysEvent(msg);
		}
	}

	static void onKeyDown(Message msg) {
		println(msg, "keyboard event");
	}
	
	static void onMouseDown(Message msg) {
		println(msg, "mouse event");
	}
	
	static void onSysEvent(Message msg) {
		println(msg, "system event");
	}
	
	static void println(Message msg, String messageType) {
		System.out.printf("%s[type={%s}, info={%s}]\n", messageType, msg.getType(), msg.getInfo());
	}
}
