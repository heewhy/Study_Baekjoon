package com.Silver3;

import java.io.*;
import java.util.*;

public class Quiz16956 {

	public static void main(String[] args) throws Exception{
		// 늑대와 양
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		//목장 세로
		int R = Integer.parseInt(st.nextToken());
		//목장 가로
		int C = Integer.parseInt(st.nextToken());
		char[][] map = new char[R][C];
		
		for(int i=0;i<R;i++) {
			String temp = br.readLine();
			for(int j=0;j<C;j++) {
				char c = temp.charAt(j);
				map[i][j] = c;
			}
		}
		
		int[] dr = {-1,0,1,0};
		int[] dc = {0,1,0,-1};
		boolean check = true;
		
		loop:
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				//늑대찾기
				if(map[i][j]=='W') {
					for(int d=0;d<4;d++) {
						int r = i+dr[d];
						int c = j+dc[d];
						//늑대의 상하좌우가 늑대가 아닐때
						if(r>=0&&c>=0&&r<R&&c<C&&map[r][c]!='W') {
							//양이면 울타리를 칠수없음
							if(map[r][c]=='S') {
								check=false;
								break loop;
							}
							//울타리치기
							else map[r][c]='D';
						}
					}
				}
			}
		}
		
		if(check) {
			sb.append("1\n");
			for(char[] temp : map) {
				for(char c : temp) {
					sb.append(c);
				}
				sb.append("\n");
			}
		}else {
			sb.append("0\n");
		}
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}

}
