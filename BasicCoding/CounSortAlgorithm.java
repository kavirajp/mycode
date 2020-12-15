//$Id$
package com.learn;

import java.util.Scanner;

public class CounSortAlgorithm {

	public static void main(String[] args) {
		
		int n;
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter size of an array");
		n = in.nextInt();
		int arr[] = new int[n];
		System.out.println("Enter array elements");
		for(int i =0; i < n; i++){
			arr[i] = in.nextInt();
		}
		int[] sortedarray=countsort(arr, 100);
		System.out.println("Result is");
		for(int i =0; i < n; i++){
			System.out.print(sortedarray[i]+" ");
		}
		

	}
	
	private static int[] countsort(int[] arr, int max){
		int count_arr[] = new int[max];
		for(int i = 0; i< count_arr.length; i++){
			count_arr[i]=0;
		}
		
		for(int i = 0; i<arr.length; i++){
			count_arr[arr[i]]++;
		}
		for(int i = 0; i < count_arr.length; i++){
			if((i-1) >=0){
				count_arr[i]+=count_arr[i-1];
			}
		}
		int sortedarray[] = new int[arr.length];
		for(int i = 0; i < arr.length; i++){
			int v = arr[i];
			int position = count_arr[v];
			sortedarray[position-1]=arr[i];
			count_arr[v]--;
		}
		return sortedarray;
		
	}

}
