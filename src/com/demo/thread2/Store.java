package com.demo.thread2;

import java.io.Serializable;
import java.util.Vector;

public class Store implements Serializable{
	private static final long serialVersionUID = -9157891295130216297L;
	
	private final Vector<Object> sharedQueue;
	private final int SIZE;

	private static Store instance;
	
	private Store(){
		this.sharedQueue = new Vector<Object>();
		this.SIZE = 10;
	}
	
	public synchronized static Store getInstance(){
		if (instance != null)
			return instance;
		instance = new Store();
		return instance;
	}
	
	public Vector<Object> getSharedQueue() {
		return sharedQueue;
	}
	
	public int getSIZE(){
		return SIZE;
	}
	
	public void add(Object object) {
		sharedQueue.add(object);
	}
	
	public boolean isEmpty(){
		return sharedQueue.isEmpty();
	}
	
	public boolean checkSize(){
		return SIZE == sharedQueue.size();
	}
}
