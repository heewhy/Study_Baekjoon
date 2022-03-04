package com.Silver3;

import java.io.*;
import java.util.*;

public class Quiz2108 {

	public static void main(String[] args) throws Exception{
		// 통계학
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		int sum=0;
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum+=arr[i];
		}
		
		sb.append(sum/N+"\n");
		Arrays.sort(arr);
		sb.append(arr[N/2]+"\n");
		
		sb.append(arr[N-1]-arr[0]+"\n");
		
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}

}
