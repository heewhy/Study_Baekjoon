package com.Platinum;

import java.io.*;
import java.util.*;

public class Quiz23291 {

	static int N;
	static int[][] fishbowls;
	static int[] dr = {1,0,-1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception{
		// 어항 정리
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		fishbowls = new int[N][N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			fishbowls[0][i] = Integer.parseInt(st.nextToken());
		}
		
		int turn = 0;
		while(true) {
			turn++;
			
			increseFishCnt();
			
			fishbowls = pileFishbowls();
			
			regulateFishbowls();
			
			print();
			
			fishbowls = flatFishbowls();
			
			print();
			
			break;
		}
		
		br.close();
	}

	private static void print() {
		for(int[] i : fishbowls)System.out.println(Arrays.toString(i));
		System.out.println();
	}


	//물고기의 수가 가장 적은 어항에 물고기를 한 마리 넣는다.
	private static void increseFishCnt() {
		int min = Integer.MAX_VALUE;
		
		for(int i=0;i<N;i++) {
			min = Math.min(min, fishbowls[0][i]);
		}
		
		for(int i=0;i<N;i++) {
			if(min==fishbowls[0][i]) fishbowls[0][i]++;
		}
	}

	private static int[][] pileFishbowls() {
		int[][] map = new int[N][N];
		
		int startDir = 2;
		int iDir = 2;
		int cntDir = 0;
		int dir = 0;
		
		//dir 을 정해줘야함
		while(true) {
			cntDir++;
			if(N-startDir>0) {
				dir = ++dir%4; 
				startDir += iDir;
				if(cntDir%2==0) iDir++;
			}
			else break;
		}
		
		int center = N/2;
		
		int cnt =1;
		int ci=1;
		
		int i = center;
		int j = center;
		map[i][j] = fishbowls[0][0];
		
		dir-=1;
		int start = 1;
		loop:
		while(true) {
			for(int c=0;c<cnt;c++) {
				int ni = i + dr[dir];
				int nj = j + dc[dir];
				
				map[ni][nj] = fishbowls[0][start];
				i = ni;
				j = nj;
				start++;
				if(start>=startDir-iDir) break loop;
			}
			dir = ++dir%4; 
			if(ci++%2==0) ++cnt;
		}
		
		//i,j 는 끝난좌표 그다음에 j+1 부터 넣기
		//start 부터 N까지
		for(int k=start;k<N;k++) {
			map[i][++j] = fishbowls[0][k];
		}
		
		return map;
	}
	
	private static void regulateFishbowls() {
		int[][] plus = new int[N][N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(fishbowls[i][j]==0) continue;
				
				for(int d=0;d<4;d++) {
					int nr = i + dr[d];
					int nc = j + dc[d];
					
					//visited 관리로 diff abs 일수잇음
					if(isIn(nr,nc)&&fishbowls[nr][nc]!=0) {
						int diff = (fishbowls[i][j]-fishbowls[nr][nc])/5;
						if(diff>0) {
							plus[nr][nc] += diff;
							plus[i][j] -= diff;
						}
					}
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				fishbowls[i][j]+=plus[i][j];
			}
		}
	}

	private static boolean isIn(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}
	
	private static int[][] flatFishbowls() {
		int[][] map = new int[N][N];
		int idx=0;
		boolean flag = false;
		
		for(int i=N-1;i>=0;i--) {
			for(int j=0;j<N;j++) {
				if(fishbowls[i][j]==0) continue;
				
				int height = i;
				while(fishbowls[height][j]!=0) {
					map[0][idx] = fishbowls[height][j];
					idx++;
					height--;
				}
				flag = true;
			}
			if(flag) break;
		}
		return map;
	}
	

}
