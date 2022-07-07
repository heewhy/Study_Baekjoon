package com.Silver1;

import java.io.*;
import java.util.*;

public class Quiz2156 {

	public static void main(String[] args) throws Exception{
		// 포도주 시식
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		int[] memo = new int[N+1];
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		memo[1] = arr[0];
		if(N>1) {
			memo[2] = arr[0]+arr[1];
			
			for(int i=3;i<=N;i++) {
				memo[i] = Math.max(memo[i-1], Math.max(memo[i-3]+arr[i-2], memo[i-2])+arr[i-1]);
			}
		}
		
		System.out.println(memo[N]);
		
		br.close();
	}

}
