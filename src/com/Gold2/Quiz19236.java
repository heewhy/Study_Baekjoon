package com.Gold2;

import java.io.*;
import java.util.*;

public class Quiz19236 {
	
	static final int N = 4;
	static int ans;
	static int[] dr = {-1,-1,0,1,1,1,0,-1};
	static int[] dc = {0,-1,-1,-1,0,1,1,1};
	
	static class Shark{
		int r,c,dir,score;

		public Shark(int r, int c, int dir,int score) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
			this.score = score;
		}
		
	}
	static class Fish{
		boolean isDead;
		int r,c,dir;
		
		public Fish(boolean isDead,int r, int c, int dir) {
			super();
			this.isDead = isDead;
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
		
	}

	public static void main(String[] args) throws Exception{
		// 청소년 상어
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] map = new int[N][N];
		Fish[] fishs = new Fish[17];
		map[0][0] = -1;
		
		Shark shark = null;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				int fishNum = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken())-1;
				//0,0에 있는 물고기를 먹으면서 점수 얻기
				if(i==0&&j==0) {
					shark = new Shark(0,0,dir,fishNum);
					Fish fish = new Fish(true,i,j,dir);
					fishs[fishNum] = fish;
				}
				else {
					map[i][j] = fishNum;
					Fish fish = new Fish(false,i,j,dir);
					fishs[fishNum] = fish;
				}
			}
		}
		getMaxFish(shark,map,fishs);
		
		System.out.println(ans);
		
		br.close();
	}

	private static void getMaxFish(Shark shark, int[][] map, Fish[] fishs) {

		//물고기가 이동
		moveFish(map,fishs);
		
		//상어가 이동
		for(int i=1;i<=N-1;i++) {
			//배열 복사
			int[][] clone = new int[N][N];
			Fish[] cFishs = new Fish[17];
			
			for(int c=0;c<N;c++) {
				clone[c] = map[c].clone();
			}
			for(int c=1;c<17;c++) {
				cFishs[c] = new Fish(fishs[c].isDead,fishs[c].r,fishs[c].c,fishs[c].dir);
			}
			
			clone[shark.r][shark.c] = 0;
			int r = shark.r+dr[shark.dir]*i;
			int c = shark.c+dc[shark.dir]*i;
			
			//맵 안에 있고 물고기라면
			if(isInMap(r,c)&&clone[r][c]>0) {
				//물고기 잡아먹기
				cFishs[clone[r][c]].isDead = true;
				int nextDir = cFishs[clone[r][c]].dir;
				int nextScore = shark.score+clone[r][c];
				
				Shark nextShark = new Shark(r,c,nextDir,nextScore);
				clone[r][c] = -1;
				getMaxFish(nextShark,clone,cFishs);
			}else {
				//상어가 움직일 수 없을 때 까지
				ans = Math.max(ans, shark.score);
			}
		}
		
	}

	private static void moveFish(int[][] map, Fish[] fishs) {
		for(int i=1;i<17;i++) {
			Fish fish = fishs[i];
			
			if(fish.isDead) continue;
			
			for(int time=0;time<8;time++) {
				int r = fish.r+dr[fish.dir];
				int c = fish.c+dc[fish.dir];
				
				if(isInMap(r,c)&&map[r][c]>=0) {
					//빈칸일 때와 물고기가 있을 때 구분하기
					if(map[r][c]==0) {
						map[r][c] = map[fish.r][fish.c];
						map[fish.r][fish.c] = 0;
						
						fish.r = r;
						fish.c = c;
						
						break;
					}
					else {
						int temp = map[r][c];
						map[r][c] = map[fish.r][fish.c];
						map[fish.r][fish.c] = temp;
						
						int tempR = fish.r;
						int tempC = fish.c;
						fish.r = r;
						fish.c = c;
						Fish prevFish = fishs[map[tempR][tempC]];
						prevFish.r = tempR;
						prevFish.c = tempC;
						
						break;
					}
				}else {
					fish.dir = (fish.dir+1)%8; 
				}
				
			}
			
		}
	}

	private static boolean isInMap(int r, int c) {
		return r>=0&&c>=0&&r<N&&c<N;
	}


}
