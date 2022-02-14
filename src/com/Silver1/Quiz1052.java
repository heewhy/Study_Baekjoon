package com.Silver1;

import java.io.*;
import java.util.*;

public class Quiz1052 {

	public static void main(String[] args) throws Exception{
		// 물병
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		//2진수에서 1의 개수
		int K = Integer.parseInt(st.nextToken());
		
		int result=0;
		
		while(true) {
			char[] binary = Integer.toBinaryString(N).toCharArray();
			int cnt=0;
			
			for(int i=0;i<binary.length;i++) {
				if(binary[i]=='1') cnt++;
			}
			
			if(cnt<=K) {
				sb.append(result);
				break;
			}
			
			N++;
			result++;
		}
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();		
	}

}
