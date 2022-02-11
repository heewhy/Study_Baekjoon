package com.Silver3;

import java.io.*;
import java.util.*;


public class Quiz1874 {

	
	
	public static void main(String[] args) throws Exception{
		// 스택 수열
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		//수열의 수만큼 배열에 자연수 생성
//		int[] arr = new int[N];
		//int[] answer = new int[N];
//		for(int i=0; i<N;i++) {
//			arr[i]=i+1;
//			answer[i] = Integer.parseInt(br.readLine());
//		}
		
		
//		for(int i=0;i<answer[0];i++) {
//			stack.push(arr[i]);
//			sb.append('+'+"\n");
//		}
//		
//		if(stack.peek()==answer[0]) {
//			stack.pop();
//			sb.append('-'+"\n");
//		}
//		
//		if(stack.peek()<answer[1]) {
//			while(stack.peek()!=answer[1]) {
//				stack.pop();
//				sb.append('-'+"\n");
//			}
//			if(stack.peek()==answer[1]) {
//				stack.pop();
//				sb.append('-'+"\n");
//			}			
//		}else {
//			for(int i=answer[0]-1;i<answer[1];i++) {
//				stack.push(arr[i]);
//				sb.append('+'+"\n");
//			}
//		}
		
		//수열의 수 입력
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();

		int start = 0;
		boolean check = true;
		
		while(N-- > 0) {
			
			int num = Integer.parseInt(br.readLine());
			
			if(num >start) {
				// start 부터 입력받은 value 까지 push를 한다.
				for(int i = start+1 ; i <= num; i++) {
					stack.push(i);
					sb.append('+').append('\n');	
				}
				start = num; 	// 출발 재조정
			}else if(stack.peek() != num) {  
				System.out.println("NO");
				return;
			}
			
			stack.pop();
			sb.append('-').append('\n');
			
		}
		
		bw.write(sb.toString());
		

		
		br.close();
		bw.flush();
		bw.close();
		
	}

}
