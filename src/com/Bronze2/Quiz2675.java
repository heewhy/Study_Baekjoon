package com.Bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Quiz2675 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 문자열 반복
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(bf.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			StringBuilder sb = new StringBuilder();
			StringTokenizer st = new StringTokenizer(bf.readLine());
			
			int cnt = Integer.parseInt(st.nextToken());
			String str = st.nextToken();
			
			for(int i=0;i<str.length();i++) {
				for(int j=0;j<cnt;j++) {
					sb.append(str.charAt(i));
				}
			}
			
			System.out.println(sb.toString());
		}
		
	}

}
