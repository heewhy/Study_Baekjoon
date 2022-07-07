package com.Silver1;

import java.io.*;
import java.util.*;

public class Quiz1446 {
	
	static class ShortPath {
		int from, to, dist;
		public ShortPath(int from, int to, int dist) {
			this.from = from;
			this.to = to;
			this.dist = dist;
		}
	}

	public static void main(String[] args) throws Exception{
		// 지름길
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		ArrayList<ShortPath> path = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			if (to > d)	continue; // 역주행은 할 수 없다.
			if (to - from <= dist)	continue; // 지름길이 아닌 것
			path.add(new ShortPath(from, to, dist));
		}

		// 길 앞에서부터 순서대로 정렬
		Collections.sort(path, new Comparator<ShortPath>() {
			public int compare(ShortPath o1, ShortPath o2) {
				if (o1.from == o2.from)	return Integer.compare(o1.to, o2.to);
				return Integer.compare(o1.from, o2.from);
			}
		});

		// 탐색 시작
		int move = 0;
		int dp[] = new int[d + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		int idx = 0;
		while (move < d) {
			if (idx < path.size()) {
				ShortPath sp = path.get(idx);
				if (move == sp.from) {
					dp[sp.to] = Math.min(dp[move] + sp.dist, dp[sp.to]);
					idx++;
				} else {
					dp[move + 1] = Math.min(dp[move + 1], dp[move] + 1);
					move++;
				}
			} else {
				dp[move + 1] = Math.min(dp[move + 1], dp[move] + 1);
				move++;
			}
		}
		System.out.println(dp[d]);
	}
}


/*
static class Node implements Comparable<Node>{
		int from,to,weight;

		public Node(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			if(this.from==o.from) return this.to-o.to;
			
			return this.from-o.from;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Node [from=");
			builder.append(from);
			builder.append(", to=");
			builder.append(to);
			builder.append(", weight=");
			builder.append(weight);
			builder.append("]");
			return builder.toString();
		}
		
		
	}
	

	public static void main(String[] args) throws Exception{
		// 지름길
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[D+1];
		for(int i=0;i<=D;i++) {
			dp[i] = i;
		}
		
		//추가
		PriorityQueue<Node> q = new PriorityQueue<>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			if(to>D) continue;
			
			q.add(new Node(from,to,weight));
			//정렬이 안되어있는듯
			//dp[to] = Math.min(dp[to], dp[from]+weight);
			
		}
		
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			System.out.println(node.toString());
			
			dp[node.to] = Math.min(dp[node.to], dp[node.from]+node.weight);
		}
		
		//정보 받고 다시 dp 데이터 쌓아올리기
		for(int i=1;i<=D;i++) {
			dp[i] = Math.min(dp[i], dp[i-1]+1);
		}
		
		int ans =0;
		for(int i=1;i<=D;i++) {
			if(dp[i]!=i&&dp[i]<ans) {
				ans=dp[i];
			}
			ans++;
		}
		
		System.out.println(dp[D]);
		
		br.close();
	}

}
 */
