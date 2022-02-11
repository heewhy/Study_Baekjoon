package com.Bronze5;

import java.io.*;
import java.util.*;

public class Quiz2475 {

	public static void main(String[] args) throws Exception{
		// 검증수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = 5; //숫자자리
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		int sum=0;
		for(int i=0;i<N;i++) {
			sum+=(int)Math.pow(arr[i], 2);
		}
		
		sb.append(sum%10);
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}

}
