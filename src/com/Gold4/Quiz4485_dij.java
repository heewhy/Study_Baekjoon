package com.Gold4;

import java.io.*;
import java.util.*;

public class Quiz4485_dij {
	static int dr[] = {-1,0,1,0};
 	static int dc[] = {0,1,0,-1};
	static int[][] cave;
	static int[][] dp;
	static boolean[][] visited;
	static int N;
	
	static class Node implements Comparable<Node>{
		int r,c,weight;
		
		
		public Node(int r, int c, int weight) {
			this.r = r;
			this.c = c;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight-o.weight;
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		// 녹색 옷 입은 애가 젤다지?
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		int tc=0;
		while(true) {
			 N = Integer.parseInt(br.readLine());
			
			if(N==0) break;
			
			cave = new int[N][N];
			dp = new int[N][N];
			visited = new boolean[N][N];
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					cave[i][j] = Integer.parseInt(st.nextToken());
					dp[i][j] = Integer.MAX_VALUE;
				}
			}
			
			dijkstra();
			
			++tc;
			System.out.println("Problem "+tc+": "+dp[N-1][N-1]);
		}
		
		br.close();
	}

	private static void dijkstra() {
		PriorityQueue<Node> q = new PriorityQueue<>();
		
		dp[0][0] = cave[0][0];	//시작위치 비용 고려
		q.offer(new Node(0,0,cave[0][0]));
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			int r = n.r;
			int c = n.c;
			
			visited[r][c] = true; //해당 정점의 최소비용은 확정됨
			
			for(int d=0;d<4;d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				
				//경계를 벗어나거나 최소비용이 확정된 정점
				if(nr<0||nc<0||nr>=N||nc>=N||visited[nr][nc]) continue; 

			
				if(dp[nr][nc]>dp[r][c]+cave[nr][nc]) {
					dp[nr][nc] = dp[r][c]+cave[nr][nc];
					q.add(new Node(nr,nc,dp[r][c]+cave[nr][nc]));
				}
					
			}
			
		}
		
	}
}

