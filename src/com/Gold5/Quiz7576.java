package com.Gold5;

import java.io.*;
import java.util.*;

public class Quiz7576 {

	static int N,M,cnt; //상자의 크기
	static int[][] box;
	static boolean[][] visited;
	static int[] dr = {-1,0,1,0}; //상우하좌
	static int[] dc = {0,1,0,-1};
	
	
	public static void main(String[] args) throws Exception{
		// 토마토
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		//상자의 가로 칸 수 입력 받기
		M = Integer.parseInt(st.nextToken());
		//상자의 세로 칸 수 입력 받기
		N = Integer.parseInt(st.nextToken());
		
		//상자 정보 입력 저장 공간
		box = new int[N][M];
		visited = new boolean[N][M];
		
		//익은 토마토 좌표 저장 공간
		LinkedList<int[]> queue = new LinkedList<int[]>();
		
		//상자 정보 입력받기
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				//익은 토마토 좌표 넣기
				if(box[i][j]==1) {
					//r,c,depth 값
					queue.offer(new int[] {i,j,0});
					visited[i][j] = true;
				}
			}
		}
		
		bfs(queue);

		//토마토가 다 익지 않았을 때를 확인하는 변수
		boolean check = true;
		
		for(int[] i: box) {
			for(int j: i) {
				if(j==0) check = false;
			}
		}
		
		if(check) sb.append(cnt);
		else sb.append(-1);
		
		bw.write(sb.toString());
		
		
		br.close();
		bw.flush();
		bw.close();
	}


	private static void bfs(LinkedList<int[]> queue) {
		
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			int r = temp[0];
			int c = temp[1];
			cnt = temp[2];
			
			for(int d=0;d<4;d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				//경계 안에 있고, -1이 아니며, 방문하지않았을 때
				if(nr>=0&&nc>=0&&nr<N&&nc<M&&!visited[nr][nc]&&box[nr][nc]!=-1) {
					visited[nr][nc] = true;
					box[nr][nc] =1;
					queue.offer(new int[] {nr,nc,cnt+1});
				}
			}
		}
		
	}

}
