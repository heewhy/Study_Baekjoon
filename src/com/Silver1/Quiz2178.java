package com.Silver1;

import java.io.*;
import java.util.*;

public class Quiz2178 {
	
	static int N,M,cnt;
	static int[] di = {0,1,-1,0}; //하우상
	static int[] dj = {1,0,0,-1};
	static int[][] map;
	static boolean[][] visited;

	

	public static void main(String[] args) throws Exception{
		// 미로찾기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j]=s.charAt(j)-'0';
			}
		}
		
		//for(int[] a : map) System.out.println(Arrays.toString(a));
		
		cnt=1;
		bfs(0,0);
		
		sb.append(cnt);
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}//main

	private static void bfs(int i, int j) {
		
		Queue<int[]> q = new LinkedList<>();
		visited[i][j] = true;
		q.offer(new int[] {i,j,cnt});
		while(!q.isEmpty()) {			
			int[] cur = q.poll();
			i=cur[0];
			j=cur[1];
			cnt = cur[2];
			
			if(i==N-1&&j==M-1) return;
			
//			map[i][j] = 99;
//			for(int[] a : map)System.out.println(Arrays.toString(a));
//			System.out.println("cnt :"+cnt);
//			System.out.println("i :"+i);
//			System.out.println("j :"+j);
//			System.out.println("visited i j : "+visited[i][j]);
//			System.out.println();
			
			for(int d=0;d<4;d++) {
				int r=i+di[d];
				int c=j+dj[d];
				if(0<=r&&r<N&&0<=c&&c<M&&!visited[r][c]&&map[r][c]==1) {
//					System.out.println("r :"+r);
//					System.out.println("c :"+c);
//					System.out.println("visited r c : "+visited[r][c]);
					visited[r][c]=true;
					q.offer(new int[] {r,c,cnt+1}); 
				}
			}
			
		}
		
	}

	
	
}
