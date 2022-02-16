package com.Bronze1;

import java.io.*;
import java.util.*;

public class Quiz11050 {
	
	static int[][] dp ;

	public static void main(String[] args) throws Exception{
		// 이항 계수 1
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		dp = new int[N+1][K+1];
		
		sb.append(BC(N,K));
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}

	private static int BC(int n, int k) {
		// 이미 풀었던 sub문제일 경우 값을 재활용
		if (dp[n][k] > 0) {
			return dp[n][k];
		}
 
		// 2번 성질
		if (k == 0 || n == k) {
			return dp[n][k] = 1;
		}
 
		// 1번 성질
		return dp[n][k] = BC(n - 1, k - 1) + BC(n - 1, k);
	}

}
