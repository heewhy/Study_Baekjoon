package com.Gold5;

import java.io.*;
import java.util.*;

public class Quiz14921 {

	static int water[];
	static int min;
	static int ans;
	
	public static void main(String[] args) throws Exception{
		// 용액 합성하기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		water = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			water[i] = Integer.parseInt(st.nextToken());
		}
		
		min = Integer.MAX_VALUE;
		
		getBestsynthesis(0,N-1);
		
		System.out.println(ans);
		
		br.close();
	}

	private static void getBestsynthesis(int start, int end) {
		if(start == end) return;
		
		int sum = water[start] + water[end];
		if(Math.abs(sum)<min) {
			min = Math.abs(sum);
			ans = sum;
		}
		
		if(Math.abs(water[start+1] + water[end]) < Math.abs(water[start] + water[end-1])) {
			getBestsynthesis(start+1,end);
		}
		else {
			getBestsynthesis(start,end-1);
		}
	}
	
//	public static void main(String[] args) throws Exception{
//		// 용액 합성하기
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//		
//		int N = Integer.parseInt(br.readLine());
//		
//		int[] water = new int[N];
//		
//		st = new StringTokenizer(br.readLine());
//		for(int i=0;i<N;i++) {
//			water[i] = Integer.parseInt(st.nextToken());
//		}
//		
//		int start = 0;
//		int end = N-1;
//		int min = Integer.MAX_VALUE;
//		int ans=0;
//		while(true) {
//			if(start==end) break;
//			int synthesis = Math.abs(water[start] + water[end]);
//			if(synthesis<min) {
//				min = synthesis;
//				ans = water[start] + water[end];
//			}
//			
//			if(Math.abs(water[start+1] + water[end]) < Math.abs(water[start] + water[end-1])) {
//				start++;
//			}
//			else {
//				end--;
//			}
//		}
//		
//		System.out.println(ans);
//		
//		br.close();
//	}

}
