package com.Gold3;

import java.io.*;
import java.util.*;

public class Quiz17822 {

	static int N,M,T,total;
	static int[][] circlePlate;
	static int[] dr = {-1,0,1,0}; //상우하좌
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception{
		// 원판 돌리기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //원판의 개수
		M = Integer.parseInt(st.nextToken()); //원판에 적힌 숫자의 개수
		T = Integer.parseInt(st.nextToken()); //회전 수
		
		circlePlate = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				circlePlate[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<T;i++) {
			st = new StringTokenizer(br.readLine());
			//배수가될 번호
			int num = Integer.parseInt(st.nextToken());
			//방향
			int dir = Integer.parseInt(st.nextToken());
			//칸 횟수
			int cnt = Integer.parseInt(st.nextToken());
			
			//정보대로 회전
			turnPlate(num,dir,cnt);
			
			//원판 정보 정리
			updatePlate();
			
		}
		
		//for(int[] i : circlePlate)System.out.println(Arrays.toString(i));
		
		int ans = getPoint();
		
		System.out.println(ans);
		
		br.close();
	}

	/**
	 * 원판 합 구하기
	 * @return 원판의 합
	 */
	private static int getPoint() {
		int sum=0;
		total=0;
		for(int[] i : circlePlate) {
			for(int j : i) {
				if(j==0) continue;
				sum+=j;
				total++;
			}
		}
		
		return sum;
	}

	/**
	 * 원판 정보 갱신
	 */
	private static void updatePlate() {
		List<int[]> savePoint = new ArrayList<int[]>();
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				
				if(circlePlate[i][j]==0) continue;
				
				for(int d=0;d<4;d++) {
					int r = i + dr[d];
					int c = j + dc[d];
					
					if(c<0) {
						c=M-1;
					}
					else if(c>=M) {
						c=0;
					}
					
					if(r>=0&&r<N&&circlePlate[i][j]==circlePlate[r][c]) {
						savePoint.add(new int[] {i,j});
						savePoint.add(new int[] {r,c});
					}
				}
			}
		}
		
		if(!savePoint.isEmpty()) {
			
			for(int i=0;i<savePoint.size();i++) {
				int[] temp = savePoint.get(i);
				int r = temp[0];
				int c = temp[1];
				
				circlePlate[r][c]=0;
			}
			
		}else {
			int sum = getPoint();
			double avg = (1.0*sum)/total;
			
			//System.out.println(avg);
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					
					if(circlePlate[i][j]==0) continue;
					if(circlePlate[i][j]==avg)continue;
					
					if(circlePlate[i][j]>avg) {
						--circlePlate[i][j];
					}
					else {
						++circlePlate[i][j];
					}
				}
			}
		}
		
	}
	
	/**
	 * 원판 돌리기
	 * @param num 배수가 될 번호
	 * @param dir 방향 0: 시계방향 1: 반시계방향
	 * @param cnt 회전 횟수
	 */
	private static void turnPlate(int num, int dir, int cnt) {
		for(int i=0;i<N;i++) {
			if((i+1)%num==0) {
				//시계 방향
				if(dir==0) {
					for(int j=0;j<cnt;j++) {
						int temp=circlePlate[i][M-1];
						for(int k=M-1;k>=1;k--) {
							circlePlate[i][k] = circlePlate[i][k-1];
						}
						circlePlate[i][0] = temp;
					}
				}
				//반시계 방향
				else {
					for(int j=0;j<cnt;j++) {
						int temp=circlePlate[i][0];
						for(int k=0;k<M-1;k++) {
							circlePlate[i][k] = circlePlate[i][k+1];
						}
						circlePlate[i][M-1] = temp;
					}
				}
			}
		}
	}

}
