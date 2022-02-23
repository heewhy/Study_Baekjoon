package com.Gold4;

import java.io.*;
import java.util.*;

public class Quiz1922 {

	static class Edge implements Comparable<Edge> {
		int start;
		int end;
		int weight;

		Edge(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return weight - o.weight;
		}

	}
	
	static int[] parent;
	static ArrayList<Edge> edgeList;
	
	public static int find(int x) {
		if (x == parent[x]) {
			return x;
		}

		return parent[x] = find(parent[x]);
	}

	public static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x != y) {
			parent[y] = x;
		}
	}

	
	public static void main(String[] args) throws Exception{
		// 네트워크 연결
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		edgeList = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			edgeList.add(new Edge(start, end, weight));
		}

		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		Collections.sort(edgeList);

		int ans = 0;
		for (int i = 0; i < edgeList.size(); i++) {
			Edge edge = edgeList.get(i);

			// 사이클이 발생하는 간선은 제외.
			if (find(edge.start) != find(edge.end)) {
				ans += edge.weight;
				union(edge.start, edge.end);
			}
		}
		
		sb.append(ans + "\n");
		bw.write(sb.toString());
		
		bw.flush();
		bw.close();
		br.close();
	}

	

}
