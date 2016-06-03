package com.demo.thread3;

public class Consumer extends Thread {

	Producer producer;

	Consumer(Producer p) {
		producer = p;
	}

	@Override
	public void run() {
		try {
			while (true) {
				String message = producer.getMessage();
				System.out.format("Got message: %s", message);
				// sleep(200);
			}
		} catch (InterruptedException e) {
			System.out.format("InterruptedException message: %s",
					e.getMessage());
		}
	}
}