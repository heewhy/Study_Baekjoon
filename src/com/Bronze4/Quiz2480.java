package com.Bronze4;

import java.io.*;
import java.util.*;

public class Quiz2480 {

	public static void main(String[] args) throws Exception{
		// 주사위 세개
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		//세 개의 숫자 입력
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int price = 0;
		
		//3개가 같을 경우
		if(a == b && a == c && b == c)
		{
			price = 10000+(a*1000);
		}
		// a가 2번 반복
		else if(a == b || a == c)
		{
			price = 1000+(a*100);
		}
		// b가 두번 반복
		else if(b == c)
		{
			price = 1000+(b*100);
		}
		// 다 다를경우
		else
		{
			price = Math.max(a, Math.max(b, c))*100;
		}
		
		sb.append(price);
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
		
	}

}
