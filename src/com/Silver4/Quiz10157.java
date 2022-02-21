package com.Silver4;

import java.io.*;
import java.util.*;

public class Quiz10157 {

	static int[][] map;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception{
		// 자리배정
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		
		map = new int[C][R];
		int cnt=1;
		int dir=0;
		int sr=0;
		int sc=0;
		map[sr][sc]= cnt;
		
		if(K>C*R) {
			sb.append(0);
		}else if(K==1){
			sb.append(1+" "+1);
		}
		else {
			while(cnt!=C*R) {
				
				int nr = sr+dr[dir];
				int nc = sc+dc[dir];
				if(nr>=0&&nc>=0&&nr<C&&nc<R&&map[nr][nc]==0) {
					map[nr][nc] = ++cnt;
					sr=nr;
					sc=nc;
					if(cnt==K) break;
				}else {
					dir=++dir%4;
				}
			}
			sr++;
			sc++;
			sb.append(sr+" "+sc+" ");
		}
		
		
		//for(int[] a : map)System.out.println(Arrays.toString(a));
		
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}

}
/*
BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(in.readLine());
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int K = Integer.parseInt(in.readLine());
		
		if(K < 1 || K > C*R) {
			System.out.println(0);
			return;
		}
		
		int x = 0;
		int y = 1;
		
		int round = 0;
		while(K > 0) {
			if(round%4 == 0) {
				x += Math.min(K, R);
				K -= Math.min(K, R);
				C--;
			} if(round%4 == 1) {
				y += Math.min(K, C);
				K -= Math.min(K, C);
				R--;
			} if(round%4 == 2) {
				x -= Math.min(K, R);
				K -= Math.min(K, R);
				C--;
			} if(round%4 == 3) {
				y -= Math.min(K, C);
				K -= Math.min(K, C);
				R--;
			}
			
			round++;
		}
		
		System.out.println(y+" "+x);  
 
 */
