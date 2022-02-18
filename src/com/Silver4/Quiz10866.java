package com.Silver4;

import java.io.*;
import java.util.*;

public class Quiz10866 {

	public static void main(String[] args) throws Exception{
		// 덱
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb= new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		LinkedList<Integer> list = new LinkedList<>();
		
		while(N-->0) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			
			switch (cmd) {
			case "push_front":
				list.addFirst(Integer.parseInt(st.nextToken()));
				break;
			case "push_back":
				list.addLast(Integer.parseInt(st.nextToken()));
				break;
			case "pop_front":
				if(!list.isEmpty()) {
					sb.append(list.pollFirst()+"\n");
				}else {
					sb.append(-1+"\n");
				}
				break;
			case "pop_back":
				if(!list.isEmpty()) {
					sb.append(list.pollLast()+"\n");
				}else {
					sb.append(-1+"\n");
				}
				break;
			case "size":
				sb.append(list.size()+"\n");
				break;
			case "empty":
				if(list.isEmpty()) {
					sb.append(1+"\n");
				}else {
					sb.append(0+"\n");
				}
				break;

			case "front":
				if(!list.isEmpty()) {
					sb.append(list.peekFirst()+"\n");
				}else {
					sb.append(-1+"\n");
				}
				break;
			case "back":
				if(!list.isEmpty()) {
					sb.append(list.peekLast()+"\n");
				}else {
					sb.append(-1+"\n");
				}
				break;

			}
			
		}
		

		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}

}
