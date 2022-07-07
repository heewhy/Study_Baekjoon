package com.Silver3;

import java.io.*;
import java.util.*;

public class Quiz1463 {

	public static void main(String[] args) throws Exception{
		// 1로 만들기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];

		dp[1] = 0; 
//		dp[2] = 1; 2
//		dp[3] = 1; 3
//		dp[4] = 2; 4 2 
//		dp[5] = 3; 5 4 2
//		dp[6] = 2; 6 2 
//		dp[7] = 3; 7 6 2 
//		dp[8] = 3; 8 4 2
//		dp[9] = 2; 9 3
//		dp[10] =  10 5 4 2
		
		for(int i=2;i<=N;i++) {
			dp[i] = dp[i-1]+1;
			if(i%2==0) dp[i] = Math.min(dp[i], dp[i/2]+1);
			if(i%3==0) dp[i] = Math.min(dp[i], dp[i/3]+1);
		}
		
		//System.out.println(Arrays.toString(dp));
		sb.append(dp[N]);
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}

}
