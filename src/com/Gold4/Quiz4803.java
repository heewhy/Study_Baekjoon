package com.Gold4;

import java.io.*;
import java.util.*;

public class Quiz4803 {

	static int N;
	//static int[] parents;
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception{
		// 트리
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc=1;
		
		while(true) {

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			if(N==0&&M==0) break;
			
			graph = new ArrayList[N];
			visited = new boolean[N];
			
			for(int i=0;i<N;i++) {
				graph[i] = new ArrayList<Integer>();
			}
			
			while(M-->0) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken())-1;
				int b = Integer.parseInt(st.nextToken())-1;
				
				graph[a].add(b);
				graph[b].add(a);
			}
			
			int cnt=0;
			
			for (int i = 0; i < N; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    if (dfs(-1, i)) cnt++;
                }
            }
			
			sb.append("Case ").append(tc).append(": ");
            if (cnt == 0) {
                sb.append("No trees.\n");
            } else if (cnt == 1) {
                sb.append("There is one tree.\n");
            } else {
                sb.append("A forest of ").append(cnt).append(" trees.\n");
            }
			
			tc++;
		}
		
		
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	public static boolean dfs(int root, int num) {
        for (int i : graph[num]) {
        	//사이클이 생긴 경우
            if (i == root) continue;
            if (visited[i]) return false;
            visited[i] = true;
            if (!dfs(num, i)) return false;
        }
        return true;
    }

}


/*
	parents = new int[n+1];
	for(int i=1; i<n+1; i++) {
		parents[i] = i;
	}
	
	for(int i=0; i<m; i++) {
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		union(a,b);
	}
	
	Set<Integer> treeSet = new HashSet<>();
	for(int i=1; i<n+1; i++) {
		int ra = find(i);
		if(ra >0) {
			treeSet.add(ra);	
		}
	}
	
	static int find(int x) {
		if(parents[x] ==x) return x;
		return find(parents[x]);
	}
	
	static void union(int x, int y) {
		int xRoot= find(x);
		int yRoot= find(y);
		if(yRoot < xRoot) {
			int tmp = xRoot;
			xRoot = yRoot;
			yRoot = tmp;
		}
		// 사이클인 경우
		if(xRoot==yRoot) {
			parents[xRoot] = 0;
		}
		else {
			parents[yRoot] = xRoot;
		}
	} 
 */
 