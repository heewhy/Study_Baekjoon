package com.Silver1;

import java.io.*;
import java.util.*;

public class Quiz14888 {

	static int N,max,min;
	static int[] input,operator;
	
	public static void main(String[] args) throws Exception{
		// 연산자 끼워넣기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		input = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		operator = new int[4];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<4;i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}
		
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		
		//findVal(0,0);
		//findVal(input[0],0); 결과를 거치지않음
		findVal(input[0],1);
		
		sb.append(max+"\n"+min+"\n");
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}

	private static void findVal(int result,int cnt) {
		//숫자를 다 활용 했을 때
		if(cnt == N) {
			max = Math.max(max,result);
			min = Math.min(min,result);
			//System.out.println("결과체크");
			return;
		}
		
		for(int i=0;i<4;i++) {
			
			if(operator[i]>0) {
				
				operator[i]--;
				
				switch (i) {
				//+
				case 0:
					findVal(result+input[cnt], cnt+1);
					break;
				//-
				case 1:
					findVal(result-input[cnt], cnt+1);
					break;
				//*
				case 2:
					//System.out.println("경로체크");
					findVal(result*input[cnt], cnt+1);
					break;
				//나눗셈
				case 3:
					findVal(result/input[cnt], cnt+1);
					break;

				}
				
				operator[i]++;
			}
			
		}
		
		
	}

}
