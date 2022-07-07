package com.Gold5;

import java.io.*;
import java.util.*;

public class Quiz2293 {

	public static void main(String[] args) throws Exception{
		// 동전1
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int coinTypeCnt = Integer.parseInt(st.nextToken());
		int goal = Integer.parseInt(st.nextToken());
		
		int[] coins = new int[coinTypeCnt];
		
		for(int i=0;i<coinTypeCnt;i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		
		int[] dp = new int[goal+1];
		dp[0] = 1;

		
		for(int i=0;i<coinTypeCnt;i++) {
			for(int j=coins[i];j<=goal;j++) {
				dp[j] = dp[j]+dp[j-coins[i]];
			}
		}
		
		System.out.println(dp[goal]);
		
		br.close();

	}

}
