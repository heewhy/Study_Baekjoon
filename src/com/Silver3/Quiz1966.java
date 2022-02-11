package com.Silver3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Quiz1966 {

	public static void main(String[] args) {
		// 프린터 큐
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1;tc<=T;tc++) {
			LinkedList<int[]> queue = new LinkedList<>();
			int cnt = 0;
			int size = sc.nextInt();
			int idx = sc.nextInt();
			
			for(int i=0;i<size;i++) {
				queue.add(new int[] {i,sc.nextInt()});
			}
			
			while(!queue.isEmpty()) {
				int[] front = queue.poll();
				boolean check = true;
				
				for(int[] q : queue) {
					if(q[1]>front[1]) {
						check = false;
					}
				}
				if(check) {
					cnt++;
					if(front[0]==idx) break;
				}else {
					queue.add(front);
				}
			}
			System.out.println(cnt);
		}
		
		
		
	}}
