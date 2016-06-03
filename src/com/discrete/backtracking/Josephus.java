package com.discrete.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Josephus {
	public static void main(String[] args) {
		//1. Init person
		List<Integer> intList = new ArrayList<Integer>();
		for (int i = 1; i < 11; i++) {
			intList.add(i);
		}
		
		//2. Choose n, m, k 
		int n = intList.size();
		int m = 5;
		int k = 1;
		
		int i;
		while (intList.size() != 1) {
			i = (m+k)%n;
			
			if (i == 0 || i == n-1) {
				intList.remove(i);
			}
			else {
				List<Integer> subList = new ArrayList<Integer>(intList.subList(0, i));
				List<Integer> _subList = new ArrayList<Integer>(intList.subList(i+1, n));
				
				intList.clear();
				intList.addAll(_subList);
				intList.addAll(subList);
			}
			n = intList.size(); 
		}
		System.out.println(intList);
	}
	
}
