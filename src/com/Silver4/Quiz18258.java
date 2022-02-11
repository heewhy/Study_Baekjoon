package com.Silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Quiz18258 {

	public static void main(String[] args) throws IOException {
		// 큐2
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<>();
		int temp=0;
		
		for(int i=0; i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a=0;
			String cmd="";
			
			if(st.countTokens()>1) {
				cmd = st.nextToken();
				a = Integer.parseInt(st.nextToken());
			}else cmd = st.nextToken();
			
			if(cmd.equals("push")) {
				queue.offer(a);
				temp=a;
			}else if(cmd.equals("pop")) {
				
				if(queue.peek()!=null) {
					System.out.println(queue.poll());
				}else System.out.println(-1);
				
			}else if(cmd.equals("size")) {
				System.out.println(queue.size());
			}else if(cmd.equals("empty")) {
				if(queue.isEmpty()) {
					System.out.println(1);
				}else System.out.println(0);
			}else if(cmd.equals("front")) {
				try {
					System.out.println(queue.peek());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println(-1);
				}
			}else if(cmd.equals("back")) {
				try {
					System.out.println(temp);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println(-1);
				}
			}
			
		}
	}

}
