package com.Gold2;

import java.io.*;
import java.util.*;

public class Quiz19237 {
	

	static class Shark{
		boolean isDead;
		int r,c,dir;
		public Shark(boolean isDead, int r, int c, int dir) {
			super();
			this.isDead = isDead;
			this.r = r;
			this.c = c;
			this.dir = dir;
		}

		
	}
	static int N,M,K;
	static int[][][] map;
	static Shark[] sharks;
	static int[] dr = {-1,1,0,0}; //위 아래 왼쪽 오른쪽
	static int[] dc = {0,0,-1,1};
	static int[][][] priority;
	
	public static void main(String[] args) throws Exception{
		// 어른 상어
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //맵 크기
		M = Integer.parseInt(st.nextToken()); //상어 마리 수
		K = Integer.parseInt(st.nextToken()); //냄새가 남는 수
		
		map = new int[N][N][M+1];
		sharks = new Shark[M];
		priority = new int[M][4][4];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				int sharkNum = Integer.parseInt(st.nextToken());
				if(sharkNum!=0) {
					map[i][j][sharkNum-1] = K;
					map[i][j][M] = K;
					Shark shark = new Shark(false,i,j,0);
					sharks[sharkNum-1] = shark;
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			int dir = Integer.parseInt(st.nextToken())-1;
			sharks[i].dir = dir;
		}
		
		for(int sharkNum=0;sharkNum<M;sharkNum++) {
			for(int dirType=0;dirType<4;dirType++) {
				st = new StringTokenizer(br.readLine());
				for(int orderDir=0;orderDir<4;orderDir++) {
					int dir = Integer.parseInt(st.nextToken())-1;
					priority[sharkNum][dirType][orderDir] = dir;
				}
			}
		}
		
		int time = getTimeForMakeSharkKing();
		System.out.println(time>1000?-1:time);
//		for(int i=0;i<N;i++) {
//			for(int j=0;j<N;j++) {
//					System.out.print(map[i][j][1]);
//				}
//				System.out.println();
//			}
		
		br.close();
	}

	private static int getTimeForMakeSharkKing() {
		int time=0;
		int sharkCnt = M;
		while(sharkCnt!=1&&time<=1000) {
		//while(time<1) {
			//시간 증가
			time++;
			//상어 이동
			for(int sharkNum=0;sharkNum<M;sharkNum++) {
				Shark shark = sharks[sharkNum];
				if(shark.isDead) continue;
				
				int idx=0;
				boolean isntMove=false;
				//빈칸 탐색
				while(true) {
					if(idx==4) {
						isntMove = true;
						break;
					}
					
					int dir = priority[sharkNum][shark.dir][idx];
					int nr = shark.r+dr[dir];
					int nc = shark.c+dc[dir];
					
					//경계 안에 있는 경우 
					if(isInMap(nr,nc)&&map[nr][nc][M]==0) {
						//빈칸인 경우
						shark.r = nr;
						shark.c = nc;
						shark.dir = dir;
						break;
					}
					//경계 밖인경우
					else {
						idx++;
					}
					
				}
				
				//다른 상어 영역뿐 인 경우
				idx = 0;
				if(isntMove) {
					//자기냄새로 가자
					while(true) {
						int dir = priority[sharkNum][shark.dir][idx];
						int nr = shark.r+dr[dir];
						int nc = shark.c+dc[dir];
						
						if(isInMap(nr,nc)&&map[nr][nc][sharkNum]>0) {
							shark.r = nr;
							shark.c = nc;
							shark.dir = dir;
							break;
						}else {
							idx++;
						}
					}
				}
				
			}
			
			//상어 죽이기
			for(int sharkNum=0;sharkNum<M;sharkNum++) {
				Shark curShark = sharks[sharkNum];
				if(curShark.isDead) continue;
				for(int nextSharkNum=sharkNum+1;nextSharkNum<M;nextSharkNum++) {
					if(nextSharkNum==M) continue;
					Shark nextShark = sharks[nextSharkNum];
					if(nextShark.isDead) continue;
					
					if(curShark.r==nextShark.r&&curShark.c==nextShark.c) {
						sharkCnt--;
						nextShark.isDead = true;
					}
				}
				map[curShark.r][curShark.c][M] = K+1;
				map[curShark.r][curShark.c][sharkNum] = K+1;
			}
			
			//냄새 시간 감소
			reduceSharkSmell();
		}
		return time;
	}

	private static boolean isInMap(int nr, int nc) {
		return nr>=0&&nc>=0&&nr<N&&nc<N;
	}

	private static void reduceSharkSmell() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				for(int num=0;num<=M;num++) {
					if(map[i][j][num]==0) continue;
					
					map[i][j][num]--;
				}
			}
		}
	}

}
