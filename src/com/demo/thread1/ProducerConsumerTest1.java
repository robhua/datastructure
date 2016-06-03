package com.demo.thread1;

import com.demo.thread1.consumer.DefaultConsumer;
import com.demo.thread1.producer.DefaultProducer;
import com.demo.thread1.store.BaseStore;
import com.demo.thread1.store.DefaultStore;
import com.demo.thread1.store.FileStore;

public class ProducerConsumerTest1 {
	public static void main(String args[]) {
		BaseStore<Integer> q = new DefaultStore();
		FileStore fileStore = new FileStore();
		
//		DefaultProducer producer = new DefaultProducer(q);
//		DefaultConsumer consumer = new DefaultConsumer(q);
		
		DefaultProducer producer = new DefaultProducer(fileStore);
		DefaultConsumer consumer = new DefaultConsumer(fileStore);
		
		new Thread(producer, "Producer").start();
		new Thread(consumer, "Consumer").start();
		System.out.printf("Press Control-C to stop \n.");
	}
}