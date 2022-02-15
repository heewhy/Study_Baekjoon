package com.Silver1;

import java.io.*;
import java.util.*;

public class Quiz2961 {

	public static void main(String[] args) throws Exception{
		// 도영이가 만든 맛있는 음식
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int bit = (1<<N);	//비트마스킹
		int[] S = new int[N]; //신맛
		int[] B = new int[N]; //쓴맛
		
		while(N-->0) {
			st = new StringTokenizer(br.readLine());
			S[N] = Integer.parseInt(st.nextToken());
			B[N] = Integer.parseInt(st.nextToken());
		}
		
		// 맛 차이 최소값
		int taste = Integer.MAX_VALUE;
		// 비트 순회
		while(bit-->1) {
			int mul = 1;
			int sum = 0;
			for (int i = 0; i < S.length; i++) {
				if((1<<i & bit) > 0) {
					mul *= S[i];
					sum += B[i];
				}
			}
			taste = Math.min(taste, Math.abs(mul-sum));
		}
		
		sb.append(taste);
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}

}
