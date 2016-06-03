package com.demo.acid.entity;

public class ThreadB extends Thread {
	private WrapperInt value;
	
	public ThreadB() {
		value = new WrapperInt(3000);
	}
	
	public int getValue() {
		return value.getValue();
	}
	public void setValue(int value) throws ExceptionB{
		int delta = value - this.value.getValue();
		this.value.setValue(value);
		
		if (delta > 500)
			throw new ExceptionB();
		
	}
	
	public void resetValue(int value) {
		this.value.setValue(value);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
	}
}
