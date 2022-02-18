package com.Silver5;

import java.io.*;
import java.util.*;

public class Quiz1436 {

	public static void main(String[] args) throws Exception{
		// 영화감독 숌
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb= new StringBuilder();
		
		
		int N = Integer.parseInt(br.readLine());
		int cnt=0;
		
		for(int i=666;i<Integer.MAX_VALUE;i++) {
			String s = String.valueOf(i);
			if(s.contains("666")) {
				cnt++;
			}
			if(cnt==N) {
				sb.append(i);
				break;
			}
		}
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}

}
