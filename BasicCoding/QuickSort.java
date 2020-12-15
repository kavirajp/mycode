//$Id$
package com.learn;

import java.util.Scanner;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n;
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter size of an array");
		n = in.nextInt();
		int arr[] = new int[n];
		System.out.println("Enter array elements");
		for(int i =0; i < n; i++){
			arr[i] = in.nextInt();
		}
		quicksort(arr, 0, n-1);
		System.out.println("Result array is");
		for(int i =0; i < n; i++){
			System.out.print(arr[i] + " ");
		}
		

	}
	
	private static void quicksort(int[] arr, int l, int h){
		
		if(l<h){
			int pivot = partition(arr, l, h);
			quicksort(arr, l, pivot-1);
			quicksort(arr, pivot+1, h);
		}
		return;
	}
	
	private static int partition(int[] arr, int l, int h){
		int pivot = arr[h];
		int i = (l-1);
		for(int j = l; j < h; j++){
			if(arr[j] < pivot){
				i++;
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
		int temp = arr[h];
		arr[h]=arr[i+1];
		arr[i+1]=temp;
		return i+1;
	}

}
