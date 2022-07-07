package com.Gold3;

import java.io.*;
import java.util.*;

public class Quiz23288 {
	
	static int N,M,K,dir,cr,cc;
	static int[] dice = {1,2,3,4,5,6};
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	static int[][] map;

	public static void main(String[] args) throws Exception{
		// 주사위 굴리기2
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N+1][M+1];
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dir=0;
		int score = 0;
		int turn = 1;
		cr = 1;
		cc = 1;
		
		while(turn++<=K) {
			cr+=dr[dir];
			cc+=dc[dir];
			
			//주사위가 이동 방향으로 한 칸 굴러간다. 만약, 이동 방향에 칸이 없다면, 
			//이동 방향을 반대로 한 다음 한 칸 굴러간다.
			if(!isInMap(cr,cc)) {
				cr -= dr[dir];
				cc -= dc[dir];
				
				dir = (dir+2)%4;
				cr += dr[dir];
				cc += dc[dir];
			}
			
			//주사위 변화
			changeDice();
			int cnt = bfs();
			
			//주사위가 도착한 칸 (x, y)에 대한 점수를 획득한다.
			score += (cnt*map[cr][cc]);
			
			//주사위의 아랫면에 있는 정수 A와 주사위가 있는 칸 (x, y)에 있는 정수 B를 비교해 이동 방향을 결정
			//A > B인 경우 이동 방향을 90도 시계 방향으로 회전시킨다.
			if(dice[5]>map[cr][cc]) {
				dir = (dir + 1) % 4;
			}
			//A < B인 경우 이동 방향을 90도 반시계 방향으로 회전시킨다.
			else if(dice[5]<map[cr][cc]) {
				dir = (dir==0?3:dir-1);
			}
		}
		
		System.out.println(score);
		
		br.close();
	}


	private static void changeDice() {
		if(dir == 0){
            int temp = dice[0];
            dice[0] = dice[3];
            dice[3] = dice[5];
            dice[5] = dice[2];
            dice[2] = temp;

        } else if(dir == 1){
            int temp = dice[0];
            dice[0] = dice[1];
            dice[1] = dice[5];
            dice[5] = dice[4];
            dice[4] = temp;
        } else if(dir == 2){
            int temp = dice[0];
            dice[0] = dice[2];
            dice[2] = dice[5];
            dice[5] = dice[3];
            dice[3] = temp;
        } else if(dir == 3){
            int temp = dice[0];
            dice[0] = dice[4];
            dice[4] = dice[5];
            dice[5] = dice[1];
            dice[1] = temp;
        }
	}

	private static int bfs() {
		boolean[][] visited = new boolean[N+1][M+1];
        int cnt = 1;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {cr,cc});
        visited[cr][cc] = true;
        
        while (!q.isEmpty()){
            int[] temp = q.poll();
            int r = temp[0];
            int c = temp[1];
            
            for(int d=0;d<4;d++){
                int nr = r + dr[d];
                int nc = c + dc[d];

                if(isInMap(nr,nc)){
                    if(!visited[nr][nc] && map[nr][nc] == map[cr][cc]){
                        visited[nr][nc] = true;
                        cnt++;
                        q.offer(new int[] {nr,nc});
                    }
                }
            }
        }
        return cnt;
	}


	private static boolean isInMap(int r, int c) {
		return 1<=r && r<=N && 1<=c && c<=M;
	}
}
