package com.Silver2;

import java.io.*;
import java.util.*;

public class Quiz4307 {

	public static void main(String[] args) throws Exception{
		// 개미
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		//테스트케이스
		int T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			st = new StringTokenizer(br.readLine());
			//막대의 길이
			int N = Integer.parseInt(st.nextToken());
			//개미의 수
			int S = Integer.parseInt(st.nextToken());
			int[] ant = new int[S];
			
			int max = Integer.MIN_VALUE;
			
			for(int i=0;i<S;i++) {
				ant[i] = Integer.parseInt(br.readLine());
				//개미별 가장 빨리 떨어지는 값
				int valmin = Math.min(ant[i], N-ant[i]);
				
				//중에 큰거
				max = Math.max(valmin, max);
			}
			
			Arrays.sort(ant);
			
			sb.append(max+" "+Math.max(N-ant[0], ant[S-1])+"\n");
		}
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}

}

/*
import java.io.*;
import java.util.*;
// 좋은 코드 흡수하기!
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int[] ant = new int[l + 1];
			for(int i = 0; i<n; i++) {
				ant[i] = Integer.parseInt(br.readLine());
			}
			int ans1 = 0;
			int ans2 = 0;
			
			for(int i = 0; i<n; i++) {
			 	ans1 = Math.max(Math.min(l - ant[i], ant[i]), ans1);;
			 	ans2 = Math.max(Math.max(l - ant[i], ant[i]), ans2);
			}
			
			bw.write(ans1+" "+ans2+"\n");
		}
		bw.flush();
		
	}
} 
 */
