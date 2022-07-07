package com.Silver1;

import java.io.*;
import java.util.*;

public class Quiz15486 {

	public static void main(String[] args) throws Exception{
		// 퇴사2
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		//+2
		int[] days = new int[N+2];
		int[] profits = new int[N+2];
		
		int[] dp = new int[N+2];
		
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			days[i] = Integer.parseInt(st.nextToken());
			profits[i] = Integer.parseInt(st.nextToken());
		}
		
//		for(int i=1;i<=N;i++) {
//			if(i+days[i] <= N) {
//				dp[i+days[i]] = Math.max(dp[i]+profits[i], dp[i+days[i]]);
//			}
//		}
		
		int max = Integer.MIN_VALUE;
		
		for(int i=1;i<=N+1;i++) {
			max = Math.max(max, dp[i]);
			if(i+days[i] <= N+1) {
				dp[i+days[i]] = Math.max(max+profits[i], dp[i+days[i]]);
			}
		}
		
		//System.out.println(Arrays.toString(dp));
		//System.out.println(dp[N]);
		System.out.println(max);
		
		br.close();
	}

}
