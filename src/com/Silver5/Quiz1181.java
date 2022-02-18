package com.Silver5;

import java.io.*;
import java.util.*;

public class Quiz1181 {

	public static void main(String[] args) throws Exception{
		// 단어정렬
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb= new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		List<String> strs = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			if(!strs.contains(s)) strs.add(s);
		}
		//사전순정렬
		strs.sort((a,b)->a.compareTo(b));
		
		//짧은순
		strs.sort((a,b)-> a.length()-b.length());
		
		
		for(String s : strs) {
			sb.append(s+"\n");
		}
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}

}
