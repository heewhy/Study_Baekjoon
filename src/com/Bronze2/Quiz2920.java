package com.Bronze2;

import java.io.*;
import java.util.*;

public class Quiz2920 {

	public static void main(String[] args) throws Exception{
		// 음계
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = 8; // 주어지는 숫자의 개수
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int sum=0;
		for(int i=0;i<N-1;i++) {
			if(arr[i]<arr[i+1]) {
				sum++;
			}else if(arr[i]>arr[i+1]) {
				sum--;
			}
		}
		
		if(sum==7) {
			sb.append("ascending");
		}else if(sum==-7) {
			sb.append("descending");
		}else {
			sb.append("mixed");
		}
		
		bw.write(sb.toString());
		
		
		br.close();
		bw.flush();
		bw.close();
		

	}

}
