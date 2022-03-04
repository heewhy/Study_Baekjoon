package com.Silver1;

import java.io.*;
import java.util.*;

public class Quiz2667 {
	
	static int N,ans;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1,0,1,0}; //상우하좌
	static int[] dc = {0,1,0,-1};
	
	
	public static void main(String[] args) throws Exception{
		// 단지번호붙이기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		//지도 크기 입력 받기
		N = Integer.parseInt(br.readLine());
		
		//지도 크기 만큼 배열 생성
		map = new int[N][N];
		visited = new boolean[N][N];
		//오름차순 정렬을 위한 단지의 개수를 저장할 리스트
		ArrayList<Integer> house_cnt = new ArrayList<Integer>();
		
		//지도 정보 입력받기
		for(int i=0;i<N;i++) {
			String temp = br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j] = temp.charAt(j)-'0';
			}
		}
		
		//단지 수 체크
		int cnt=0;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visited[i][j]&&map[i][j]==1) {
					bfs(i,j);
					cnt++;
					//단지 내의 집 개수
					house_cnt.add(ans);
				}
			}
		}
		
		//오름차순 정렬
		house_cnt.sort((a,b)->a-b);
		
		sb.append(cnt+"\n");
		for(int i=0;i<house_cnt.size();i++) {
		    sb.append(house_cnt.get(i)+"\n");	
		}
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}

	
	/**
	 * 너비 우선 탐색으로 1을 찾아 이동
	 * @param i, 현재의 행 값
	 * @param j, 현재의 열 값
	 * */
	private static void bfs(int i,int j) {
		
		LinkedList<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {i,j});
		visited[i][j] = true;
		ans=1;
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			int r = temp[0];
			int c = temp[1];
			
			for(int d=0;d<4;d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				
				if(nr>=0&&nc>=0&&nr<N&&nc<N&&!visited[nr][nc]&&map[nr][nc]==1) {
					visited[nr][nc]=true;
					q.offer(new int[] {nr,nc});
					ans++;
				}
				
			}
		}
		
	}

}
