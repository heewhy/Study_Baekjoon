package com.Gold4;

import java.io.*;
import java.util.*;

public class Quiz17144 {

	public static void main(String[] args) throws Exception{
		// 미세먼지 안녕!
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		//행 길이, 열 길이, 시간
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		//미세먼지 정보 받을 공간
		int[][] map = new int[R][C];
		int[] air = null;
		
		//-1 공기 청정기 
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<C;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(air==null && map[i][j]==-1) air = new int[] {i, j};
			}
		}
		
		int[][] d = {{-1,0},{0,1},{1,0},{0,-1}}; // 위쪽 순환
		int[][] d2 = {{1,0},{0,1},{-1,0},{0,-1}}; // 아래쪽 순환
		
		while(T-->0) {
			// 확산
			int[][] temp = new int[R][C];
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					// 확산될 수 있으면
					if(map[i][j]>=5) {
						int td = map[i][j] / 5;
						for(int k=0;k<4;k++) {
							int x = i + d[k][0];
							int y = j + d[k][1];
							if(x>=0 && x<R && y>=0 && y<C && map[x][y]!=-1) {
								temp[x][y] += td;
								map[i][j] -= td;
							}
						}
					}
				}
			}
			
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					map[i][j] += temp[i][j];
				}
			}
			
			// 공기청정기
			int airx = air[0]-1;
			int airy = air[1];
			int k=0;
			// 위쪽 순환
			while(!(airx == air[0] && airy == air[1])) {
				int dx = airx+d[k][0];
				int dy = airy+d[k][1];
				
				if(dy>=0 && dy<C && dx>=0 && dx<=air[0]) {
					map[airx][airy] = map[dx][dy];
					airx = dx;
					airy = dy;
				}else {
					k = (k+1)%4;
				}
			}
			map[airx][airy+1] = 0;
			airx+=2;
			k=0;
			// 아래쪽 순환
			while(!(airx == air[0]+1 && airy == air[1])) {
				int dx = airx+d2[k][0];
				int dy = airy+d2[k][1];
				
				if(dy>=0 && dy<C && dx<R && dx>air[0]) {
					map[airx][airy] = map[dx][dy];
					airx = dx;
					airy = dy;
				}else {
					k = (k+1)%4;
				}
			}
			map[airx][airy+1] = 0;
		}
		
		// 개수 세기
		int ans=0;
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j]!=-1) ans+=map[i][j];
			}
		}
		
		sb.append(ans);
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();

	}

}
