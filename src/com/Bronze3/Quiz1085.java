package com.Bronze3;

import java.io.*;
import java.util.*;

public class Quiz1085 {

	public static void main(String[] args) throws Exception{
		// 직사각형에서 탈출
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st ;
		
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		int result = Math.min(Math.min(x-0, w-x), Math.min(y-0, h-y));
		
		sb.append(result);
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}

}
