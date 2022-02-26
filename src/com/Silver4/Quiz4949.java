package com.Silver4;

import java.io.*;
import java.util.*;

public class Quiz4949 {

	public static void main(String[] args) throws Exception{
		// 균형잡힌 세상
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
			
		while(true) {
			//한줄 입력받기
			String str = br.readLine();
			//.이면 탈출
			if(str.equals(".")) break;
			
			
			//공백 제거
			str = str.trim();
			Stack<Character> stack = new Stack<Character>();
			boolean check = true;
			
			for(int i=0;i<str.length();i++) {
				char temp = str.charAt(i);
				if(temp=='('||temp=='[') {
					stack.push(temp);
				}
				
				else if(temp==')') {
					if(stack.isEmpty()||stack.peek()!='(') {
						check = false;
						break;
					}else {
						stack.pop();
					}
					
				}
				
				else if(temp==']') {
					if(stack.isEmpty()||stack.peek()!='[') {
						check = false;
						break;
					}else {
						stack.pop();
					}
				}
			}
			
			if(stack.isEmpty()&&check) sb.append("yes\n");
			else if(!check||!stack.isEmpty()) sb.append("no\n");
		}
		
		bw.write(sb.toString());
		
		
		br.close();
		bw.flush();
		bw.close();
	}

	
	
}
