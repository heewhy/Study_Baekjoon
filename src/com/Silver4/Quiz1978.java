package com.Silver4;

import java.io.*;
import java.util.*;

public class Quiz1978 {

	public static void main(String[] args) throws Exception{
		// 소수 찾기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int cnt=0;
		
				
		st = new StringTokenizer(br.readLine());
		
		while(st.hasMoreTokens()) {
	        
			// 소수인경우 true, 아닌경우 false   
			boolean isPrime = true;
			
			int num = Integer.parseInt(st.nextToken());
			
			//1은 소수
			if(num == 1) {
				continue;
			}
			//나눠지면 소수가 아님
			for(int i = 2; i <= Math.sqrt(num); i++) {
				if(num % i == 0) {
					isPrime = false;
					break;
				}
			}
			if(isPrime) {
				cnt++;
			}
		}
		
		sb.append(cnt);
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}

	
}
