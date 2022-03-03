package com.Silver3;

import java.io.*;
import java.util.*;

public class Quiz2606 {
	
	static int N,M,ans;
	static boolean visited[];
	static ArrayList<Integer>[] tree; 
	
	public static void main(String[] args) throws Exception{
		// 바이러스
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		//정점의 수
		N = Integer.parseInt(br.readLine());
		//간선의 수
		M = Integer.parseInt(br.readLine());
		
		//인접리스트, 방문체크
		tree = new ArrayList[N+1];
		visited = new boolean[N+1];
		
		//인접리스트 초기화
		for(int i=0;i<=N;i++) {
			tree[i] = new ArrayList<Integer>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			//트리연결
			tree[a].add(b);
			tree[b].add(a);
		}
		
		
		bfs(1);
		
		sb.append(ans);
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}



	/**
	 * 너비 우선 탐색
	 * @param start 시작 노드
	 * */
	private static void bfs(int start) {
		LinkedList<Integer> q = new LinkedList<Integer>();
		q.offer(start);
		visited[start]=true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int i=0;i<tree[cur].size();i++) {
				if(!visited[tree[cur].get(i)]) {
					visited[tree[cur].get(i)]=true;
					q.offer(tree[cur].get(i));
					ans++;
				}
			}
		}
		
	}

}
