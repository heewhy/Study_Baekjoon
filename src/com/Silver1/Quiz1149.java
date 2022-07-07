package com.Silver1;

import java.io.*;
import java.util.*;

public class Quiz1149 {

	public static void main(String[] args) throws Exception{
		// RGB 거리
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	
		int N = Integer.parseInt(br.readLine());
		
		//각 번호의 집을 칠할 때 색에 따른 비용 입력
		int[][] colors = new int[N+1][3];
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				colors[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//동적 테이블
		//0: 빨강, 1: 초록, 2:파랑
		//d[i][1] - i개 집을 칠할 때 i번째 집을 초록색으로 칠하는 최소비용
		int[][] d = new int[N+1][3];
		
//		d[1][0] = colors[1][0];
//		d[1][1] = colors[1][1];
//		d[1][2] = colors[1][2];
		
		//i를 1부터해도 같음
		for(int i=1;i<=N;i++) {
			
			//i개 집을 칠할 때 i번째 집을 빨강으로 칠할 때 최소비용
			d[i][0] = Math.min(d[i-1][1], d[i-1][2])+colors[i][0];
			
			//i개 집을 칠할 때 i번째 집을 초록으로 칠할 때 최소비용
			d[i][1] = Math.min(d[i-1][0], d[i-1][2])+colors[i][1];
			
			//i개 집을 칠할 때 i번째 집을 파랑으로 칠할 때 최소비용
			d[i][2] = Math.min(d[i-1][0], d[i-1][1])+colors[i][2];
			
		}
		
		//f(n) = 최소 값
		System.out.println(Math.min(d[N][0], Math.min(d[N][1], d[N][2])));
		
		br.close();
	}

}
