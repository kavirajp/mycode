//$Id$
package com.learn;

import java.util.Scanner;

public class MergeSort {
	
	private static long inversioncount =0;

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
		sort(arr, 0, n-1);
		System.out.println("Sorted array : ");
		for(int i =0; i < n; i++){
			System.out.print(arr[i]+" ");
		}
		
		System.out.println("Number of inversion is " + inversioncount);

	}
	
	private static void sort(int[] arr, int l, int r){
		if(l<r){
			int k = ((l+r)/2);
			
			sort(arr, l, k);
			sort(arr, k+1, r);
			
			merge(arr, l, r, k);
		}
	}
	
	private static void merge(int[] arr, int l, int r, int m){
		
		int n1 = (m-l+1);
		int n2 = (r-m);
		
		int left_array[] = new int[n1];
		int right_arry[] = new int[n2];
		
		for(int i = 0; i<n1; i++){
			left_array[i]=arr[l+i];
		}
		
		for(int i = 0; i<n2; i++){
			right_arry[i]=arr[m+1+i];
		}
		
		int i = 0;int j =0; int k = l;
		
		while(i < n1 && j < n2){
			if(left_array[i]<=right_arry[j]){
				arr[k]=left_array[i];
				i++;
			}else{
				arr[k]=right_arry[j];
				j++;
				inversioncount+=(long)((m+1)-(l+i));
			}
			k++;
		}
		
		while(i < n1){
			arr[k] = left_array[i];
			i++;k++;
		}
		
		while(j < n2){
			arr[k] = right_arry[j];
			j++;k++;
		}
		return;
	}

}
