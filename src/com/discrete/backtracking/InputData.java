package com.discrete.backtracking;

import java.io.File;

public class InputData {
	private int numCount;
	private int sum;
	private int[] array;
	private int[] values;

	public InputData(int numCount, int sum, int[] array, int[] values) {
		this.numCount = numCount;
		this.sum = sum;
		this.array = array;
		this.values = values;
	}

	public static InputData createInputData(File file) {
		InputData inputData = null;
		return inputData;
	}

	public int getNumCount() {
		return numCount;
	}

	public void setNumCount(int numCount) {
		this.numCount = numCount;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public int[] getArray() {
		return array;
	}

	public void setArray(int[] array) {
		this.array = array;
	}
	
	public int[] getValues() {
		return values;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(numCount + "\n");
		sb.append(sum + "\n");
		
		int len = array.length;
		sb.append("(");
		for (int i = 0; i < len; i++) 
		{
			sb.append(array[i]);
			if (i != len-1)
				sb.append(", ");
		}
		sb.append(")");
		return sb.toString();
	}
}
