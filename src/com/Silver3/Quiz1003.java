package com.Silver3;

import java.io.*;
import java.util.*;

public class Quiz1003 {

	static Integer[][] dp = new Integer[41][2];
	
	public static void main(String[] args) throws Exception{
		// 피보나치 함수-dp
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		
		while(T-->0) {
			
			int N = Integer.parseInt(br.readLine());
			fibonacci(N);
			sb.append(dp[N][0] + " " + dp[N][1]).append('\n');
			
		}
						
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();

	}

	private static Integer[] fibonacci(int n) {
	
		if(dp[n][0] == null || dp[n][1] == null) {
			
			dp[n][0] = fibonacci(n-1)[0] + fibonacci(n-2)[0];
			dp[n][0] = fibonacci(n-1)[1] + fibonacci(n-2)[1];
		}
		
		return dp[n];
		
	}

}
