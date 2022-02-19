package com.Bronze2;

import java.io.*;
import java.util.*;

public class Quiz2605 {

	public static void main(String[] args) throws Exception{
		// 줄 세우기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		LinkedList<Integer> line = new LinkedList<Integer>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			int num = Integer.parseInt(st.nextToken());
			
			line.add((i-1)-num,i);
		}
		
		for(int i=0;i<N;i++) {
			sb.append(line.get(i)+" ");
		}
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}

}
