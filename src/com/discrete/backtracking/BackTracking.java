package com.discrete.backtracking;

public class BackTracking {
	private int n;
	private InputData inputData;
	private OutputData outputData;

	public BackTracking(){
		
	}
	
	public BackTracking(InputData inputData, OutputData outputData) {
		this.inputData = inputData;
		this.outputData = outputData;
	}

	public boolean processBackTracking() {
		boolean bool = false;
		return bool;
	}
	
	private void backtracking() {
		inputData.getValues();
	}
	
	public static void main(String[] args) {
		new BackTracking().Try(0);
	}
	
	void Try(int i){
		int[] arrNumber = getNumber(i);
		for (int j = 0; j < arrNumber.length; j++) 
		{
			if (accept(arrNumber[j]))
			{
				identify(j);
				
				if (i == n){
					saveConfiguration();
				}else {
					Try(i+1);
				}
			}
				
		}
	}
	/*
	 * procedure Generate;
	 * Begin
	 * 	<Xay dung cua hinh ban dau>;
	 * 	Stop := false;
	 * 	while not stop do
	 * 		begin
	 * 			<Dua ra cau hinh dang co>;
	 * 			Sin_Ke_Tiep;
	 * 		end;
	 * End.
	 * procedure Try(i : integer);
	 * var j : integer;
	 * begin
	 * 		for j := 1 to n(j) do
	 * 		if <chap nhap j> then
	 * 		begin
	 * 			<xac nhan x(i) theo j>
	 * 			if i = n then <ghi nhan mot cau hinh>
	 * 			else Try(y+1);
	 * 		end;
	 * end; 
	 */

	/**
	 * Save a configuration 
	 */
	private void saveConfiguration() {
		
	}

	/**
	 * @param j
	 */
	private void identify(int i) {
		
	}

	/**
	 * Chap nhap phan tu thu j
	 * 
	 * This method returns true if parameter i accepted.
	 * @return
	 */
	private boolean accept(int i) {
		return false;
	}

	/**
	 * 
	 * get the values of variable i
	 */
	private int[] getNumber(int i) {
		return new int[] {0, 1};
	}
}
