package com.Silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Quiz10828 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 스택
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0; i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a=0;
			String cmd="";
			if(st.countTokens()>1) {
				cmd = st.nextToken();
				a = Integer.parseInt(st.nextToken());
			}else cmd = st.nextToken();
			
			if(cmd.equals("push")) {
				stack.push(a);
			}else if(cmd.equals("pop")) {
				try {
					System.out.println(stack.pop());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println(-1);
				}
				
			}else if(cmd.equals("size")) {
				System.out.println(stack.size());
			}else if(cmd.equals("empty")) {
				if(stack.isEmpty()) {
					System.out.println(1);
				}else System.out.println(0);
			}else if(cmd.equals("top")) {
				try {
					System.out.println(stack.peek());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println(-1);
				}
			}
		}
		
	}

}
