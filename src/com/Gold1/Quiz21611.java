package com.Gold1;

import java.io.*;
import java.util.*;

public class Quiz21611 {
	
	static int N,M,ans,center,size;
	static int[][] map;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int[][] deltas = {{0,-1},{1,0},{0,1},{-1,0}};

	public static void main(String[] args) throws Exception{
		// 마법사 상어와 블리자드
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		center = N/2;
		
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(i==center&&j==center) map[i][j]=-1;
			}
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken())-1;
			int dist = Integer.parseInt(st.nextToken());
			
			//구슬 제거
			blizzard(dir,dist);
			//구슬 폭발
			ExplosionMarble();
			//맵 변화
			map = changeMap();
		}
		
		System.out.println(ans);
		
		br.close();
	}

	private static void blizzard(int dir, int dist) {
		for(int i=1;i<=dist;i++) {
			int r = center + dr[dir]*i;
			int c = center + dc[dir]*i;
			
			map[r][c] = 0;
		}
		
		sortingMarble(dist);
	}
	
	private static void sortingMarble(int number) {
		
		for(int i=0;i<number;i++) {
			int cnt =1;
			int dir = 0;
			int r = center;
			int c = center;
			
			loop:
				while(true) {
					for(int k=0;k<cnt;k++) {
						if(r==0&&c==0) break loop;
						
						int nr = r + deltas[dir][0];
						int nc = c + deltas[dir][1];
						
						if(map[r][c]==0&&map[nr][nc]!=0) { 
							map[r][c] = map[nr][nc];
							map[nr][nc] = 0;
						}
						
						r = nr;
						c = nc;
					}
					
					dir = ++dir%4; 
					if(dir%2==0) ++cnt;
				}
		}
		
	}
	
	private static void ExplosionMarble() {
		while(is4ChainMarble()) {
			sortingMarble(size);
		}
	}
	
	//폭발한 구슬들 더해주기
	private static boolean is4ChainMarble() {
		int cnt =1;
		int dir = 0;
		int r = center;
		int c = center;
		
		ArrayList<ArrayList> removableMarbles = new ArrayList<ArrayList>();
		ArrayList<int[]> saveMarbles = new ArrayList<int[]>();
		int num = map[r][c];
		int chainCnt = 1;
		size = 0;
		
		loop:
		while(true) {
			for(int k=0;k<cnt;k++) {
				if(map[r][c]==0) break loop;
				
				int nr = r + deltas[dir][0];
				int nc = c + deltas[dir][1];
				
				if(map[nr][nc]!=num) {
					if(chainCnt>=4) removableMarbles.add(saveMarbles);
					
					saveMarbles = new ArrayList<int[]>();
					saveMarbles.add(new int[] {nr,nc});
					num = map[nr][nc];
					chainCnt=1;
				}else {
					chainCnt++;
					saveMarbles.add(new int[] {nr,nc});
				}

				
				r = nr;
				c = nc;
			}
			
			dir = ++dir%4; 
			if(dir%2==0) ++cnt;
		}
		
		if(!removableMarbles.isEmpty()) {
			for(int i=0;i<removableMarbles.size();i++) {
				ArrayList<int[]> points = removableMarbles.get(i);
				size += points.size();
				ans += map[points.get(0)[0]][points.get(0)[1]] * points.size();
				for(int j=0;j<points.size();j++) {
					int[] temp = points.get(j);
					map[temp[0]][temp[1]] = 0;
				}
			}
			return true;
		}
		
		return false;
	}
	
	private static int[][] changeMap() {
		ArrayList<Integer> cntAndNum = getMarbleCntAndNum();
		
		int[][] temp = new int[N][N];
		
		int cnt =1;
		int dir = 0;
		int idx = 2;
		int r = center;
		int c = center;
		temp[r][c] = -1;
		loop:
			while(true) {
				for(int k=0;k<cnt;k++) {
					if(idx>=cntAndNum.size() || idx>=(N*N)) break loop;
					
					int nr = r + deltas[dir][0];
					int nc = c + deltas[dir][1];
					
					temp[nr][nc] = cntAndNum.get(idx);
					idx++;
					
					r = nr;
					c = nc;
				}
				
				dir = ++dir%4; 
				if(dir%2==0) ++cnt;
			}
		
		return temp;
	}


	private static ArrayList<Integer> getMarbleCntAndNum() {
		ArrayList<Integer> cntAndNum = new ArrayList<>();
		int cnt =1;
		int dir = 0;
		int r = center;
		int c = center;
		int num = map[r][c];
		int chainCnt = 1;
		
		loop:
			while(true) {
				for(int k=0;k<cnt;k++) {
					if(r==0&&c==0) break loop;
					
					int nr = r + deltas[dir][0];
					int nc = c + deltas[dir][1];
					
					if(map[nr][nc]!=num) {
						cntAndNum.add(chainCnt);
						cntAndNum.add(num);
						num = map[nr][nc];
						chainCnt=1;
					}else {
						chainCnt++;
					}
					
					r = nr;
					c = nc;
				}
				
				dir = ++dir%4; 
				if(dir%2==0) ++cnt;
			}
		
		
		return cntAndNum;
	}



	private static void print() {
		for(int[] i : map) System.out.println(Arrays.toString(i));
		System.out.println("==================================");
	}

}
