package com.operatingsystem.synchronize;

import static com.demo.utils.FileUtils.appendToFile;
import static com.demo.utils.FileUtils.getLineBeforeEndOfFile;

import java.io.File;
import java.io.IOException;

import com.demo.datastructure.MyQueue;
import com.demo.datastructure.MyStack;
import com.demo.utils.StringUtils;

/**
 * Singleton pattern
 *
 */
public class CubbyHole {
	// store
	/**
	 * - a variable
	 * - a queue
	 * - a stack
	 * - a file
	 * - a database
	 * - a array
	 * - a linked list
	 * - a tree
	 * - a map
	 */
	private Number number = -1;
	private File file;
	private MyStack myStack = new MyStack();
	private MyQueue myQueue = new MyQueue();
	
	// flag
	int turn = 1;
	boolean providerFlag = true;
	boolean customerFlag = true;
	private byte storeType = 0;

	private static CubbyHole cubbyHole;
	
	private CubbyHole() {
		file = new File("storeFile.dat");
		if (file.exists()) {
			file.delete();
			file = new File("storeFile.dat");
		}
	}
	
	public static CubbyHole getInstance(){
		if (cubbyHole != null)
			return cubbyHole;
		
		synchronized (CubbyHole.class) {
			if (cubbyHole == null)
				cubbyHole = new CubbyHole();
			
			return cubbyHole;
		}
	}
	
	/**
	 * This method get data from cache
	 * 
	 * @return
	 */
	public Number getData() {
		Number value = -1;
		try {
			switch (storeType) {
			case 1:// using a stack
				if (myStack.isEmpty() == false)
					value = myStack.pop();
				break;
			case 2:// using a queue
//				myQueue.pop();
//				
//				Number valueTemp = queue.poll();
//				value = (valueTemp == null) ? -1 : valueTemp;
				break;
			case 3:// using file
				String str = getLineBeforeEndOfFile(file);
				if (StringUtils.isNotBlank(str) && StringUtils.stringsAreEqual(str, String.valueOf(number)) == false) {
					number = (str.indexOf('.') != -1) ? new Float(str) : new Integer(str);
				}
				value = number;
				break;
			default:// using a variable
				value = number;
				break;
			}
		} catch (IOException e) {
			System.out.println(e);
		}
		return value;
	}

	/**
	 * This method put data to cache
	 * 
	 * @param value
	 */
	public void putData(Number value) {
		try {
			switch (storeType) {
			case 1:// using a stack
				if (myStack.isFull() == false)
					myStack.push(value.intValue());
				else 
					System.out.println("Stack is full");
				break;
			case 2:// using a queue
//				queue.offer(value);ss
				break;
			case 3:// using file
				appendToFile(value, file);
				break;
			default:// using a variable
				number = value;
				break;
			}
		} catch (IOException e){
			System.out.println(e);
		}
	}
	
	public byte getStoreType() {
		return storeType;
	}

	public void setStoreType(byte storeType) {
		this.storeType = storeType;
	}
}
