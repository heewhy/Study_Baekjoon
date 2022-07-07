package com.Silver3;

import java.io.*;
import java.util.*;


public class Quiz3085 {

	static int N,ans;
	static char[][] map;
	
	public static void main(String[] args) throws Exception{
		// 사탕 게임
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		findMaxEatCandy();
		
		System.out.println(ans);
		
		br.close();
	}

	/**
	 * 모든 경우의 수(브루트포스)를 탐색하며 최대 사탕 개수 갱신
	 */
	private static void findMaxEatCandy() {
		
		check(map);
		if(ans==N) return;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N-1;j++) {
				//다르다
				if(map[i][j]!=map[i][j+1]) {
					swapRowCandy(i,j);
				}
				if(map[j][i]!=map[j+1][i]) {
					swapColCandy(j,i);
				}
			}
		}
		
	}

	/**
	 * 현재 최대 먹을 수 있는 사탕 개수 세기
	 * @param clone 복제배열
	 */
	private static void check(char[][] clone) {
		for(int i=0;i<N;i++) {
			int max=0;
			int colcnt=1;
			for(int j=0;j<N-1;j++) {
				if(clone[i][j]==clone[i][j+1]) {
					colcnt++;
					max = Math.max(max, colcnt);
				}else {
					colcnt=1;
				}
			}
			ans = Math.max(ans, max);
		}
		for(int i=0;i<N;i++) {
			int max=0;
			int rowcnt=1;
			for(int j=0;j<N-1;j++) {
				if(clone[j][i]==clone[j+1][i]) {
					rowcnt++;
					max = Math.max(max, rowcnt);
				}else {
					rowcnt=1;
				}
			}
			ans = Math.max(ans, max);
		}
	}

	/**
	 * 행 바꾸기
	 * @param r 바꿀 행
	 * @param c 바꿀 열
	 */
	private static void swapRowCandy(int r, int c) {
		char[][] clone = new char[N][N];
		for(int i=0;i<N;i++) {
			clone[i] = map[i].clone();
		}
		
		char temp = clone[r][c];
		clone[r][c] = clone[r][c+1];
		clone[r][c+1] = temp;
		
		check(clone);
	}
	
	/**
	 * 열 바꾸기
	 * @param r 바꿀 행
	 * @param c 바꿀 열
	 */
	private static void swapColCandy(int r, int c) {
		char[][] clone = new char[N][N];
		for(int i=0;i<N;i++) {
			clone[i] = map[i].clone();
		}
		
		char temp = clone[r][c];
		clone[r][c] = clone[r+1][c];
		clone[r+1][c] = temp;
		
		check(clone);
	}
	
	

}
