package com.Bronze2;

import java.io.*;
import java.util.*;

public class Quiz13300 {

	public static void main(String[] args) throws Exception{
		// 방 배정
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] students = new int[7][2];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());
			
			students[grade][gender]++;
		}
		
		//for(int[] a : students) System.out.println(Arrays.toString(a));
		
		int cnt=0;
		
		for(int i=1;i<7;i++) {
			for(int j=0;j<2;j++) {
				if(students[i][j]>0) {
					cnt++;
				}
				
				while(students[i][j]>K) {
					cnt++;
					students[i][j] = students[i][j]-K;
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
