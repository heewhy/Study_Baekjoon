package com.Gold4;

import java.io.*;
import java.util.*;

public class Quiz1987 {
	
	static int R,C,ans;
	
	static int[][] map;
	static boolean[] visited;
	
	// 우 하 좌 상
	static int[] dr = {0,-1,0,1}; 
	static int[] dc = {1,0,-1,0}; 
	
	
	public static void main(String[] args) throws Exception{
		// 알파벳
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		visited = new boolean[26];
		
		//맵입력
		for(int i=0;i<R;i++) {
			String str = br.readLine();
			for(int j=0;j<C;j++) {
				map[i][j] = str.charAt(j)-'A';
			}
		}
		
		move(0,0,0);
		
		sb.append(ans);
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}

	/**
	 * 말을 움직이는 함수
	 * @param r 현재의 행
	 * @param c 현재의 열
	 * @param cnt 이동한 수
	 * */
	
	private static void move(int r, int c,int cnt) {
		
		// 0,0에 저장된 알파벳이 이미 한번 방문한 알파벳이라면,
		if (visited[map[r][c]]) { 
			// 정답을 갱신해준다.
			ans = Math.max(ans, cnt);
			// 조건에 만족하므로 리턴.
			return; 
		} else {
			visited[map[r][c]] = true;
			for (int d=0;d<4;d++) {
				int nr= r + dr[d];
				int nc = c + dc[d];

				if (nr >= 0 && nc >= 0 && nr < R && nc < C) {
					move(nr, nc, cnt + 1);
				}

			}

			visited[map[r][c]] = false;

		}
	}

}
