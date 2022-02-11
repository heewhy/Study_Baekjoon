package com.Silver4;

import java.io.*;
import java.util.*;

public class Quiz1021 {

	public static void main(String[] args) throws Exception{
		// 회전하는 큐
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		//큐의 크기
		int N = Integer.parseInt(st.nextToken());
		int cnt = Integer.parseInt(st.nextToken());
		int[] val = new int[cnt]; 
		int result=0;
		
		LinkedList<Integer> q = new LinkedList<>();
		//Deque<Integer> queue = ArrayDeque<Integer>();
		for(int i=1;i<=N;i++) {
			q.offer(i);
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<cnt;i++) {
			val[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i=1; i <= cnt; i++) {

	        int num = val[i-1];
	        //찾고자 하는 위치
	        int idx = q.indexOf(num);

	        //중간 설정
	        int mid = q.size() % 2;
	        if (mid == 0) mid = q.size()/2 - 1;
	        else mid = (q.size()/2);
	        
	        //앞에서뺄지 뒤에서뺄지
	        if ( idx <= mid ) {
	            while ( q.peekFirst() != num ) {
	                result++;
	                q.addLast(q.pollFirst());
	            }
	        } else {
	            while ( q.peekFirst() != num ) {
	                result++;
	                q.addFirst(q.pollLast());
	            }
	        }

	        q.pollFirst();

	    }
		
		sb.append(result);
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();

	}

}
