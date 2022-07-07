package com.Gold3;

import java.io.*;
import java.util.*;

public class Quiz19238 {
	
	static int N,M,fuel;
	static int[][] map;
	static int[][] time;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	static class Guest{
		boolean isArrive;
		int r,c,Fr,Fc,distance;

		public Guest(boolean isArrive,int r, int c, int fr, int fc) {
			super();
			this.isArrive = isArrive;
			this.r = r;
			this.c = c;
			this.Fr = fr;
			this.Fc = fc;
		}
	}
	static Guest[] guests;

	public static void main(String[] args) throws Exception{
		// 스타트 택시
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //맵의 크기
		M = Integer.parseInt(st.nextToken()); //승객의 수
		fuel = Integer.parseInt(st.nextToken()); //연료총량
		
		//맵 정보 입력 받기
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//택시 정보 입력 받기
		int taxiR=0;
		int taxiC=0;
		st = new StringTokenizer(br.readLine());
		taxiR = Integer.parseInt(st.nextToken())-1;
		taxiC = Integer.parseInt(st.nextToken())-1;
		map[taxiR][taxiC] = -1;
		
		//승객 정보 입력받기
		guests = new Guest[M];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int Fr = Integer.parseInt(st.nextToken())-1;
			int Fc = Integer.parseInt(st.nextToken())-1;
			Guest guest = new Guest(false,r,c,Fr,Fc);
			guests[i] = guest;
		}
		
		if(moveTaxi(taxiR,taxiC)) System.out.println(fuel);
		else System.out.println(-1);
		
		br.close();
	}

	/**
	 * 택시가 움직임
	 * @param r 택시 행 좌표
	 * @param c 택시 열 좌표
	 * @return 연료안에 운전이 가능한지 여부
	 */
	private static boolean moveTaxi(int r, int c) {
		
		for(int i=0;i<M;i++) {
			//모든 칸의 시간 계산
			getMoveTaxiTime(r,c);
			
			int min = Integer.MAX_VALUE;
			int minGuestNum = -1;
			//가까운 손님 탐색
			for(int num=0;num<M;num++) {
				Guest guest = guests[num];
				if(guest.isArrive) continue;
				
				int distance = time[guest.r][guest.c];
				
				guest.distance = distance;
				if(min > distance) {
					min = Math.min(distance, min);
					minGuestNum = num;
				}
				else if(min == distance) {
					Guest minGuest = guests[minGuestNum];
					if(minGuest.r>guest.r) {
						minGuestNum = num;
					}
					else if (minGuest.r==guest.r) {
						if(minGuest.c>guest.c) {
							minGuestNum = num;
						}
					}
				}
			}
			
			
			Guest curGuest = guests[minGuestNum];
			
			//갈 수 없는 경우
			if(min==0&&(r!=curGuest.r||c!=curGuest.c)) return false;
				
			//택시 좌표 초기화
			map[r][c] = 0;
			r = curGuest.r;
			c = curGuest.c;
			
			//택시 이동 및 손님까지 거리 연료 빼기
			map[r][c] = -1;
			fuel -= min;
			if(fuel<0) return false;
			
			//타자마자 내리는 경우
			if(curGuest.r==curGuest.Fr&&curGuest.c==curGuest.Fc) continue;
			
			//손님 좌표에서 모든 시간 계산
			getMoveTaxiTime(r, c);
			
			//연료가 모자라거나 도달하지 못하는 경우
			if(time[curGuest.Fr][curGuest.Fc]==0||fuel-time[curGuest.Fr][curGuest.Fc]<0) return false;
			
			//손님 도착 처리
			map[r][c] = 0;
			r = curGuest.Fr;
			c = curGuest.Fc;
			curGuest.isArrive = true;
			
			//연료 더하기
			map[r][c] = -1;
			fuel+=time[curGuest.Fr][curGuest.Fc];
			
		}
		return true;
 	}

	/**
	 * BFS
	 * @param r 시작 행 좌표
	 * @param c 시작 열 좌표
	 */
	private static void getMoveTaxiTime(int r, int c) {
		int[][] clone = new int[N][N];
		for(int i=0;i<N;i++) {
			clone[i] = map[i].clone();
		}
		time = new int[N][N];
		
		
		LinkedList<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {r,c,1});
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			int cr = temp[0];
			int cc = temp[1];
			int depth = temp[2];
			
			for(int d=0;d<4;d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				//경계 안에 있고, 0인 경우
				if(isInMap(nr,nc)&&clone[nr][nc]==0) {
					clone[nr][nc] = -1;
					time[nr][nc] = depth;
					q.add(new int[] {nr,nc,depth+1});
				}
			}
		}
	}

	/**
	 * 경계 체크
	 * @param nr 검사할 행 좌표
	 * @param nc 검사할 열 좌표
	 * @return 경계 안에 있는 여부
	 */
	private static boolean isInMap(int nr, int nc) {
		return nr>=0&&nc>=0&&nr<N&&nc<N;
	}

}
