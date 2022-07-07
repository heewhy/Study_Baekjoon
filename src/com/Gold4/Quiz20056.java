package com.Gold4;

import java.io.*;
import java.util.*;

public class Quiz20056 {
	
	static int N,M,K;
	static int[] dr = {-1,-1,0,1,1,1,0,-1};
	static int[] dc = {0,1,1,1,0,-1,-1,-1};
	static ArrayList<FireBall>[][] map;
	static ArrayList<FireBall> fireBalls;
	
	static class FireBall{
		private int r,c,mass,speed,dir;

		public FireBall(int r, int c, int mass, int speed, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.mass = mass;
			this.speed = speed;
			this.dir = dir;
		}
	}

	public static void main(String[] args) throws Exception{
		// 마법사 상어와 파이어볼
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //맵의 크기
		M = Integer.parseInt(st.nextToken()); //파이어볼의 개수
		K = Integer.parseInt(st.nextToken()); //이동 횟수 
		
		//파이어볼 정보를 담을 list
		fireBalls = new ArrayList<>();
		map = new ArrayList[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j] = new ArrayList<>();
			}
		}
		
		//파이어볼 정보 입력 받기
		while(M-->0) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int mass = Integer.parseInt(st.nextToken());
			int speed = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			
			FireBall fireBall = new FireBall(r,c,mass,speed,dir);
			fireBalls.add(fireBall);
		}
		while(K-->0) {
			//1. 모든 파이어볼이 자신의 방향 di로 속력 si칸 만큼 이동한다.
			//이동하는 중에는 같은 칸에 여러 개의 파이어볼이 있을 수도 있다.
			shootFrieBall();
//			print();
//			break;
			
			//2. 이동이 모두 끝난 뒤, 2개 이상의 파이어볼이 있는 칸에서는 다음과 같은 일이 일어난다.
			consolidate();
		}
		
		int ans=0;
		for(FireBall fireBall : fireBalls) {
			ans += fireBall.mass;
		}
		
		System.out.println(ans);
		
		br.close();
	}

	private static void shootFrieBall() {
		for(FireBall fireBall : fireBalls) {
			int r = fireBall.r;
			int c = fireBall.c;
			int speed = fireBall.speed;
			int dir = fireBall.dir;
			
			//1번 행은 N번과 연결되어 있고, 1번 열은 N번 열과 연결되어 있다.
			int nr = (r + N + dr[dir]*(speed%N)) % N;
			int nc = (c + N + dc[dir]*(speed%N)) % N;
			
			fireBall.r = nr;
			fireBall.c = nc;
			map[nr][nc].add(fireBall);
		}
	}
	
	private static void consolidate() {
		//파이어볼 정보를 담을 list
		fireBalls = new ArrayList<>();
				
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				//빈칸
				if(map[i][j].size()==0) continue;
				
				//한개의 파이어볼 존재
				if(map[i][j].size()==1) {
					fireBalls.add(map[i][j].get(0));
					map[i][j].clear();
					continue;
				}
				
				//1. 같은 칸에 있는 파이어볼은 모두 하나로 합쳐진다.
				int mass=0;
				int speed=0;
				int checkdir = 0;
				for(FireBall fireBall : map[i][j]) {
					//3. 나누어진 파이어볼의 질량, 속력, 방향은 다음과 같다.
						//1. 질량은 ⌊(합쳐진 파이어볼 질량의 합)/5⌋이다.
					mass += fireBall.mass;
						//2. 속력은 ⌊(합쳐진 파이어볼 속력의 합)/(합쳐진 파이어볼의 개수)⌋이다.
					speed += fireBall.speed;
						//3. 합쳐지는 파이어볼의 방향이 모두 홀수이거나 모두 짝수이면, 방향은 0, 2, 4, 6이 되고, 그렇지 않으면 1, 3, 5, 7이 된다.
					if(fireBall.dir%2==0) {
						checkdir+=1;
					}
				}
				//2. 파이어볼은 4개의 파이어볼로 나누어진다.
				mass/=5;
				int size = map[i][j].size();
				map[i][j].clear();
				
				//4. 질량이 0인 파이어볼은 소멸되어 없어진다.
				if(mass==0) continue;
				
				speed/=size;
				int dir=1;
				if(checkdir==0||checkdir==size) dir=0;
				
				for(;dir<8;dir+=2) {
					fireBalls.add(new FireBall(i,j,mass,speed,dir));
				}
				
				//print();
			}
		}
	}
	
	private static void print() {
		for(int i=0; i< fireBalls.size();i++) {
			FireBall fireBall = fireBalls.get(i);
			
			int r = fireBall.r;
			int c = fireBall.c;
			int speed = fireBall.speed;
			int dir = fireBall.dir;
			System.out.println(r+" "+c+" "+fireBall.mass+" "+speed+" "+dir);
		}
	}

}
