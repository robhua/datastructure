package com.demo.thread2;

import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Producer implements Runnable {
	private Logger logger = Logger.getLogger(Logger.class.getName());
	private Store store;
	
	public Producer(Store store) {
		this.store = store;
	}

	@Override
	public void run() {
		for (int i = 0; i < 7; i++) 
		{
			System.out.println("Produced: " + i);
			try {
				produce(i);
			} catch (InterruptedException ex) {
				logger.log(Level.SEVERE,null, ex);
			}

		}
	}

	
	/**
	 * @param i
	 */
	private void produce(int i) throws InterruptedException {

		// wait if queue is full
		Vector<Object> sharedQueue = store.getSharedQueue();
		
		while (store.checkSize()) {
			synchronized (sharedQueue) {
				System.out.format("Queue is full %f  is waiting , size: %d", Thread.currentThread().getName(), sharedQueue.size());
//				System.out.println("Queue is full "
//						+ Thread.currentThread().getName()
//						+ " is waiting , size: " + sharedQueue.size());
				sharedQueue.wait();
			}
		}

		// producing element and notify consumers
		synchronized (sharedQueue) 
		{
			store.add(i);
			//sharedQueue.notifyAll();
			store.getSharedQueue().notify();
			//sharedQueue.notify();
		}
	}
}
