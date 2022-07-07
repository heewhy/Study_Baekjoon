package com.Gold4;

import java.io.*;
import java.util.*;

public class Quiz2239 {
	
	static int N = 9;
	static int[][] map = new int[N][N];
	
	public static void main(String[] args) throws Exception{
		// 스도쿠
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			for(int j=0;j<N;j++) {
				int num = s.charAt(j)-'0';
				map[i][j] = num;
			}
		}
		
		//for(int[] i : map) System.out.println(Arrays.toString(i));
		
		sdoku(0);
		
		//for(int[] i : map) System.out.println(Arrays.toString(i));
		
		br.close();
	}

	private static void sdoku(int point) {
		
		if(point==N*N) {
			//map 찍고 끝내야할듯?
			for(int[] i : map) {
				for(int j: i) System.out.print(j);
				System.out.println();
			}
			System.exit(0);
			//System.out.println("--------------------------------------");
			return;
		}
	
		int r = point/N;
		int c = point%N;
		
		if(map[r][c]!=0) {
			sdoku(point+1);
		}else {
			for(int i=1;i<10;i++) {
				if(!numCheck(r,c,i))continue;
				map[r][c] = i;
				sdoku(point+1);
				map[r][c] = 0;
				
			}
		}
		
		
	}

	private static boolean numCheck(int r,int c,int num) {
		return rowcheck(r,c,num)&&colcheck(r,c,num)&&boxcheck(r,c,num);
	}

	private static boolean rowcheck(int r, int c, int num) {
		for(int i=0;i<N;i++) {
			if(map[r][i]==num) return false;
		}
		return true;
	}

	private static boolean colcheck(int r, int c, int num) {
		for(int i=0;i<N;i++) {
			if(map[i][c]==num) return false;
		}
		return true;
	}

	private static boolean boxcheck(int r, int c, int num) {
		r = (r/3)*3;
		c = (c/3)*3;
		
		for(int i=r;i<r+3;i++) {
			for(int j=c;j<c+3;j++) {
				if(map[i][j]==num) return false;
			}
		}
		
		return true;
	}

}
