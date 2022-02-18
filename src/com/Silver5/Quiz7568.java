package com.Silver5;

import java.io.*;
import java.util.*;

public class Quiz7568 {
	

	public static void main(String[] args) throws Exception{
		// 덩치
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb= new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		
		//몸무게 키 입력
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < N; i++) {
			int rank = 1;	// rank 는 1 부터 시작
					
			for(int j = 0; j < N; j++) {
				if(i == j) continue;	// 같은 사람은 비교할 필요가 없음
		 
				/* 
				i 번째 사람과 j 번째 사람을 비교하여 i 가 j 보다
				덩치가 작을 경우 rank 값을 1 증가시킨다
				*/
				if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
					rank++;
				}
			}
			sb.append(rank+" ");
		}
		
		
		bw.write(sb.toString());
		
		
		br.close();
		bw.flush();
		bw.close();
	}

}
