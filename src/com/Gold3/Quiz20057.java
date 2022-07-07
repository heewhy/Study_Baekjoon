package com.Gold3;

import java.io.*; 
import java.util.*; 

public class Quiz20057 {
	
	static int N;
	static int[][] map;
	static int[] dr = {0,1,0,-1}; //좌하우상
	static int[] dc = {-1,0,1,0};
	static int[][][] wind =
		{
				{{0,-2},{-1,-1},{1,-1},{-1,0},{1,0},{-2,0},{2,0},{-1,1},{1,1}},//좌
				{{2,0},{1,-1},{1,1},{0,-1},{0,1},{0,-2},{0,2},{-1,-1},{-1,1}},//하
				{{0,2},{-1,1},{1,1},{-1,0},{1,0},{-2,0},{2,0},{-1,-1},{1,-1}},//우
				{{-2,0},{-1,-1},{-1,1},{0,-1},{0,1},{0,-2},{0,2},{1,-1},{1,1}},//상
		};
	static double[] per = {0.05,0.1,0.1,0.07,0.07,0.02,0.02,0.01,0.01};

	public static void main(String[] args) throws Exception{
		// 마법사 상어와 토네이도
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] tornado = {N/2,N/2};
		int ans=0;
		int cnt =1;
		int ci=1;
		int dir = 0;
		
		loop:
		while(true) {
			for(int c=0;c<cnt;c++) {
				if(tornado[0]==0&&tornado[1]==0) break loop;
				
				// 1. 토네이도 이동
				tornado[0] += dr[dir];
				tornado[1] += dc[dir];
				
				int send = map[tornado[0]][tornado[1]];
				
				// 3. 있다면 흩어놓기
				int restSend=0;
				for(int d=0;d<9;d++) {
					int nr = tornado[0] + wind[dir][d][0];
					int nc = tornado[1] + wind[dir][d][1];
					
					int curSend = (int) (send * per[d]);
					if(isInMap(nr,nc)) {
						curSend = (int) (send * per[d]);
						map[nr][nc] += curSend;
						restSend += curSend;
					}else {
						ans += curSend;
						restSend += curSend;
					}
				}
				
				int[] alpha = {tornado[0]+dr[dir],tornado[1]+dc[dir]};
				
				if(isInMap(alpha[0],alpha[1])) {
					map[alpha[0]][alpha[1]] += (send - restSend);
				}
				else {
					ans += (send - restSend);
				}
				
				map[tornado[0]][tornado[1]]=0;
				//print();
			}
			
			dir = ++dir%4; 
			if(ci++%2==0) ++cnt;
		}
		
		System.out.println(ans);
		
		br.close();
	}

	private static boolean isInMap(int r, int c) {
		return r>=0&&c>=0&&r<N&&c<N;
	}
	
	private static void print() {
		for(int[] i : map) System.out.println(Arrays.toString(i));
		System.out.println();
	}

}
