package com.Gold1;

import java.io.*;
import java.util.*;

public class Quiz16991 {
	
	static int N;
	static double result;
	static int[] arr,idx;
	static int[][] city;

	public static void main(String[] args) throws Exception{
		// 외판원 순회 3
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i]=i;
		}
		
		idx = new int[N];
		city = new int[N][2];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			city[i][0] = Integer.parseInt(st.nextToken());
			city[i][1] = Integer.parseInt(st.nextToken());
		}
		result=Double.MAX_VALUE;
				
		perm(0,0);
		
		sb.append(result);
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();	
		
	}

	private static void perm(int cnt, int flag) {
		
		if(cnt==N) {
			for(int i=0;i<N-1;i++) {
				System.out.println(Arrays.toString(idx));
				double a = Math.abs(Math.pow(city[idx[i+1]][0]-city[idx[i]][0], 2));
				double b = Math.abs(Math.pow(city[idx[i+1]][1]-city[idx[i]][1], 2));
				Math.min(result, Math.sqrt(a+b));
			}
		}
		
		for(int i=0;i<N;i++) {
			if((flag&1<<i)!=0) continue;
			
			idx[cnt] = arr[cnt];
			
			perm(cnt+1,flag|1<<i);
		}
		
	}

}
