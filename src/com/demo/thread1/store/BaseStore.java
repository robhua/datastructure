package com.demo.thread1.store;

public abstract class BaseStore<T> {
	public abstract T get();

	public abstract void put(T ojb);
}
