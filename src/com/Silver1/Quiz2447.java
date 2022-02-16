package com.Silver1;

import java.io.*;
import java.util.*;

public class Quiz2447 {
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception{
		// 별 찍기 - 10
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		String[][] map = new String[N][N];
	
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				star(i,j);
			}
			sb.append("\n");
		}
		
	
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}

	private static void star(int i, int j) {
		while (true) {
			if (i == 0)
				break;
			//나머지가 1인경우 공백
			if (i % 3 == 1 && j % 3 == 1) {
				sb.append(" ");
				return;
			}
			//계속 3으로 나누기
			i /= 3;
			j /= 3;
		}
		sb.append("*");
	}

	


}
