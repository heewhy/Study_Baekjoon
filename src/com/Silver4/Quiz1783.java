package com.Silver4;

import java.io.*;
import java.util.*;

public class Quiz1783 {
	
	public static void main(String[] args) throws Exception{
		// 병든 나이트
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		
		//체스판 크기
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int ans=0;
		
		
		//1x1일때
		if(N==1||M==1) ans=1;
		//세로가 2일때
		else if(N==2) {
			ans = Math.min(4, 1+((M-1)/2));
		}
		else {
			//7보다크면 M-2  그리디적으로 무조건 한칸이동하니까 
			if(M>=7) ans = M-2;
			else ans = Math.min(4, M);
		}
		
		sb.append(ans);
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}

}
