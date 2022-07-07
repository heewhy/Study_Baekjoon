package com.Gold5;

import java.io.*;
import java.util.*;

public class Quiz20055 {
	
	static int N;

	public static void main(String[] args) throws Exception{
		// 컨베이어 벨트 위의 로봇
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 컨베이어 벨트 길이
		int K = Integer.parseInt(st.nextToken()); // 종료 조건 : 내구도가 0인 칸의 개수
		
		int[] belt = new int[(2*N)+1];
		
		st = new StringTokenizer(br.readLine());
		//칸의 내구도 입력
		for(int i=1;i<=2*N;i++) {
			belt[i] = Integer.parseInt(st.nextToken());
		}
		
		//로봇
		boolean[] robot = new boolean[N+1];
		
		int step = 0;
		int end = K;
		while(end>0) {
			end = K;
			step++;
			//로봇을 올리기
			// 1. 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
			moveBelt(robot,belt);
			// 2.가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다. 
			// 만약 이동할 수 없다면 가만히 있는다.
			moveRobot(robot,belt);
			// 3.올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
			if(belt[1]>0) {
				robot[1] = true;
				belt[1]--;
			}
			
			
			// 4.내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다. 그렇지 않다면 1번으로 돌아간다.
			int cnt = countZero(belt);
			
			end-=cnt;
		}
		
		System.out.println(step);
		
		br.close();
	}

	private static void moveBelt(boolean[] robot, int[] belt) {
		belt[0] = belt[2*N];
		for(int i=(2*N)-1;i>=0;i--) {
			belt[i+1] = belt[i];
			
			if(i<N&&robot[i]) {
				robot[i] = false;
				robot[i+1] = true;
			}
		}
	}
	
	private static void moveRobot(boolean[] robot, int[] belt) {
		if(robot[N]) robot[N] = false;
		for(int i=N-1;i>=1;i--) {
			if(!robot[i]) continue;
			
			// 2-1. 로봇이 이동하기 위해서는 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상 남아 있어야 한다.
			if(belt[i+1]<1||robot[i+1]) continue;
			
			robot[i] = false;
			robot[i+1] = true;
			belt[i+1]--;
		}
	}

	private static int countZero(int[] belt) {
		int zeroCnt=0;
		for(int i=1;i<=2*N;i++) {
			if(belt[i]<=0) zeroCnt++;
		}
		return zeroCnt;
	}
}
