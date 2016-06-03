package com.demo.thread2;

import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Consumer implements Runnable {
	private static Logger logger = Logger.getLogger(Consumer.class.getName());
	
	private Vector<Object> sharedQueue;
	private Store store;

	public Consumer(Store store) {
		this.store = store;
	}

	@Override
	public void run() {
		while (true) {
			try {
				System.out.println("Consumed: " + consume());
				Thread.sleep(50);
			} catch (InterruptedException ex) {
				logger.log(Level.SEVERE, null, ex);
			}
		}
	}

	private int consume() throws InterruptedException {
		// wait if queue is empty
		while (store.isEmpty()) {
			synchronized (sharedQueue) {
				System.out.format("Queue is empty %s is waiting , size: %d", Thread.currentThread().getName(), sharedQueue.size());
//				System.out.println("Queue is empty "
//						+ Thread.currentThread().getName()
//						+ " is waiting , size: " + sharedQueue.size());
				sharedQueue.wait();
			}
		}

		// Otherwise consume element and notify waiting producer
		synchronized (sharedQueue) {
			sharedQueue.notify();
			// sharedQueue.notifyAll();
			return (Integer) sharedQueue.remove(0);
		}
	}
}