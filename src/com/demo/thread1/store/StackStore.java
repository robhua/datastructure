package com.demo.thread1.store;

import java.util.Stack;

public class StackStore extends BaseStore<Integer> {
	private Stack<Integer> stack;
	private int SIZE = 10;
	
	StackStore(){
		stack = new Stack<Integer>();
	}
	
	@Override
	synchronized public Integer get() {
		while (stack.isEmpty());
		
		return stack.pop();
	}

	@Override
	synchronized public void put(Integer item) {
		while (stack.size() == SIZE);
		
		stack.push(item);
	}
}
