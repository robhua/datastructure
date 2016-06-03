package com.demo.thread1.producer;

import com.demo.thread1.store.BaseStore;

public class DefaultProducer extends BaseProducer<BaseStore<Integer>> implements
		Runnable {
	public DefaultProducer(BaseStore<Integer> store) {
		this.store = store;
	}

	@Override
	public void run() {
		product();
	}

	@Override
	protected void product() {
		int i = 0;
		while (true) {
			store.put(Integer.valueOf(i++));
		}
	}
}
