package com.Bronze1;

import java.io.*;
import java.util.*;

public class Quiz2839 {

	public static void main(String[] args) throws Exception{
		// 설탕 배달
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		//설탕 5kg 
		int a = 5;
		//설탕 3kg
		int b = 3;
		
		int N = Integer.parseInt(br.readLine());
		
		int cnt=0;
		
		while(N!=0) {
			
			if(N%a==0) {
				cnt+=N/a;
				break;
			}else if(N>=b){
				N-=b;
				cnt++;
			}else {
				cnt=-1;
				break;
			}

		}
		
		sb.append(cnt);
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}

}

/*
 * public static void main(String[] args) {
		int N = new Scanner(System.in).nextInt();
		
		int[] dp = new int[N+3];
		dp[3] = 1;
		dp[5] = 1;
		
		for (int i = 6; i <= N; i++) {
			int kg3 = 0, kg5 = 0;
			
			if(dp[i-3] > 0) kg3 = dp[i-3] + 1;
			if(dp[i-5] > 0) kg5 = dp[i-5] + 1;
			
			if(kg3*kg5 > 0)
				dp[i] = Math.min(kg3, kg5);
			else
				dp[i] = kg3|kg5;
		}
		
		System.out.println((dp[N] > 0)? dp[N]:-1);

	}
 * */
