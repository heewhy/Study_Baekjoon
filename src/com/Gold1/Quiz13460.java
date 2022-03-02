package com.Gold1;

import java.io.*;
import java.util.*;

public class Quiz13460 {
	
	static int N,M,ans;
	static char[][] map;
	static boolean isSuccess;
	static boolean[][] redVisited;
	static boolean[][] blueVisited;
	static int[] dr = {-1,0,1,0}; //상우하좌
	static int[] dc = {0,1,0,-1};

	public static void main(String[] args) throws Exception{
		// 구슬 탈출2
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char [N][M];
		redVisited = new boolean[N][M];
		blueVisited = new boolean[N][M];
		
		int redr = 0;
		int redc = 0;
		
		int  bluer= 0;
		int  bluec= 0;
		
		for(int i=0;i<N;i++) {
			String temp = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] = temp.charAt(j);
				if(map[i][j]=='R') {
					redr=i;
					redc=j;
				}
				if(map[i][j]=='B') {
					bluer=i;
					bluec=j;
				}
			}
		}
		
		
		bfs(redr,redc,bluer,bluec);
		
		for(char[] c: map)System.out.println(Arrays.toString(c));
		
		if(isSuccess) sb.append(ans);
		else sb.append(-1);
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}

	private static void bfs(int redr, int redc, int bluer, int bluec) {
		
		LinkedList<int[]> q = new LinkedList<int[]>();
		int red=0;
		int blue=1;
		q.offer(new int[] {redr,redc,red,0});
		redVisited[redr][redc] = true;
		q.offer(new int[] {bluer,bluec,blue,0});
		blueVisited[bluer][bluec] = true;
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			
			int r = temp[0];
			int c = temp[1];
			int color = temp[2];
			int cnt = temp[3];
			
			for(int d=0;d<4;d++) {
				for(int i=1;i<Math.max(N, M);i++) {
					int nr = r + dr[d]*i;
					int nc = c + dc[d]*i;
					
					if(map[nr][nc]=='#') break;
					
					if(map[nr][nc]=='O'){
						if(color==1) { 
							isSuccess=false;
							return;
						}
						else {
							isSuccess = true;
							ans = cnt+1;
							return;
						}
					}
					
					if(map[nr][nc]=='.') {
						if(color==0) {
							map[nr][nc] = 'R';
							q.offer(new int[] {nr,nc,color,cnt+1});
						}else if(color==1){
							map[nr][nc] = 'B';
							q.offer(new int[] {nr,nc,color,cnt+1});
						}
						
					}
				}
			}
		}
		
	}
	

}


/*
		int dir=0;
		loop:
		while(true) {
			
			for(int i=0;i<Math.max(N, M);i++) {
				int rednr = redr + dr[dir]*i;
				int rednc = redc + dc[dir]*i;
				
				if(rednr>=0&&rednc>=0&&rednr<N&&rednc<M&&map[rednr][rednc]=='.') {
					map[rednr][rednc]='R';
					redr = rednr;
					redc = rednc;
				}
				
				if(rednr>=0&&rednc>=0&&rednr<N&&rednc<M&&map[rednr][rednc]=='O') {
					isSuccess=true;
					break loop;
				}
				
				int bluenr = bluer + dr[dir]*i;
				int bluenc = bluec + dc[dir]*i;
				
				if(bluenr>=0&&bluenc>=0&&bluenr<N&&bluenc<M&&map[bluenr][bluenc]=='.') {
					map[bluenr][bluenc]='B';
					bluer = bluenr;
					bluec = bluenc;
				}
				
				if(bluenr>=0&&bluenc>=0&&bluenr<N&&bluenc<M&&map[bluenr][bluenc]=='O') {
					isSuccess=false;
					break loop;
				}
				
			}
			
			
			dir = ++dir%4;
			if(dir==0) ans++;
			
		}
*/
