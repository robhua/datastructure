package com.demo.thread1.producer;

public abstract class BaseProducer<T>{
	protected T store;
	
	protected abstract void product();
}
