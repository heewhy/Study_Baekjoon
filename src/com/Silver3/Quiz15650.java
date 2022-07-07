package com.Silver3;

import java.io.*;
import java.util.*;

public class Quiz15650 {

	static int N,M;
	static int[] arr;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception{
		// N과 M(2)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr= new int[M];
		visited = new boolean[N+1];

		comb(0,1);
		
		br.close();
	}

	private static void comb(int cnt, int start) {
		
		if(cnt==M) {
			for(int ans: arr) {
				System.out.print(ans+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=start;i<=N;i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			arr[cnt] = i;
			comb(cnt+1,i);
			visited[i] = false;
		}
		
	}

}
