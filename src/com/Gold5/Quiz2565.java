package com.Gold5;

import java.io.*;
import java.util.*;

public class Quiz2565 {

	static final int MAXSIZE = 501;
	
	public static void main(String[] args) throws Exception{
		// 전깃줄
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[MAXSIZE];
		
		Arrays.fill(arr, -1);
		
		while(N-->0) {
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			arr[idx] = num;
		}
		
//		System.out.println(Arrays.toString(arr));
		
		int[] LIS = new int[MAXSIZE];
		
		for(int i=1;i<MAXSIZE;i++) {
			if(arr[i] == -1) continue;
			LIS[i] = 1;
			for(int j=1;j<i;j++) {
				if(arr[j] == -1) continue;
				
				if(arr[j]<arr[i]&&LIS[i]<LIS[j]+1){
					LIS[i] = LIS[j]+1;
				}
			}
			
		}
		
		int[] call = new int[MAXSIZE];
		for(int i: LIS) {
			call[i]++;
		}
		
		int ans=0;
		for(int i=1;i<MAXSIZE;i++) {
			if(call[i]==0) continue;
			ans+=call[i]-1;
		}
		
//		System.out.println(Arrays.toString(LIS));
//		System.out.println(Arrays.toString(call));
		System.out.println(ans);
		
		br.close();
	}

}
