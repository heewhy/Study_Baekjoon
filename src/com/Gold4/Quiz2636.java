package com.Gold4;

import java.io.*;
import java.util.*;

public class Quiz2636 {
	
	static int R,C,ans,cheseCnt;
	static int[][] map;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};

	public static void main(String[] args) throws Exception{
		// 치즈
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<C;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		getTime(1);
		
		System.out.println(ans);
		System.out.println(cheseCnt);
		
		br.close();
	}

	/**
	 * 치즈가 다 사라지는 시간을 구하기
	 * @param hour 시간
	 */
	private static void getTime(int hour) {
		if(isEnd()) {
			ans=hour-1;
			return;
		}
		
		cheseCnt=0;
		getCheseCnt();
		bfs(0,0,new boolean[R][C]);
		
		getTime(hour+1);
		
	}

	/**
	 * 치즈 개수 세기
	 */
	private static void getCheseCnt() {
		for(int[] i:map) {
			for(int j:i) if(j==1) cheseCnt++;
		}
		
	}

	/**
	 * 치즈가 녹는 과정
	 * @param i
	 * @param j
	 * @param visited
	 */
	private static void bfs(int i, int j, boolean[][] visited) {
		LinkedList<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {i,j});
		visited[i][j] = true;
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			int r = temp[0];
			int c = temp[1];
			
			for(int d=0;d<4;d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				
				if(nr>=0&&nc>=0&&nr<R&&nc<C&&!visited[nr][nc]) {
					if(map[nr][nc]==1) {
						visited[nr][nc] = true;
						map[nr][nc] = 0;
					}else {
						visited[nr][nc] = true;
						q.add(new int[] {nr,nc});
					}
				}
			}
		}
		
	}

	/**
	 * 남아있는 치즈가 있는지 확인
	 * @return
	 */
	private static boolean isEnd() {
		for(int[] i:map) {
			for(int j:i) {
				if(j==1) return false;
			}
		}
		return true;
	}

}
