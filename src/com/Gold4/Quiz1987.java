package com.Gold4;

import java.io.*;
import java.util.*;

public class Quiz1987 {
	
	static int R,C,cnt;
	
	static char[][] map;
	static boolean[][] visited;
	
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
		
		map = new char[R][C];
		visited = new boolean[R][C];
		
		//맵입력
		for(int i=0;i<R;i++) {
			map[i] = br.readLine().toCharArray();
		}
		cnt=0;
		ArrayList<Character> pass = new ArrayList<Character>();
		move(0,0,pass);
		
		sb.append(cnt);
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}

	/**
	 * 말을 움직이는 함수
	 * @param r 현재의 행
	 * @param c 현재의 열
	 * */
	
	private static void move(int r, int c,ArrayList<Character> pass) {
		
		
		if(!pass.contains(map[r][c])) {
			//System.out.println(map[r][c]);
			pass.add(map[r][c]);
			System.out.println(pass);
			cnt++;
			for(int d=0;d<4;d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				//System.out.println("nr :"+nr);
				//System.out.println("nc :"+nc);
				if(nr>=0&&nr<R&&nc>=0&&nc<C) {
					move(nr,nc,pass);
				}
			}
		}else {
			return;
		}
	}

}
