package com.demo.thread3;

public class ConsumerProducerTest {
	public static void main(String args[]) {
		Producer producer = new Producer();
		producer.start();
		new Consumer(producer).start();
	}
}
