package com.Bronze1;

import java.io.*;
import java.util.*;

public class Quiz1259 {

	public static void main(String[] args) throws Exception{
		// 팰린드롬수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		
		while(true) {
			String s = br.readLine();
			LinkedList<Character> list = new LinkedList<>();
			if(s.charAt(0)-'0'==0) break;
			
			for(int i=0;i<s.length();i++) {
				list.add(s.charAt(i));
			}
	
			boolean check = true;
			
			while(list.size()>1) {
				int a = list.poll();
				int b = list.pollLast();
				//System.out.println("a :"+a);
				//System.out.println("b :"+b);
				//System.out.println("list size :"+list.size());
				if(a==b) {
					continue;
				}else {
					check=false;
					break;
				}
			}
			
			//System.out.println("check :"+check);
			if(check) {
				sb.append("yes\n");
			}else{
				sb.append("no\n");
			}
			
		}
		
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();	
	}

}
