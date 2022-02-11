package com.Bronze5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Quiz10926 {

	public static void main(String[] args) throws IOException {
		// ??!
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		String s = br.readLine();
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(s).append("??!");
		
		System.out.println(sb.toString());

	}

}

/*
  	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언

	String s = bf.readLine(); //String
	int i = Integer.parseInt(bf.readLine()); //Int
	
	StringTokenizer st = new StringTokenizer(s); //StringTokenizer인자값에 입력 문자열 넣음
	int a = Integer.parseInt(st.nextToken()); //첫번째 호출
	int b = Integer.parseInt(st.nextToken()); //두번째 호출

	String array[] = s.split(" "); //공백마다 데이터 끊어서 배열에 넣음
*/