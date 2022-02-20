package com.Silver4;

import java.io.*;
import java.util.*;

public class Quiz2477 {

	public static void main(String[] args) throws Exception{
		// 참외밭
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		//참외의 개수
		int K = Integer.parseInt(st.nextToken());
		int max = 0;
		int sum = 0;
		
		st = new StringTokenizer(br.readLine());
		st.nextToken();
		//길이
		int first = Integer.parseInt(st.nextToken());
		int pre = first;
		for(int i = 1 ; i < 6 ; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			int now = Integer.parseInt(st.nextToken());
			max = Math.max(now*pre, max);
			sum += now*pre;
			pre = now;
		}
		max = Math.max(first*pre, max);
		sum += first*pre;
		int result = (max - ((max*3)-sum))*K;
		sb.append(result);
		
		bw.write(sb.toString());
		
		
		
		
		br.close();
		bw.flush();
		bw.close();
	}

}
