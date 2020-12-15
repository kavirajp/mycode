//$Id$
package com.learn;

import java.util.Scanner;

public class FindMedianQuickAlgorithm {

	private static int a;
	private static int b;
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
		float m=findMedian(arr);
		System.out.println("Median is " + m);
	}
	
	private static void findQuickMedian(int[] arr, int l, int h, int k){
		if(l <= h){
			int p = partition(arr, l, h);
			
			if(p == k){
				b = arr[p];
			}else if(p == (k-1)){
				a = arr[p];
			}
			
			if(p >= k){
				findQuickMedian(arr, l, p-1, k);
			}else{
				findQuickMedian(arr, p+1, h, k);
			}
		}
	}
	
	private static float findMedian(int[] arr){
		
		a=-1;
		b=-1;
		
		int n = arr.length;
		if((n % 2) == 1){
			findQuickMedian(arr, 0, n-1, n/2);
			return (float)b;
		}else{
			findQuickMedian(arr, 0, n-1, n/2);
			return (float)((a+b)/2.0);
		}
		
	}
	
	private static int partition(int[] arr, int l , int h){
		int pivot = arr[h];
		int i = (l-1);
		
		for(int j = l; j < h; j++){
			if(arr[j] < pivot){
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int temp = arr[h];
		arr[h] = arr[i+1];
		arr[i+1] = temp;
		return (i+1);
	}

}
