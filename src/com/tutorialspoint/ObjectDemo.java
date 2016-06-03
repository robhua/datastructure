package com.tutorialspoint;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ObjectDemo extends Object {

	private List<Object> synchedList;

	public ObjectDemo() {
		// create a new synchronized list to be used
		synchedList = Collections.synchronizedList(new LinkedList<Object>());
	}

	// method used to remove an element from the list
	public String removeElement() throws InterruptedException {
		String threadName = Thread.currentThread().getName();
		
		synchronized (synchedList) {

			// while the list is empty, wait
			while (synchedList.isEmpty()) {
				System.out.println(threadName + "\tList is empty...");
				synchedList.wait();
				System.out.println(threadName + "\tWaiting...");
			}
			String element = (String) synchedList.remove(0);

			return element;
		}
	}

	// method to add an element in the list
	public void addElement(String element) {
		String threadName = Thread.currentThread().getName();
		
		System.out.println(threadName + "\tOpening...");
		synchronized (synchedList) {

			// add an element and notify all that an element exists
			synchedList.add(element);
			System.out.println(threadName + "\tNew Element:'" + element + "'");

			synchedList.notify();
			//synchedList.notifyAll();
			System.out.println(threadName + "\tnotifyAll called!");
		}
		System.out.println(threadName + "\tClosing...");
	}

	public static void main(String[] args) {
		final ObjectDemo demo = new ObjectDemo();

		Runnable runA = new Runnable() {

			public void run() {
				String threadName = Thread.currentThread().getName();
				try {
					String item = demo.removeElement();
					System.out.println(threadName + "\t" + item);
				} catch (InterruptedException ix) {
					System.out.println(threadName + "\tInterrupted Exception!");
				} catch (Exception x) {
					System.out.println(threadName + "\tException thrown.");
				}
			}
		};

		Runnable runB = new Runnable() {
			// run adds an element in the list and starts the loop
			public void run() {
				String threadName = Thread.currentThread().getName();
				demo.addElement(threadName + "\tHello!");
			}
		};

		try {
			Thread threadA1 = new Thread(runA, "A");
			threadA1.start();

			Thread.sleep(500);

			Thread threadA2 = new Thread(runA, "B");
			threadA2.start();

			Thread.sleep(500);

			Thread threadB = new Thread(runB, "C");
			threadB.start();

			Thread.sleep(1000);

			threadA1.interrupt();
			threadA2.interrupt();
		} catch (InterruptedException x) {
		}
	}
}