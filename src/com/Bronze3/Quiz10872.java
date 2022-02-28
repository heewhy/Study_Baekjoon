package com.Bronze3;

import java.io.*;
import java.util.*;

public class Quiz10872 {

	public static void main(String[] args) throws Exception{
		// 팩토리얼
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		//정수 입력 받기
		int N = Integer.parseInt(br.readLine());
		
		sb.append(factorial(N));
		
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}

	private static int factorial(int n) {
		if(n==0||n==1) return 1;
		return n*factorial(n-1);
	}

}
