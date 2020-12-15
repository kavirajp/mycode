//$Id$
package com.learn;

import java.util.Scanner;

public class FindMedianUsingCountSort {
	
	public static void main(String[] args){
		int n;
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter size of an array");
		n = in.nextInt();
		int arr[] = new int[n];
		System.out.println("Enter array elements");
		for(int i =0; i < n; i++){
			arr[i] = in.nextInt();
		}
		float median = findMedian(arr);
		System.out.println("Result - "+median);
	}
	
	private static float findMedian(int[] arr){
		int[] sortedarray = getFrequenceArray(arr);
		int n = arr.length;
		if((n%2)==1){
			return (float) sortedarray[n/2];
		}else{
			return (float) ((sortedarray[((n-1)/2)] + sortedarray[n/2])/2.0);
		}
	}
	
	private static int[] getFrequenceArray(int[] arr){
		int count[] = new int[200];
		for(int i = 0; i< count.length; i++){
			count[i]=0;
		}
		for(int i =0; i < arr.length; i++){
			count[arr[i]]++;
		}
		
		return count;
	}

}
