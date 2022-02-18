package com.Silver5;

import java.io.*;
import java.util.*;

public class Quiz11651 {
	
	public static void main(String[] args) throws Exception{
		// 좌표 정렬하기 2
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb= new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] point = new int[N][2];
		
		for(int i=0;i<N;i++) {
			st= new StringTokenizer(br.readLine());
			point[i][0] = Integer.parseInt(st.nextToken());
			point[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(point, (a,b) ->{
			if(a[1]==b[1]) {
				return a[0]-b[0];
			}else {
				return a[1]-b[1];
			}
		});
		
		//for(int[] a: point)System.out.println(Arrays.toString(a));
		//for(int[] a : point)sb.append(Arrays.toString(a)+"\n");
		
		for(int[] a : point) {
			for(int b : a) {
				sb.append(b+" ");
			}
			sb.append("\n");
		}
		
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();

	}

}
