package com.Silver2;

import java.io.*;
import java.util.*;

public class Quiz1535 {
	
	static int ans,N;
	static int[] life,happy;

	public static void main(String[] args) throws Exception{
		// 안녕
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//사람 수
		N = Integer.parseInt(br.readLine());
		
		//소모하는 생명
		life = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			life[i] = Integer.parseInt(st.nextToken());
		}
		
		//얻는 기쁨
		happy = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			happy[i] = Integer.parseInt(st.nextToken());
		}
		
		//연락
		contact(100,0,1);
		
		
		System.out.println(ans);
		
		br.close();
	}

	/**
	 * 재귀로 체력을 소모해서 얻을 수 있는 가장 큰 행복 구하기
	 * @param leftLife		남은체력
	 * @param totalHappy	얻은 행복량
	 * @param idx			현재 idx
	 */
	private static void contact(int leftLife, int totalHappy, int idx) {
		//체력이 소진되었다면
		if(leftLife<=0) return;
		
		//N까지 도달하면
		if(idx==N+1) {
			ans = Math.max(totalHappy, ans);
			return;
		}
		
		//선택하지 않은 경우
		contact(leftLife,totalHappy,idx+1);
		//선택한 경우
		contact(leftLife-life[idx],totalHappy+happy[idx],idx+1);
	}

}
