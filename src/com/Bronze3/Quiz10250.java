package com.Bronze3;

import java.io.*;
import java.util.*;

public class Quiz10250 {

	public static void main(String[] args) throws Exception{
		// ACM 호텔
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st ;
		
		
		int T= Integer.parseInt(br.readLine());
		
		while(T-->0) {
			st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			
			int cnt=0;
			
			for(int j=1;j<=W;j++) {
				for(int i=1;i<=H;i++) {
					cnt++;
					if(cnt==N) {
						if(j<=9) sb.append(i+"0"+j+"\n");
						else sb.append(i+""+j+"\n");
					}
				}
				/*
				 * int X, Y;
 
					if (N % H == 0) {
						Y = H * 100;
						X = N / H;
					}
					else {
						Y = (N % H) * 100;
						X = (N / H) + 1;
					}
					 
					int XXYY = Y + X;	//최종 호수
				 * */
			}
			
		}
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}

}


