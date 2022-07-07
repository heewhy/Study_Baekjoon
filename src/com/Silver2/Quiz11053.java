package com.Silver2;

import java.io.*;
import java.util.*;

public class Quiz11053 {

	public static void main(String[] args) throws Exception{
		// 가장 긴 증가하는 부분 수열
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] LIS = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0;
		for(int i=0; i<N; ++i) { 
			LIS[i] = 1; 
			for(int j=0; j<i; ++j) { 
				if(arr[j]<arr[i] && LIS[i]<LIS[j]+1) {   
					LIS[i] = LIS[j]+1;
				}
			}
			
			if(max<LIS[i]) max = LIS[i];
		}
		
		System.out.println(max);
		
		br.close();
		
	}

}
