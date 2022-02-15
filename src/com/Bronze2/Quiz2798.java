package com.Bronze2;

import java.io.*;
import java.util.*;

public class Quiz2798 {
	
	static int N,R,M,check,answer;
	static int[] card,result;

	public static void main(String[] args) throws Exception{
		// 블랙잭
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		//카드의 숫자
		N = Integer.parseInt(st.nextToken());
		card = new int[N];
		//기준 숫자
		M = Integer.parseInt(st.nextToken());
		//고르는 숫자
		R = 3;
		result = new int[R];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		
		check=Integer.MAX_VALUE;
		comb(0,0);
		
		sb.append(answer);
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}

	private static void comb(int cnt, int start) {
		
		if(cnt==R) {
//			System.out.print(Arrays.toString(result));
//			System.out.println();
			int sum=0;
			for(int i: result) {
				sum+=i;
				//System.out.println(sum);
			}
			if(sum<=M&&check>M-sum) {
				check = Math.min(check, M-sum);
				answer = sum;
				
			}
			
			return;
		}
		for(int i=start;i<N;i++) {
			result[cnt] = card[i];
			comb(cnt+1,i+1);
		}
		
	}

}
