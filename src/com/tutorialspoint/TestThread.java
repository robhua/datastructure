package com.tutorialspoint;

public class TestThread {
	public static void main(String[] args) {
		Chat m = new Chat();
		new Chient(m);
		new Server(m);
	}
}

class Chat {
	boolean flag = false;

	public synchronized void Question(String msg) {
		String name = Thread.currentThread().getName();
		if (flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(name + "\t" + msg);
		flag = true;
		notify();
	}

	public synchronized void Answer(String msg) {
		String name = Thread.currentThread().getName();
		if (!flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println(name + "\t" + msg);
		flag = false;
		notify();
	}
}

class Chient implements Runnable {
	Chat m;
	String[] s1 = { "Hi", "How are you ?", "I am also doing fine!" };

	public Chient(Chat m1) {
		this.m = m1;
		new Thread(this, "Question").start();
	}

	public void run() {
		for (int i = 0; i < s1.length; i++) {
			m.Question(s1[i]);
		}
	}
}

class Server implements Runnable {
	Chat m;
	String[] s2 = { "Hi", "I am good, what about you?", "Great!" };

	public Server(Chat m2) {
		this.m = m2;
		new Thread(this, "Answer").start();
	}

	public void run() {
		for (int i = 0; i < s2.length; i++) {
			m.Answer(s2[i]);
		}
	}
}
