package com.demo.thread1.consumer;

import com.demo.thread1.store.BaseStore;

public class DefaultConsumer extends BaseConsumer<BaseStore<Integer>> implements
		Runnable {
	
	public DefaultConsumer(BaseStore<Integer> store) {
		this.store = store;
	}

	@Override
	public void run() {
		consume();
	}

	@Override
	protected void consume() {
		while (true) {
			store.get();
		}
	}
}
