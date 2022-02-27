package com.Silver5;

import java.io.*;
import java.util.*;

public class Quiz1010 {
	
	static int N,M,ans;
	static int[] arr= new int[30];

	public static void main(String[] args) throws Exception{
		// 다리 놓기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		//테스트 케이스 입력
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			st = new StringTokenizer(br.readLine());
			//서쪽
			N = Integer.parseInt(st.nextToken());
			//동쪽
			M = Integer.parseInt(st.nextToken());
			
			//System.out.println(factorial(N));
			
			//int ans = factorial(M)/(factorial(N)*factorial(M-N));
			ans=0;
			comb(0,0);
			
			sb.append(ans+"\n");
		}
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}

	private static void comb(int cnt, int start) {
		if(cnt==N) {
			ans++;
			return;
		}
		
		
		for(int i=start;i<M;i++) {
			comb(cnt+1,i+1);
		}
	}

//	private static int factorial(int n) {
//		if(n<=1) return 1;
//		
//		return n*factorial(n-1);
//	}

}
