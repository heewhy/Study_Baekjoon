package com.Gold5;

import java.io.*;
import java.util.*;

public class Quiz9663 {
	
	static int N,ans;
	static int col[];

	public static void main(String[] args) throws Exception{
		// N-Queen
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		ans=0;
		col = new int[N+1];
		
		setQueen(1);
		
		sb.append(ans);
		bw.write(sb.toString());;
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	/**
	 * 퀸을 두는 함수
	 * @param rowNo 퀸을 두어야 하는 현재 행
	 * */
	public static void setQueen(int rowNo) {
		
		//기저조건 퀸을 모두 놓았다면
		if(rowNo>N) {
			ans++;
			return;
		}
		
		//유도파트
		//1열부터 - N 열까지 퀸을 놓는 시도
		for(int i=1;i<=N;i++) {
			col[rowNo] = i;
			//가지치기
			if(isAvailable(rowNo)) { 
			setQueen(rowNo+1);
			}
		}
	}
	
	/**
	 * 현재 퀸을 받아 둘 수 있는지 판단
	 * @param rowNo 놓아진 마지막 퀸
	 * */
	public static boolean isAvailable(int rowNo) {
		//대각선이거나 전의 열에 퀸이 놓여있을때
		for(int i=1;i<rowNo;i++) {
			if(col[rowNo]==col[i]|| rowNo-i==Math.abs(col[rowNo]-col[i])) return false;
		}
		return true;
	}

}
