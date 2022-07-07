package com.Silver3;

import java.io.*;
import java.util.*;

public class Quiz15649 {

	static int N,M;
	static int[] input;
	static int[] numbers;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception{
		// N과 M
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		//총 숫자
		N = Integer.parseInt(st.nextToken());
		//선택해야하는 숫자
		M = Integer.parseInt(st.nextToken());
		input = new int[N+1];
		visited = new boolean[N+1];
		for(int i=1;i<=N;i++) {
			input[i] = i;
		}
		numbers = new int[M];
		
		perm(0);
		
		br.close();
	}

	private static void perm(int cnt) {
		
		if(cnt==M) {
			for(int ans : numbers) {
				System.out.print(ans+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=1;i<=N;i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			numbers[cnt] = input[i];
			perm(cnt+1);
			visited[i] = false;
		}
		
	}

}
