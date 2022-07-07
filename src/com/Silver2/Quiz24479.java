package com.Silver2;

import java.io.*;
import java.util.*;

public class Quiz24479 {
	
	static int N,E,idx=0;
	static ArrayList<Integer>[] nodes;
	static int[] ans;
	static boolean[] visited;

	public static void main(String[] args) throws Exception{
		// 알고리즘 수업 - 깊이 우선 탐색 1
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 노드의 수
		E = Integer.parseInt(st.nextToken()); // 간선의 수
		int startNode = Integer.parseInt(st.nextToken()); //시작 정점
		
		nodes = new ArrayList[N+1];
		
		for(int i=1;i<=N;i++) {
			nodes[i] = new ArrayList<Integer>();
		}
		
		ans = new int[N+1];
		visited = new boolean[N+1];
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			nodes[start].add(end);
			nodes[end].add(start);
		}
		
		for(int i=1;i<=N;i++) {
			Collections.sort(nodes[i]);
		}
		visited[startNode] = true;
		
		dfs(startNode);
		
		
		for(int i=1;i<=N;i++) {
			System.out.println(ans[i]);
		}
		
		br.close();
	}

	private static void dfs(int current) {
		ans[current] = ++idx;
		for(int next : nodes[current]) {
			if(visited[next]) continue;
			visited[next] = true;
			dfs(next);
		}
	}

}
