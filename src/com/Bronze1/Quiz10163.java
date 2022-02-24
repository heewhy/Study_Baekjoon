package com.Bronze1;

import java.io.*;
import java.util.*;

public class Quiz10163 {

	public static void main(String[] args) throws Exception{
		// 색종이
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[1002][1002];
		int temp = N;
		int cnt=1;
		
		while(N-->0) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int width = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			
			for(int i=0;i<height;i++) {
				for(int j=0;j<width;j++) {
					map[r+height][c+width]=cnt;
				}
			}
			
			cnt++;
		}
		
		int[] ans=new int[temp+1];
		
		for(int[] b : map) {
			for(int a : b) {
				ans[a]++;
			}
		}
		
		System.out.println(Arrays.toString(ans));
		
		for(int i=1;i<ans.length;i++) {
			int num = ans[i];
			sb.append(num+"\n");
		}
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}

}
