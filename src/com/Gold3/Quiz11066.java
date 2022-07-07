package com.Gold3;

import java.io.*;
import java.util.*;

public class Quiz11066 {

	public static void main(String[] args) throws Exception{
		// 파일 합치기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N+1];
			int[] sum = new int[N+1];
			int[][] dp = new int[502][502];
            int[][] kk = new int[502][502];
			
			st = new StringTokenizer(br.readLine());
			for(int i=1;i<=N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				sum[i] = sum[i-1] + arr[i];
			}

			for(int i=1;i<=N;i++) {
                dp[i-1][i] = 0;
                kk[i-1][i] = i;
            }
			
			
			// DP 최적화 기법 중 하나인 Knuth Optimization을 사용한 코드 O(N^2)
            for (int d=2;d<=N;d++) {
                for (int i=0;i+d<=N;i++) {
                    int j = i+d;
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = kk[i][j - 1]; k <= kk[i + 1][j]; k++) {
                        int v = dp[i][k] + dp[k][j] + (sum[j] - sum[i]);
                        if (dp[i][j] > v) {
                            dp[i][j] = v;
                            kk[i][j] = k;
                        }
                    }
                }
            }
            System.out.println(dp[0][N]);
 
            // DP 최적화없이 그냥 DP로 푼 코드. O(N^3)
            // j에서 i까지의 최소 비용. (j < k < i)
//            for (int i = 2; i <= N; i++) {
//                for (int j = i - 1; j > 0; j--) {
//                    dp[j][i] = Integer.MAX_VALUE;
//                    for (int k = j; k <= i; k++) {
//                        dp[j][i] = Math.min(dp[j][i], dp[j][k] + dp[k + 1][i]);
//                    }
//                    dp[j][i] += sum[i] - sum[j - 1]; // 마지막에 전체 합을 한 번 더해준다.
//                }
//            }
//            System.out.println(dp[1][N]);
 
        }
		br.close();

	}

}
