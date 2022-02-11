package com.Silver4;

import java.io.*;
import java.util.*;

public class Quiz1158 {

	public static void main(String[] args) throws Exception{
		// 요세푸스 문제
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st= new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		//M번째의 요소를 빼기위해서 -1
		int M = Integer.parseInt(st.nextToken())-1;
		
		
		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		for(int i=0;i<N;i++) {
			queue.offer(i+1);
		}
		int cnt = M;
		sb.append("<");
		
		while(!queue.isEmpty()) {
			while(cnt-->0) {
				queue.offer(queue.poll());
			}
			if(queue.size()==1) { //size가 1이면 뒤에 , 를 제거하기위해서
				sb.append(queue.poll());
				break;
			}
			sb.append(queue.poll()+", "); //M번째 요소
			cnt=M;
		}
		sb.append(">");

		bw.write(sb.toString());
				
		
		br.close();
		bw.flush();
		bw.close();
		
		
		

	}

}
