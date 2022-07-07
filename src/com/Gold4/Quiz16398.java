package com.Gold4;

import java.io.*;
import java.util.*;

public class Quiz16398 {

	public static void main(String[] args) throws Exception{
		// 행성 연결
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] adjMatrix = new int[N][N];
		int[] minEdge = new int[N]; 
		boolean[] visited = new boolean[N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
			minEdge[i] = 100000001;
		}
		
		long result = 0;
		minEdge[0]=0;
		
		//N개의 정점을 모두 연결
		for( int c=0;c<N;c++) {
			//신장 트리에 연결되지 않은 정점 중 가장 유리한 비용의 정점을 선택
			long min = 100000001;
			int minVertex = 0;
			
			for(int i=0;i<N;i++) {
				if(!visited[i]&&min>minEdge[i]) {
					min = minEdge[i];
					minVertex =i;
				}
			}
			
			//선택된 정점을 신장트리에 포함시킴
			visited[minVertex] = true;
			result += min;
			
			for(int i=0;i<N;i++) {
				if(!visited[i]&&adjMatrix[minVertex][i]!=0&&minEdge[i] >adjMatrix[minVertex][i]) {
					minEdge[i] = adjMatrix[minVertex][i];
				}
			}
			
		}

		System.out.println(result);
		
		br.close();
	}

}
