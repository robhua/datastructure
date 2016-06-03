package com.ir.languagesearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.demo.utils.StringUtils;


public class EditDistance {
	public static void main(String[] args) {
		String t = "fast";
		String s = "cats";
		int[][] distance = levenshteinDistance(s, t);
		printMatrix(distance);

		System.out.println();
		s = "sitting";
		t = "kitten";
		distance = levenshteinDistance(s, t);
		printMatrix(distance);
		
		s = "saturday";
		t = "sunday";
		
		t = "fast";
		s = "cats";
		System.out.println(computingLevenshteinDistance(s, t));
	}
	
	/**
	 * The method prints a matrix
	 */
	private static void printMatrix(int[][] distance) {
		int rowLen = distance.length;
		int col = distance[0].length;
		for (int i = 0; i < rowLen; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(distance[i][j]);
				
				if (j != col-1) {
					System.out.print(", ");
				}
			}
			System.out.print("\n");
		}
	}
	
	public final static int computingLevenshteinDistance(String s, String t) {
		int cost;

		/* base case: empty strings */
		if (StringUtils.isBlank(s))
			return StringUtils.length(t);
		if (StringUtils.isBlank(t))
			return StringUtils.length(s);

		int len_s = s.length();
		int len_t = t.length();
	  
		/* test if last characters of the strings match */
		if (s.charAt(len_s - 1) == t.charAt(len_t - 1)) {
			cost = 0;
		} else {
			cost = 1;
		}

		/* return minimum of delete char from s, delete char from t, and delete char from both */
		return minimum(computingLevenshteinDistance(s.substring(0, len_s-1), t) + 1,
			  		   computingLevenshteinDistance(s, t.substring(0, len_t - 1))  + 1,
			  		   computingLevenshteinDistance(s.substring(0, len_s-1), t.substring(0, len_t - 1)) + cost);
	}

	/**
	 * Iterative with full matrix
	 * 
	 * @param s
	 *            The source word
	 * @param t
	 *            The target word
	 * @return The Levenshtein distance matrix between source and target word
	 */
	public final static int[][] levenshteinDistance(String s, String t) {
		// for all i and j, matrix[i][j] will hold the Levenshtein distance between
		// the first i characters of s and the first j characters of t
		// node that matrix has (len_s + 1)*(leng_t + 1) values
		
		int len_s = s.length(); // The number of characters in string s
		int len_t = t.length(); // The number of characters in string t

		int i, j;
		int[][] matrix = new int[len_s + 1][len_t + 1];
		
		// Set each element in matrix to zero
		for (i = 0; i < len_s + 1; i++) {
			matrix[i][0] = i;
		}
		for (j = 0; j < len_t + 1; j++) {
			matrix[0][j] = j;
		}

		int substitutionCost;
		for (i = 0; i < len_s; i++) {
			for (j = 0; j < len_t; j++) {
				if (s.charAt(i) == t.charAt(j)) {
					substitutionCost = 0;
				} else {
					substitutionCost = 1;
				}
				
				matrix[i+1][j+1] = minimum(matrix[i][j+1] + 1, 				// deletion
										   matrix[i+1][j] + 1,				// insertion
									       matrix[i][j] + substitutionCost);// substitution or replace
			}
		}
		return matrix;
	}

	/**
	 * Find smallest of 3 numbers
	 */
	private static int minimum(int i, int j, int k) {
		return Math.min(Math.min(i, j), k);
	}
	
	/**
	 * 
	 * @param word
	 * @return
	 */
	public final static List<String> permutation(String word) {
		ArrayList<String> result = new ArrayList<String>();
		// TODO computing all permutations of a word
		return result;
	}
	
	/**
	 * Arranging the all members of a set into some sequence or order
	 * 
	 * @param sets
	 *            The all members of a set
	 * @return All permutations of a set
	 */
	public final static <T> List<List<T>> computingPermutations(Set<T> sets) {
		List<List<T>> allPermutations = new ArrayList<>();
		// TODO computing all permutations of a set
		
		return allPermutations;
	}
}
