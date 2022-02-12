package com.Bronze3;

import java.io.*;
import java.util.*;

public class Quiz4153 {

	public static void main(String[] args) throws Exception{
		// 직각삼각형
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st ;
		
		while(true) {
			int[] arr = new int[3];
			st = new StringTokenizer(br.readLine());
			arr[0] = Integer.parseInt(st.nextToken());
			arr[1] = Integer.parseInt(st.nextToken());
			arr[2] = Integer.parseInt(st.nextToken());
			
			if(arr[0]==0&&arr[1]==0&&arr[2]==0) break;
			
			Arrays.sort(arr);
//			System.out.println(Arrays.toString(arr));
			
			if(Math.pow(arr[0], 2)+Math.pow(arr[1], 2)==Math.pow(arr[2], 2)) sb.append("right\n");
			else sb.append("wrong\n");
		
		}
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}

}
