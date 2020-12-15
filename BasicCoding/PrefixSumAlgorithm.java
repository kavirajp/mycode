//$Id$
package com.learn;

import java.util.Scanner;

public class PrefixSumAlgorithm {
	
	public static void main(String[] args){
		
		int n;
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		int arr[] = new int[n];
		for(int i = 0; i < n; i ++){
			arr[i] = in.nextInt();
		}
		
		//prefix sum algrith;
		
		for(int i = 0; i < n; i++){
			if((i-1) >= 0){
				arr[i]+=arr[i-1];
			}
		}
		
		System.out.println("Output");
		for(int i = 0; i < n; i++){
			System.out.println(arr[i]);
		}
	}

}
