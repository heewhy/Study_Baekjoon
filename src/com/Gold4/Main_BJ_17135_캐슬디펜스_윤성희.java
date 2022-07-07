package com.Gold4;

import java.io.*;
import java.util.*;

public class Main_BJ_17135_캐슬디펜스_윤성희 {

	static int N,M,D,ans; //행,열, 궁수 사정거리
	static int[][] map;
	static int[] archers = new int[3];
	
	public static void main(String[] args) throws Exception{
		// 캐슬 디펜스
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		setInArchers(0,0);
		
		System.out.println(ans);
		
		br.close();
	}

	/**
	 * 궁수 배치
	 * @param cnt 배치된 궁수 수
	 * @param start
	 */
	private static void setInArchers(int cnt,int start) {
		if(cnt==3) {
			//print();
			//System.out.println(Arrays.toString(archers));
			int[][] temp = new int[N][M];
			for(int i=0;i<N;i++) {
				temp[i] = map[i].clone();
			}
			
			int killCnt = killEnemy(temp);
			ans = Math.max(ans, killCnt);
			return;
		}
		
		
		for(int i=start;i<M;i++) {
			archers[cnt] = i;
			setInArchers(cnt+1,i+1);
		}
	}

	/**
	 * 배치된 궁수가 적을 죽임
	 * @param temp
	 * @return
	 */
	private static int killEnemy(int[][] temp) {
		Queue<int[]> enemies = new LinkedList<>();
		int cnt = 0;
		int turn =0;
		
		while(turn<N){
			for(int t=0; t<3; t++) {
				int r = N-turn;  
				int c = archers[t]; 
				
				int min = Integer.MAX_VALUE;
				int er = -1;
				int ec = -1;
				for(int i=r-1; i>=0; i--) {
					for(int j=0; j<M; j++) {
						if(temp[i][j] == 1) {
							int dis = getDistance(r, i, c, j);
							//사정거리 안
							if(dis <= D) {
								//가장 가까운 적
								if(dis < min) { 
									min = dis;
									er = i;
									ec = j;
								}
								//왼쪽 우선
								else if(dis == min) { 
									if(ec > j) {
										er = i;
										ec = j;
									}
								}
							}
						}
					}
				}
				//제거할 적 저장 
				if(er!=-1&&ec!=-1) {
					enemies.add(new int[] {er,ec});
				}
				
			}
			//한꺼번에 적 죽이기
			while(!enemies.isEmpty()) {
				int r = enemies.peek()[0];
				int c = enemies.peek()[1];
				enemies.poll();
				
				if(temp[r][c] == 1) {
					temp[r][c] = 0;
					cnt++;
				}
			}
			//print(temp);
			//궁수이동 
			turn++;
		}
		return cnt;
	}

	
	
	private static int getDistance(int r1, int r2, int c1, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }

	private static void print(int[][] t) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++){
				System.out.print(t[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("==================================");
	}

}
