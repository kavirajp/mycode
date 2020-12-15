//$Id$
package com.learn;

import java.io.*;
import java.util.*;

public class Solution {

    private static int a;
    private static int b;
    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
        
        int notify = 0;
        int n = expenditure.length;
        for(int i = d; i<n; i++){
            float median = findMedian(Arrays.copyOfRange(expenditure, (i-d), i));
            if(expenditure[i] >= (2*median)){
                notify++;
            }
        }
        return notify;
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
			return (float) ((a+b)/2.0);
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

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {


        int n = scanner.nextInt();

        int d = scanner.nextInt();
        
        int[] expenditure = new int[n];


        for (int i = 0; i < n; i++) {
           expenditure[i] = scanner.nextInt();
        }

        int result = activityNotifications(expenditure, d);

        System.out.println("Result - "+result);

        scanner.close();
    }
}
