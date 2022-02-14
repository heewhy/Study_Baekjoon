package com.Bronze2;

import java.io.*;
import java.util.*;

public class Quiz2775 {

	public static void main(String[] args) throws Exception{
		// 부녀회장이 될테야
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			
			int[][] arr = new int[k+1][n+1];
			
			//첫층 세팅
			for(int i=0;i<=n;i++) {
				arr[0][i]=i;
			}
			
//			System.out.println("첫줄 값넣기");
//			for(int[] a: arr)System.out.println(Arrays.toString(a));
			
			for(int i=1;i<=k;i++) {
				for(int j=1;j<=n;j++) {
					arr[i][j]=arr[i][j-1]+arr[i-1][j]; //0+1
				}
			}
//			System.out.println("나머지 채워넣기");
//			for(int[] a: arr)System.out.println(Arrays.toString(a));
			
			sb.append(arr[k][n]+"\n");
		}
		
		bw.write(sb.toString());
		
		
		br.close();
		bw.flush();
		bw.close();

	}

}
