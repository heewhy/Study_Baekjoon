package com.Bronze1;

import java.io.*;
import java.util.*;

public class Quiz2669 {

	public static void main(String[] args) throws Exception{
		// 직사각형 네개의 합집합의 면적 구하기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int[][] map = new int[101][101];
		int cnt=0;
		
		for(int T=0;T<4;T++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			
			for(int i=r;i<p;i++) {
				for(int j=c;j<q;j++) {
					map[i][j]++;
				}
			}
		}
		
		//for(int[] a : map)System.out.println(Arrays.toString(a));
		
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
