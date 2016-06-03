package com.demo.thread1.store;

//An incorrect implementation of a producer and consumer.
public class DefaultStore extends BaseStore<Integer> {
	private Integer number;

	@Override
	public synchronized Integer get() {
		System.out.format("Got {%d}\n", number);
		return number;
	}

	@Override
	public synchronized void put(Integer number) {
		this.number = number;
		System.out.format("Put {%d}\n", number);
	}
}
