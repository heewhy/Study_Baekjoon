package com.Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Quiz11725 {
	
	static int[] result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 트리의 부모 찾기
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] tree = new int[N+1][N+1];
		
		for(int i=0;i<N-1;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b=  Integer.parseInt(st.nextToken());
			
			tree[a][b]=1;
			tree[b][a]=1;
		}
		
		result = new int[N+1];
		bfs(1,tree,new boolean[N+1]);
		
		StringBuilder sb = new StringBuilder();
		
		for(int a : result) {
			if(a!=0) {
				sb.append(a).append("\n");
			}
		}
		System.out.println(sb.toString());
		br.close();
	}
	
	private static void bfs(int first,int[][] tree,boolean[] check) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(first);
		check[first]=true;
		while(!q.isEmpty()) {
			int start = q.poll();
			//System.out.print(start+" ");
			for(int i=1;i<tree.length;i++) {
				if(tree[start][i]==1&&!check[i]) {
					q.offer(i);
					result[i] = start;
					check[i]=true;
				}
			}
		}
		
	}
}
	
	
