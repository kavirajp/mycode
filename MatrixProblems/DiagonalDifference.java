//$Id$
package com.learn.matrix;

import java.util.Scanner;

public class DiagonalDifference {
	
	
	public static void main(String[] args){
		
		int matrix_size;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter size of the square matrix");
		matrix_size = in.nextInt();
		int[][] square_matrix = new int[matrix_size][matrix_size];
		
		for(int i = 0; i < matrix_size; i++){
			for(int j = 0; j < matrix_size; j++){
				square_matrix[i][j] = in.nextInt();
			}
		}
		System.out.println("Result = " + getMatrixDiagonalDifference(square_matrix));
	}
	
	/**
	 * Difference between two diagonal sum of square matrix
	 * It has been solved using O(n)
	 * Example:
	 * 3 X 3 Square Matrix 
	 *  10 14 54
	 *  34 54 78
	 *  02 32 98
	 *  
	 *  primary diagonal elements 	[0][0] [1][1] [2][2] {i.e. row = column} [10 + 54 + 98 = 162]
	 *  Secondary diagonal elements [0][2] [1][1] [2][0] {i.e row = size_of_matrix - row - 1} [54+54+02 = 110]
	 *  
	 * @return | 162 - 110 | = 52
	 */
	private static int getMatrixDiagonalDifference(int[][] matrix){
		
		int primary_diagonal_matrix = 0;
		int secondary_diagonal_matrix = 0;
		for(int i = 0; i < matrix.length; i++){
			primary_diagonal_matrix+=matrix[i][i];
			secondary_diagonal_matrix+=matrix[i][matrix.length-i-1];
		}
		return Math.abs(primary_diagonal_matrix - secondary_diagonal_matrix); 
	}

}
