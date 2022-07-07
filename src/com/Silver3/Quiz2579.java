package com.Silver3;

import java.io.*;
import java.util.*;

public class Quiz2579 {
	
	public static void main(String[] args) throws Exception{
		// 계단 오르기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] dp = new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		dp[0] = arr[0];
//		dp[1] = arr[0]+arr[1];
//		dp[2] = Math.max(arr[0]+arr[2], arr[1]+arr[2]);
		
		for(int i=1;i<N;i++) {
			if(i == 1) {
				dp[1] = arr[0]+arr[1];
			}
			else if(i==2) {
				dp[2] = Math.max(arr[0]+arr[2], arr[1]+arr[2]);
			}
			else {
				//dp[i] = Math.max(dp[i-2], dp[i-1])+arr[i];
				//dp[i] = Math.max(dp[i-3], dp[i-2])+arr[i];
				dp[i] = Math.max(dp[i-3]+arr[i-1], dp[i-2])+arr[i];
			}
		}
		
		//System.out.println(Arrays.toString(arr));
		//System.out.println(Arrays.toString(dp));
		
		System.out.println(dp[N-1]);
		
		br.close();
	}


}
