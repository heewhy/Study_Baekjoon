package com.Silver3;

import java.io.*;
import java.util.*;

public class Quiz2559 {

	public static void main(String[] args) throws Exception{
		// 수열
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		int ans=Integer.MIN_VALUE;
		for(int i=0;i<N-K+1;i++) {
			int sum=0;
			for(int k=0;k<K;k++) {
				sum += arr[i+k];
			}
			ans = Math.max(ans, sum);
		}
		
		sb.append(ans);
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}

}
