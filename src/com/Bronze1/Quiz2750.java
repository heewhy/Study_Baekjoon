package com.Bronze1;

import java.io.*;
import java.util.*;

public class Quiz2750 {

	public static void main(String[] args) throws Exception{
		// 수 정렬하기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
			
		//정수 개수 입력
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}

		//정렬
		Arrays.sort(arr);
		
		for(int i: arr) {
			sb.append(i+"\n");
		}
		
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}

}
