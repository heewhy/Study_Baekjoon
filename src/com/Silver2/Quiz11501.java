package com.Silver2;

import java.io.*;
import java.util.*;

public class Quiz11501 {

	public static void main(String[] args) throws Exception{
		// 주식
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] stock = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				stock[i] = Integer.parseInt(st.nextToken());
			}
			
			long ans=0;
			int hp = 0;
			for(int i=N-1;i>=0;i--) {
				if(stock[i]>hp) {
					hp = stock[i];
				}
				else {
					ans += hp - stock[i];
				}
			}
			
			System.out.println(ans);
			
		}
		
		br.close();
	}

}
