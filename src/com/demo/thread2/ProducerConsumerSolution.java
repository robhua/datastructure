package com.demo.thread2;

import java.util.logging.Logger;

/**
 * Java program to solve Producer Consumer problem using wait and notify method
 * in Java. Producer Consumer is also a popular concurrency design pattern.
 * 
 * @author Javin Paul
 */
public class ProducerConsumerSolution {
	final Logger logger = Logger.getLogger((getClass().getName())); 
	
	public static void main(String args[]) {
//		Thread prodThread = new Thread(new Producer(sharedQueue, size), "Producer");
//		Thread consThread = new Thread(new Consumer(sharedQueue, size), "Consumer");
		Thread prodThread = new Thread(new Producer(Store.getInstance()), "Producer");
		Thread consThread = new Thread(new Consumer(Store.getInstance()), "Consumer");
		prodThread.start();
		consThread.start();
	}
	
	
}