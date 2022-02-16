package com.Silver1;

import java.io.*;
import java.util.*;

public class Quiz1992 {
	
	static int[][] quad;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception{
		// 쿼드트리
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		quad = new int[N][N];
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<N;j++) {
				quad[i][j] = str.charAt(j)-'0';
			}
		}
		
		//for(int[] a : quad)System.out.println(Arrays.toString(a));
		
		quad(0,0,N);
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}

	/**
	 * 좌상 우상 좌하 우하 순으로 탐색하며 sb에 배열 정보를 담는 함수
	 * @param i 시작 row 값
	 * @param j 시작 col 값
	 * @param size 한변의 크기
	 * */
	private static void quad(int i, int j, int size) {
		
		if(isCompression(i,j,size)) {
			sb.append(quad[i][j]);
			//System.out.println(sb);
			return;
		}
		
		int half = size/2;
		//System.out.println(half);
	
		sb.append('(');
		quad(i,j,half); //좌상
		quad(i,j+half,half); //우상
		quad(i+half,j,half); //좌하
		quad(i+half,j+half,half); //우하
		sb.append(')');
	
	}
	
	/**
	 * 압축 가능 여부를 알려주는 함수
	 * @param i 시작 row 값
	 * @param j col 값
	 * @param size 한변의 크기
	 * */
	private static boolean isCompression(int i, int j, int size) {
		int num = quad[i][j];
		//System.out.println("i :"+i);
		//System.out.println("j :"+j);
		//System.out.println("size :"+size);
		for(int r=i;r<i+size;r++) {
			for(int c=j;c<j+size;c++) {
				if(num!=quad[r][c]) return false;
			}
		}
		
		return true;
	}

}
/*
4
1111
1100
0100
1100
 * */
