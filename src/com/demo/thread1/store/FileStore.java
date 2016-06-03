package com.demo.thread1.store;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public final class FileStore extends BaseStore<Integer> {
	private Integer integer;

	private Scanner inputScanner;
	private  BufferedWriter bw; 

	private File inputFile;
	private File outputFile;
	
	private String INPUT_FILE = "C://data//inputFile.txt";
	private String OUTPUT_FILE = "C://data//inputFile.txt";
	
	private boolean isAppend;

	public FileStore() {
		inputFile = new File(INPUT_FILE);
		outputFile = new File(OUTPUT_FILE);
		
		if (!inputFile.exists()){
			try {
				if (inputFile.createNewFile()){
					System.out.format("Create file at %s", INPUT_FILE);
				}
			} catch (IOException e) {
				System.out.format("IOException create file at %s", e.getMessage());
			}
		}
		
		if (!outputFile.exists()){
			try {
				if (outputFile.createNewFile()){
					System.out.format("Create file at %s", OUTPUT_FILE);
				}
			} catch (IOException e) {
				System.out.format("IOException create file at %s", e.getMessage());
			}
		}
	}

	public FileStore(File inputFile, File outputFile) {
		this.inputFile = inputFile;
		this.outputFile = outputFile;
	}

	public FileStore(String inputFile, String outputFile) {
		this.inputFile = new File(inputFile);
		this.outputFile = new File(outputFile);
	}

	@Override
	public synchronized Integer get() {
		try {
			inputScanner = new Scanner(inputFile);
			while (inputScanner.hasNext()) {
				integer = inputScanner.nextInt();
			}
		} catch (FileNotFoundException e) {
			System.out.format("FileNotFoundException %s\n", e.getMessage());
		}
		return integer;
	}

	@Override
	public synchronized void put(Integer ojb) {
		try {
			// if file does not exists, then create it
			if (!outputFile.exists()) {
				outputFile.createNewFile();
			}
			FileWriter fw = new FileWriter(outputFile.getAbsoluteFile(),
					isAppend);
			bw = new BufferedWriter(fw);
			bw.write(ojb);

		} catch (IOException e) {
			System.out.format("IOException %s\n", e.getMessage());
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					System.out.format("IOException %s\n", e.getMessage());
				}
			}
		}
	}
}
