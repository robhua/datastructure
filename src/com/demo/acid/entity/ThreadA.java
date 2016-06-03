package com.demo.acid.entity;

public class ThreadA extends Thread{
	private WrapperInt value;
	
	public ThreadA() {
		value = new WrapperInt(5000);
	}
	
	public int getValue() {
		return value.getValue();
	}
	public void setValue(int value) throws ExceptionA{
		int delta = value - this.value.getValue();
		this.value.setValue(value);
		
		if (delta < 0) 
			throw new ExceptionA();
		
	}
	
	public void resetValue(int value) {
		this.value.setValue(value);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
	}
}
