package com.Gold4;

import java.io.*;
import java.util.*;

public class Quiz1600 {
	
	static int K,R,C,ans;
	static int[][] map;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int[][] ddr = {{-2,-2},{-1,1},{2,2},{1,-1}};
	static int[][] ddc = {{-1,1},{2,2},{1,-1},{-2,-2}};

	public static void main(String[] args) throws Exception{
		// 말이 되고픈 원숭이
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		
		for(int i=0;i<R;i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=0;j<C;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		getCnt(0,0,0,new boolean[R][C][K+1]);
		System.out.println(ans);
		
		br.close();
	}

	private static void getCnt(int i,int j,int hcnt,boolean[][][] visited) {
		LinkedList<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {i,j,hcnt});
		visited[i][j][hcnt] = true;
		
		while(!q.isEmpty()) {
			int size = q.size();
			boolean flag = false;
			for(int k=0;k<size;k++) {
				int[] temp = q.poll();
				int r = temp[0];
				int c = temp[1];
				int cnt = temp[2];
				
				if(r==R-1&&c==C-1) {
					return;
				}
				
				if(cnt<K) {
					flag = true;
					for(int d=0;d<4;d++) {
						for(int s=0;s<2;s++) {
							int nr = r + ddr[d][s];
							int nc = c + ddc[d][s];
							if(nr>=0&&nc>=0&&nr<R&&nc<C&&map[nr][nc]==0&&!visited[nr][nc][cnt+1]) {
								visited[nr][nc][cnt+1] = true;
								q.add(new int[] {nr,nc,cnt+1});
							}else {
								flag=false;
							}
						}
					}
				}
				if(!flag) {
					for(int d=0;d<4;d++) {
						int nr = r+dr[d];
						int nc = c+dc[d];
						if(nr>=0&&nc>=0&&nr<R&&nc<C&&map[nr][nc]==0&&!visited[nr][nc][cnt]) {
							visited[nr][nc][cnt] = true;
							q.add(new int[] {nr,nc,cnt});
						}
					}
				}
			}
			ans++;
		}
		System.out.println(-1);
		System.exit(0);
		
	}

}
