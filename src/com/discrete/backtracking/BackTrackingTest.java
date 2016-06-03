package com.discrete.backtracking;

import java.io.File;

public class BackTrackingTest {
	private static String inputFile = "INT.dat";
	private static String outputFile = "OUT.dat";

	public static void main(String[] args) {
		//InputData inputData = InputData.createInputData(new File(inputFile));
		OutputData outputData = new OutputData();
		
		int count = 2;
		int sum = 2;
		int[] arr ={1, 1};
		int[] values ={0, 1};
		InputData inputData = new InputData(count, sum, arr, values);
		
		BackTracking backTracking = new BackTracking(inputData, outputData);
		System.out.println("Start processing back tracking ...");
		long startTime = System.currentTimeMillis();
		if (backTracking.processBackTracking()) {
			outputData.writeOutputData(new File(outputFile));
		}		
		long endTime = System.currentTimeMillis();
		System.out.println("Processing back tracking finished. Time toal: " + (endTime - startTime));
		
		System.out.println(outputData);
	}
}
