package com.Silver3;

import java.io.*;
import java.util.*;

public class Quiz1051 {
	
	//우 우하 하
	static int[] di = {0,1,1};
	static int[] dj = {1,1,0};
	
	public static void main(String[] args) throws Exception{
		// 숫자 정사각형
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb= new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int move = Math.max(N, M);
		int[][] map = new int[N][M];
		
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] = s.charAt(j)-'0';
			}
		}

		//for(int[] a : map)System.out.println(a.toString());
		int cnt=0;
		int size=0;
		
		for (int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				
				for(int l=0;l<move;l++) {
					for(int k=0;k<3;k++) {
					
						int r = i+di[k]*l;
						int c = j+dj[k]*l;
					
						if(r>=0&&r<N&&c>=0&&c<M&&map[i][j]==map[r][c]) {
							cnt++;
						}
						
						if(cnt==3) {
							size=Math.max(size, (int)Math.pow(l+1,2));
						}
					}	
					cnt=0;
				}
				
			}
		}
		
		
		if(size==0) size=1;
		
		sb.append(size);
		
		bw.write(sb.toString());
		
		
		
		br.close();
		bw.flush();
		bw.close();
		
		
	}

}
