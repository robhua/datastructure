package com.demo.datastructure;

public class MyQueue {
	private static final int capacity = 3;
	private int arr[] = new int[capacity];
	private int top = -1;
	private int rear = 0;

	public void push(int pushedElement) {
		if (top < capacity - 1) {
			arr[top++] = pushedElement;
			System.out.println("Element " + pushedElement + " is pushed to Queue !");
			display();
		} else {
			System.out.println("Overflow !");
		}

	}

	public void pop() {
		if (top >= rear) {
			rear++;
			System.out.println("Pop operation done !");
			display();
		} else {
			System.out.println("Underflow !");
		}
	}

	public void display() {
		if (top >= rear) {
			System.out.println("Elements in Queue : ");
			for (int i = rear; i <= top; i++) {
				System.out.println(arr[i]);
			}
		}
	}
}
