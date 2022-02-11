package com.Gold5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Quiz2493 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 탑
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		Stack<int[]> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			
			int top = Integer.parseInt(st.nextToken());
			
			//스택이 차있다면 입력 값과 비교해서 idx찍기
			while(!stack.isEmpty()) {
				if(stack.peek()[1]>=top) {
					sb.append(stack.peek()[0]+1).append(" ");
					break;
				}
				stack.pop();
			}
			
			//스택이 비어있다면 0찍기
			if(stack.isEmpty()) {
				sb.append("0 ");
			}
			
			//스택 채우기
			stack.push(new int[] {i,top});
		}
		
		//종료
		//bw.write(sb.toStirng());
		System.out.println(sb.toString());

	}

}
