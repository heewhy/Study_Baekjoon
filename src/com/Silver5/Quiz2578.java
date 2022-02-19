package com.Silver5;

import java.io.*;
import java.util.*;

public class Quiz2578 {

	public static void main(String[] args) throws Exception{
		// 빙고
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N=5;
		int[][] map = new int[N][N];
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
		}
		
		int[] row = new int[N];
		int[] col = new int[N];
		int lx=0;
		int rx=0;
		int result=0;
		int cnt=0;
		
		loop:
		while(!list.isEmpty()) {
			result++;
			int num = list.poll();
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j]==num) {
						row[i]++;
						if(row[i]==5) cnt++;
						
						col[j]++;
						if(col[j]==5) cnt++;
						
						if(i-j==0) {
							lx++;
							if(lx==5) cnt++;
						}
						if(i+j==4) {
							rx++;
							if(rx==5) cnt++;
						}
						
						if(cnt>=3) break loop;
						
					}
				}
			}
			
		}
		
		sb.append(result);
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}

}
