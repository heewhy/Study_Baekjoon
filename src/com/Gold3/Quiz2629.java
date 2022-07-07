package com.Gold3;

import java.io.*;
import java.util.*;

public class Quiz2629 {
	
	static int Wcnt;
	static int[] weights;
	static boolean[][] results;
	static final int MAX_SIZE = 40001;

	public static void main(String[] args) throws Exception{
		// 양팔저울
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		//추 개수 및 정보
		Wcnt = Integer.parseInt(br.readLine());
		weights = new int[Wcnt];
		results = new boolean[31][MAX_SIZE];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<Wcnt;i++) {
			weights[i] = Integer.parseInt(st.nextToken());
		}
		
		
		dp(0,0);
		
		//구슬 개수 및 정보
		int Bcnt = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<Bcnt;i++) {
			int ball = Integer.parseInt(st.nextToken());
			if(results[Wcnt][ball]) sb.append("Y ");
			else sb.append("N ");
		}
		
		
		System.out.println(sb.toString());
		
		br.close();
	}

	/**
	 * 
	 * @param cnt 고른 추의 개수,번호
	 * @param curW 무게 경우의 수
	 */
	private static void dp(int num, int curW) {

		if(results[num][curW]) return;
		results[num][curW] = true;
		if(num==Wcnt) return;
		
		dp(num+1,curW);
		dp(num+1,curW+weights[num]);
		dp(num+1,Math.abs(curW-weights[num]));
	}

}
