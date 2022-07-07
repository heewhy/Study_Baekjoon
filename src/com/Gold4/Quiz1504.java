package com.Gold4;

import java.io.*;
import java.util.*;

public class Quiz1504 {

	static int N;
	static int[][] adjMatrix;
	static final int INF = 200000000;
	
	public static void main(String[] args) throws Exception{
		// 특정한 최단 경로
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		adjMatrix = new int[N+1][N+1];
		
		while(E-->0) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			adjMatrix[from][to] = adjMatrix[to][from] = weight;
		}
		
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		//1-v1-v2-N
		int case1 = 0;
		case1 += dijk(1,v1,new int[N+1],new boolean[N+1]);
		case1 += dijk(v1,v2,new int[N+1],new boolean[N+1]);
		case1 += dijk(v2,N,new int[N+1],new boolean[N+1]);
		//1-v2-v1-N
		int case2 = 0;
		case2 += dijk(1,v2,new int[N+1],new boolean[N+1]);
		case2 += dijk(v2,v1,new int[N+1],new boolean[N+1]);
		case2 += dijk(v1,N,new int[N+1],new boolean[N+1]);
		
		int ans = 0;
//		System.out.println(case1);
//		System.out.println(case2);
		
		//경로가 없는 경우
		//==안됨
		if(case1>=INF&&case2>=INF) {
			ans=-1;
		}
		else {
			ans = Math.min(case1, case2);
		}
		
		System.out.println(ans);
		
		br.close();
	}

	private static int dijk(int start, int end,int[] dist,boolean[] visited) {
		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		//start~end 까지 안됨
		for(int i=1;i<=N;i++) {
			int min = INF,cur = start;
			for(int j=1;j<=N;j++) {
				if(!visited[j]&&min>dist[j]) {
					min = dist[j];
					cur = j;
				}
			}
			
			visited[cur] = true;
			
			for(int j=1;j<=N;j++) {
				if(!visited[j]&&adjMatrix[cur][j]!=0&&
					dist[j]>dist[cur]+adjMatrix[cur][j]) {
					dist[j] = dist[cur]+adjMatrix[cur][j];
				}
			}
			
		}
		
		return dist[end];
	}

}
