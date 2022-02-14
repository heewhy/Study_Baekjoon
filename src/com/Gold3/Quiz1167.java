package com.Gold3;

import java.io.*;
import java.util.*;

public class Quiz1167 {
	
	static int N,total_length,far;
	static int[][] tree;
	static int[][] length;
	static boolean[] visited;
 	
	

	public static void main(String[] args) throws Exception{
		// 트리의 지름
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		tree = new int[N+1][N+1];
		visited = new boolean[N+1];
		length = new int[N+1][N+1];
		
		
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int start_node = Integer.parseInt(st.nextToken());
			while(true) {
				int end_node = Integer.parseInt(st.nextToken());
				if(end_node==-1) break;
				int node_length = Integer.parseInt(st.nextToken());
				
				tree[start_node][end_node]=tree[end_node][start_node]=1;
				length[start_node][end_node]=length[end_node][start_node]=node_length;
				
			}
		}	
		
		dfs(1,0);
//		bfs(1,0);
//		visited = new boolean[N+1];
//		bfs(N,0);
		
		sb.append(total_length+"\n");
		
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}//main



	private static void dfs(int first,int total) {
		Stack<Integer> stack = new Stack<>();
		stack.push(first);
		visited[first] = true;
		while(!stack.empty()) {
			//System.out.print(stack.pop()+" ");
			if(total>total_length) {
				total_length = total;
			}
		}
		for(int i=1;i<tree.length;i++) {
			if(tree[first][i]==1&&!visited[i]) {
				dfs(i,total+length[first][i]);
			}
		}
	}
	
//	private static void bfs(int first,int total) {
//		Queue<Integer> q = new LinkedList<>();
//		q.offer(first);
//		visited[first]=true;
//		
//		int max=0;
//		
//		while(!q.isEmpty()) {
//			int start = q.poll();
//			System.out.print(start+" ");
//			
//			if(total>max) {
//				max = total;
//				far = start;
//			}
//			
//			for(int i=1;i<tree.length;i++) {
//				if(tree[start][i]==1&&!visited[i]) {
//					q.offer(i);
//					visited[i]=true;
//					total = total+length[start][i];
//				}
//			}
//			
//		}
//		total_length = Math.max(max, total_length);
//	}
	
}
	
	


