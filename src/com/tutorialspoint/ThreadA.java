package com.tutorialspoint;

public class ThreadA {
	public static void main(String[] args) {
		Boolean flag = new Boolean(true);
		
		ThreadB b = new ThreadB(flag);
		b.start();

		//System.out.println("Waiting for b to complete...");
		//System.out.println("Total is: " + b.total);
		/*synchronized (b) {
			try {
				System.out.println("Waiting for b to complete...");
				b.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("Total is: " + b.total);
		}*/
		System.out.println("Waiting for b to complete...");
		synchronized (flag) {
			System.out.println("Total is: " + b.total);
		}
	}
}

class ThreadB extends Thread {
	Boolean flag;
	int total;

	public ThreadB(Boolean flag) {
		this.flag = flag;
	}
	
	@Override
	public void run() {
		synchronized (flag) {
			for (int i = 0; i < 100; i++) {
				total += i;
			}
			flag = false;
			//notify();
		}
	}
}