package com.Bronze2;

import java.io.*;
import java.util.*;

public class Quiz2309 {

	static int N = 9;
	static int R = 7;
	static int has=0;
	static int[] smalls,numbers;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		// 일곱 난쟁이
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		smalls = new int[N];
		numbers = new int[R];
		
		for(int i=0;i<N;i++) {
			smalls[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(smalls);
		
		Comb(0,0);
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}

	private static void Comb(int cnt, int start) {
		if(has!=0) {
			return;
		}
		
		if(cnt==R) {
			int sum=0;
			for(int a : numbers) {
				sum+=a;
			}
			
			if(sum==100) {
				has++;
				for(int a : numbers) {
					sb.append(a+"\n");
				}
			}
			return;
		}
		
		for(int i=start;i<N;i++) {
			numbers[cnt]=smalls[i];
			Comb(cnt+1,i+1);
		}
		
	}

}
