package com.Bronze1;

import java.io.*;
import java.util.*;

public class Quiz2563 {

	public static void main(String[] args) throws Exception{
		// 색종이
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[100][100]; //흰색 도화지 크기
		int size =10; //크기는 10x10
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			map[n][m]=N+1;
		}
		

		
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				//시작점 발견
				if(map[i][j]>N) {
					for(int k=0;k<10;k++) {
						for(int l=0;l<10;l++) {
							int r = i+k;
							int c = j+l;
							map[r][c]++;
						}
					}
				}
			}
		}
		int cnt=0;
		for(int[] a : map) {
			for(int b : a) {
				if(b>0) {
					cnt++;
				}
			}
		}
		
		sb.append(cnt);
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
		
	}

}
