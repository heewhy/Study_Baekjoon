package com.Gold5;

import java.io.*;
import java.util.*;

public class Quiz2262 {

	public static void main(String[] args) throws Exception{
		// 토너먼트 만들기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<Integer>();
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		int sum=0;
		
		while(list.size()!=1) {
			int idx=list.indexOf(N);
			//System.out.println(list);
			if(idx==0) {
				sum += list.get(idx)-list.get(1);
			}else if(idx==N-1) {
				sum += list.get(idx)-list.get(idx-1);
			}else {
				if(list.get(idx-1)>list.get(idx+1)) {
					sum += list.get(idx)-list.get(idx-1);
				}else {
					sum += list.get(idx)-list.get(idx+1);
				}
			}
			//System.out.println(sum);
			list.remove(idx);
			N--;
		}
		
		sb.append(sum);
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}

}
