package com.Silver2;

import java.io.*;
import java.util.*;

public class Quiz5567 {

	public static void main(String[] args) throws Exception{
		// 결혼식
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		ArrayList<Integer>[] person = new ArrayList[N+1];
		
		for(int i=1;i<=N;i++) {
			person[i] = new ArrayList<Integer>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			person[start].add(end);
			person[end].add(start);
		}
		
		boolean[] visited = new boolean[N+1];
		LinkedList<Integer> q = new LinkedList<Integer>();
		visited[1] = true;
		q.offer(1);
		
		int ans=0;
		int depth = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int k=0;k<size;k++) {
				int num = q.poll();
				
				for(int i=0;i<person[num].size();i++) {
					int next = person[num].get(i);
					
					if(visited[next]) continue;
					
					visited[next] = true;
					q.offer(next);
				}
			}
			depth++;
			ans += q.size();
			if(depth==2) break;
		}
		
		System.out.println(ans);
		
		br.close();
	}

}
