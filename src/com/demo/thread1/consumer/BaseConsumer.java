package com.demo.thread1.consumer;

public abstract class BaseConsumer<T>{
	protected T store;
	
	protected abstract void consume();
}
