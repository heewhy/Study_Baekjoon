package com.Silver2;

import java.io.*;
import java.util.*;

public class Quiz1012 {
	
	static int[][] map;
	static boolean[][] visited;
	static int N,M,K;
	static int[] di = {-1,0,1,0}; //상우하좌
	static int[] dj = {0,1,0,-1};
	

	public static void main(String[] args) throws Exception{
		// 유기농 배추
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			StringBuilder sb = new StringBuilder();
			st= new StringTokenizer(br.readLine());
			
			//가로길이,세로길이,배추의 개수
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			visited = new boolean[N][M];
			int cnt=0;
			
			for(int i=0;i<K;i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				map[r][c]=1;
			}
			
			//for(int[] a:map)System.out.println(Arrays.toString(a));System.out.println();
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(map[i][j]==1&&!visited[i][j]) {
						bfs(i,j);
						cnt++;
						
					}
				}
			}
			
			
			sb.append(cnt+"\n");
			
			bw.write(sb.toString());
			
			
		}
		
		br.close();
		bw.flush();
		bw.close();
		
		
	}//main

	//너비우선탐색 row,colum
	private static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {r,c});
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			int cur[] = q.poll();
			r = cur[0];
			c = cur[1];
			
			for(int d=0;d<4;d++) {
				int i = r+di[d];
				int j = c+dj[d];
				if(i>=0&&i<N&&j>=0&&j<M&&!visited[i][j]&&map[i][j]==1) {
					visited[i][j]=true;
					q.offer(new int[] {i,j});
				}
			}
		}
		
		
	}

}
