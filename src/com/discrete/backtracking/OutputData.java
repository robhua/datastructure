package com.discrete.backtracking;

import java.io.File;

public class OutputData {
	private int numCount;
	private int[][] array;

	public OutputData(){}
	
	public OutputData(int numCount, int[][] array) {
		this.numCount = numCount;
		this.array = array;
	}

	public boolean writeOutputData(File file) {
		boolean bool = false;
		return bool;
	}

	public int getNumCount() {
		return numCount;
	}

	public void setNumCount(int numCount) {
		this.numCount = numCount;
	}

	public int[][] getArray() {
		return array;
	}

	public void setArray(int[][] array) {
		this.array = array;
	}

	@Override
	public String toString() {
		int m = array.length;
		int n = array[0].length;
		
		StringBuilder sb = new StringBuilder();
		sb.append(numCount + "\n");
		for (int i = 0; i < m; i++) 
		{
			sb.append("(");
			for (int j = 0; j < n; j++) 
			{
				sb.append(array[i][j]);
				if (j != n-1)
					sb.append(", ");
			}
			sb.append(")");
			sb.append("\n");
		}
		
		return sb.toString();
	}
}
