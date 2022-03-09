package com.Gold4;

import java.io.*;
import java.util.*;

public class Quiz14499 {

	public static void main(String[] args) throws Exception{
		// 주사위 굴리기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		//주사위 정보를 어떻게 저장?
		//1 3 6 4  1 5 6 2
		//주사위 굴리기
		//숫자라면 주사위 바닥면으로 복사
		//바깥으로 이동시키려고하면 해당명령 무시
		
		LinkedList<Integer> dice = new LinkedList<Integer>();
		dice.add(0);
		dice.add(0);
		dice.add(0);
		dice.add(0);
		int left_temp = 0;
		int right_temp = 0;
		
		st = new StringTokenizer(br.readLine());
		
		//지도의 세로크기
		int N = Integer.parseInt(st.nextToken());
		//지도의 가로크기
		int M = Integer.parseInt(st.nextToken());
		//주사위 시작 x 좌표
		int x = Integer.parseInt(st.nextToken());
		//주사위 시작 y 좌표
		int y = Integer.parseInt(st.nextToken());
		//명령의 개수
		int K = Integer.parseInt(st.nextToken());
		
		//map 생성
		int[][] map = new int[N][M];
		
		//map 정보
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//주사위 이동방향 동서북남
		int[] dr = {0,0,-1,1};
		int[] dc = {1,-1,0,0};
		
		//주사위 현재 좌표
		int cr = x;
		int cc = y;
		
		int check=0;
		
		st = new StringTokenizer(br.readLine());
		while(K-->0) {
			int dir = Integer.parseInt(st.nextToken());
			
			int nr = cr+dr[dir];
			int nc = cc+dc[dir];
			
			//굴림
			if(nr>=0&&nc>=0&&nr<N&&nc<M) {
				//주사위준비
				if(check<=2&&dir>2) {
					if(dir==3) {
						
					}else {
						
					}
					
				}else if(check>2&&dir<=2){
					if(dir==1) {
						
					}else {
						
					}
				}

				cr = nr;
				cc = nc;
				
				dice.addLast(dice.poll());
				
				if(map[cr][cc]!=0) {
					dice.peekFirst();
					dice.addFirst(map[cr][cc]);
					map[cr][cc] = 0;
				}
			}
			
			sb.append(dice.get(2)+"\n");
			check=dir;
		}
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}

}
