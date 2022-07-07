package com.Gold4;

import java.io.*;
import java.util.*;

public class Quiz1956 {
	
	static final int INF = 9999999;

	public static void main(String[] args) throws Exception{
		// 운동
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//정점 개수 및 간선 개수
		st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		int[][] adjMatrix = new int[V+1][V+1];

		for(int i=1;i<=V;i++) {
			Arrays.fill(adjMatrix[i], INF);
		}
		
//		for(int i=1;i<=V;i++) {
//			adjMatrix[i][i] = 0;
//		}
		
		while(E-->0) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			adjMatrix[from][to] = weight;
		}
		
		for(int k=1;k<=V;k++) {
			for(int start=1;start<=V;start++) {
				if(k==start) continue; 
				for(int end=1;end<=V;end++) {
					if(k==end) continue;
					if(adjMatrix[start][end]>adjMatrix[start][k]+adjMatrix[k][end]) {
						adjMatrix[start][end] = adjMatrix[start][k]+adjMatrix[k][end];
					}
				}
			}
		}
		
		//for(int[] i : adjMatrix) System.out.println(Arrays.toString(i));
		int ans = Integer.MAX_VALUE;
		
		for(int i=1;i<=V;i++) {
			ans = Math.min(ans, adjMatrix[i][i]);
		}
		
		System.out.println(ans==INF?-1:ans);
		
		br.close();
	}

}
