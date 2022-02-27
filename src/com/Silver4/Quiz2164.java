package com.Silver4;

import java.io.*;
import java.util.*;

public class Quiz2164 {

	public static void main(String[] args) throws Exception{
		// 카드2
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		//정수 N 입력 받기
		int N = Integer.parseInt(br.readLine());
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		//1~N 넣기
		for(int i=1;i<=N;i++) {
			list.offer(i);
		}
		
		//하나 남을 때 까지
		while(list.size()!=1) {
			//처음 하나를빼고
			list.poll();
			//두번째꺼를 맨 뒤로
			list.offer(list.poll());
		}
		
		sb.append(list.poll());
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}

}
