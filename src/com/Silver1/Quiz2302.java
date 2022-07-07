package com.Silver1;

import java.io.*;
import java.util.*;

public class Quiz2302 {
	
	public static void main(String[] args) throws Exception{
		// 극장 좌석
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); //좌석의 개수
		int M = Integer.parseInt(br.readLine()); //고정석의 개수
		
		int[] memo = new int[41];
		memo[0] = 1;
		memo[1] = 1;
		
		for(int i=2;i<41;i++) {
			memo[i] = memo[i-1]+memo[i-2];
		}
		
		long ans=1;
		int save = 0;
		for(int i=0;i<M;i++) {
			int vip = Integer.parseInt(br.readLine());
			ans *= memo[vip-save-1];
			save = vip;
		}
		
		ans *= memo[N-save];
		
		System.out.println(ans);
		
		br.close();
	}



}
