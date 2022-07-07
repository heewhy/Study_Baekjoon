package com.Gold5;

import java.io.*;
import java.util.*;

public class Quiz21610 {
	
	static class Cloud{
		int r,c,dir,speed;

		public Cloud(int r, int c, int dir, int speed) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
			this.speed = speed;
		}
	}
	
	static int N,M;
	static int[][] map;
	static int[] dr = {0,-1,-1,-1,0,1,1,1};
	static int[] dc = {-1,-1,0,1,1,1,0,-1};
	
	public static void main(String[] args) throws Exception{
		// 마법사 상어와 비바라기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean[][] isDisappearCloud = new boolean[N][N];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken())-1;
			int speed = Integer.parseInt(st.nextToken());
			
			ArrayList<Cloud> clouds = createCloud(i,dir,speed,isDisappearCloud);
			//System.out.println("구름생성");
			//print();
			isDisappearCloud = new boolean[N][N];
			moveCloud(clouds,isDisappearCloud);
			//System.out.println("구름이동");
			//print();
			increseWater(clouds);
			//System.out.println("물 증가");
			//print();
		}
		
		createCloud(M,0,0,isDisappearCloud);
		
		System.out.println(getTotalWater());
		
		br.close();
	}

	private static ArrayList<Cloud> createCloud(int i, int dir, int speed, boolean[][] isDisappearCloud) {
		ArrayList<Cloud> clouds = new ArrayList<>();
		if(i==0) {
			Cloud cloud1 = new Cloud(N-1,0,dir,speed);
			Cloud cloud2 = new Cloud(N-1,1,dir,speed);
			Cloud cloud3 = new Cloud(N-2,0,dir,speed);
			Cloud cloud4 = new Cloud(N-2,1,dir,speed);
			
			clouds.add(cloud1);
			clouds.add(cloud2);
			clouds.add(cloud3);
			clouds.add(cloud4);
			
			return clouds;
		}
		
		for(int r=0;r<N;r++) {
			for(int c=0;c<N;c++) {
				if(isDisappearCloud[r][c]||map[r][c]<2) continue;
				
				map[r][c] -=2;
				Cloud cloud = new Cloud(r,c,dir,speed);
				clouds.add(cloud);
			}
		}
		
		return clouds;
	}

	private static void moveCloud(ArrayList<Cloud> clouds, boolean[][] isDisappearCloud) {
		for(Cloud cloud : clouds) {
			int r = cloud.r;
			int c = cloud.c;
			int dir = cloud.dir;
			int speed = cloud.speed;
			
			int nr = (r + N + dr[dir]*(speed%N)) % N;
			int nc = (c + N + dc[dir]*(speed%N)) % N;
			
			cloud.r = nr;
			cloud.c = nc;
			map[nr][nc]++;
			isDisappearCloud[nr][nc] = true;
		}
	}
	
	private static void increseWater(ArrayList<Cloud> clouds) {
		for(Cloud cloud :clouds) {
			int r = cloud.r;
			int c = cloud.c;
			
			int cnt=0;
			for(int d=1;d<8;d+=2) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(isInMap(nr,nc)&&map[nr][nc]>0) cnt++;
			}
			
			map[r][c] += cnt;
		}
	}

	private static boolean isInMap(int r, int c) {
		return r>=0&&c>=0&&r<N&&c<N;
	}

	private static int getTotalWater() {
		int total=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				total+=map[i][j];
			}
		}
		return total;
	}
	
	private static void print() {
		for(int[] i : map) System.out.println(Arrays.toString(i));
		System.out.println("============================");
	}

}
