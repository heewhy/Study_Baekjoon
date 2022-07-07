package com.Silver2;

import java.io.*;
import java.util.*;

public class Quiz1890 {
	
	static int N;
	static int[][] map;
	static long[][] dp;

	public static void main(String[] args) throws Exception{
		// 점프
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		dp = new long[N+1][N+1];

		for (int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=1;j<=N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i=1;i<=N;i++) {
			Arrays.fill(dp[i], -1);
		}
		dp[N][N] = 1;
		long ans = jump(1,1);
		
		System.out.println(ans);
		
		br.close();
	}
	
	
	/**
	 * 점프 가능한 더 큰 경우의 수를 저장
	 * @param r
	 * @param c
	 * @return
	 */
	public static long jump(int r, int c) {
		
		if(dp[r][c] != -1) return dp[r][c];

		dp[r][c] = 0;

		int dr = r + map[r][c];
		int dc = c + map[r][c];

		// 아래와 오른쪽 이동이 모두 불가한 경우
		if(dr>N && dc>N) return 0;
		
		//경계 안
		// 아래 큰 값 갱신
		if(dr<=N) dp[r][c] = Math.max(dp[r][c], dp[r][c] + jump(dr, c));

		// 오른쪽
		if(dc<=N) dp[r][c] = Math.max(dp[r][c], dp[r][c] + jump(r, dc));

		return dp[r][c];
	}

}
