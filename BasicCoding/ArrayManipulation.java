//$Id$
package com.learn;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ArrayManipulation {

    // Complete the arrayManipulation function below.
	/**
	 * Performed in Brute force algorithm.
	 * @param n
	 * @param queries
	 * @return
	 */
    static long arrayManipulation(int n, int[][] queries) {
        
        int arr[] = new int[n+1];
        long max = 0;
        for(int i =0; i<=n; i++){
            arr[i]=0;
        }
        
        for(int i = 0; i < queries.length; i++){
            int a = queries[i][0];
            int b = queries[i][1];
            int k = queries[i][2];
            
            for(int j = a; j <= b; j++){
                arr[j]+=k;
                if(max < arr[j]){
                    max = arr[j];
                }
            }
        }
        return max;
    }
    
    static long arrayManipulation1(int n, int[][] queries) {
    	
    	int arr[] = new int[n+2];
    	long max = 0;
    	
    	for(int i = 0; i<n; i++){
    		arr[i] = 0;
    	}
    	
    	for(int i = 0; i < queries.length; i++){
    		int a = queries[i][0];
    		int b = queries[i][1];
    		int k = queries[i][2];
    		
    		arr[a]+=k;
    		arr[b+1]-=k;
    	}
    	
    	//Apply prefix sum algorith
    	
    	for(int i = 0; i < (n+2); i++){
    		if((i-1) >= 0){
    			arr[i]+=arr[i-1];
    		}
    		if(max < arr[i]){
    			max = arr[i];
    		}
    	}
    	return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation1(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
