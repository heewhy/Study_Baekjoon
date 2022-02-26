package com.Silver4;

import java.io.*;
import java.util.*;

public class Quiz9012 {

	public static void main(String[] args) throws Exception{
		// 괄호
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		//입력 데이터 수 받기
		int T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			//데이터 입력 받기
			String str = br.readLine();
			//괄호 ( 저장 공간
			Stack<Character> stack = new Stack<Character>();
			//판별 변수
			boolean check =true;

			for(int i=0;i<str.length();i++) {
				if(str.charAt(i)=='(') {
					//괄호가 열릴 때 넣고
					stack.push(str.charAt(i));
				}
				//괄호가 아닐때 스택이 비어있다면 X
				else if(stack.isEmpty()) {
					check = false;
					break;
				}
				//안비어있다면 빼줘서 짝맞추기
				else {
					stack.pop();
				}
				
			}
			
			if(stack.isEmpty()&&check) sb.append("YES\n");
			else if(!check) sb.append("NO\n");
			else sb.append("NO\n");
			
		}
			
		
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}

}
