package com.Gold3;

import java.io.*;
import java.util.*;

public class Quiz7579 {
	
	static int N;
	static int[] memories, costs;
	static int[][] memo;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 앱의 개수
		int M = Integer.parseInt(st.nextToken()); // 확보할 메모리
		
		st = new StringTokenizer(br.readLine());
		memories = new int[N+1];
		for(int i=1;i<=N;i++) {
			memories[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		costs = new int[N+1];
		for(int i=1;i<=N;i++) {
			costs[i] = Integer.parseInt(st.nextToken());
		}
		
		//앱의 개수 (1 <=N <=100), 비용 ci(0 <=ci <=100)
		//memo[1][0] = 10 → 1번째까지 입력된 앱을 사용할 때 비용0으로 확보가능한 최대 메모리 크기는 10
		memo = new int[N+1][10001];
		
		for(int i=1;i<=N;i++){
			int memory = memories[i];
            int cost = costs[i];
			
            for(int j=0;j<=10000; j++){
                if (j >= cost) {
                	memo[i][j] = Math.max(memo[i-1][j-cost] + memory, memo[i-1][j]);
                }
                else memo[i][j] = memo[i-1][j];
            }
        }
		
		for(int i=1;i<10000;i++) {
			if(memo[N][i]>=M) {
				System.out.println(i);
				break;
			}
		}
		
		br.close();
	}

	
	//시간초과 백트래킹
//	private static void DisableAPP(int leftMemory, int totalCost, int idx) {
//		if(idx == N+1) return;
//		
//		if(leftMemory<=0) {
//			ans = Math.min(totalCost, ans);
//			return;
//		}
//		
//		DisableAPP(leftMemory, totalCost, idx+1);
//		DisableAPP(leftMemory-memories[idx],totalCost+costs[idx],idx+1);
//	}
	
	

}
