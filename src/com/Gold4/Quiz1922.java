package com.Gold4;

import java.io.*;
import java.util.*;

public class Quiz1922 {

	static class Node{
		int Vertex;
		int weight;
		Node link;
		
		public Node(int Vertex,int weight,Node link) {
			this.Vertex = Vertex;
			this.weight = weight;
			this.link = link;
		}
	}
	
	static int ans;
	
	public static void main(String[] args) throws Exception{
		// 네트워크 연결
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		//정점의 수
		int N = Integer.parseInt(br.readLine());
		//간선의 수
		int M = Integer.parseInt(br.readLine());
		
		Node[] nodes = new Node[N+1];
		
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			nodes[from] = new Node(to,weight,nodes[from]);
			nodes[to] = new Node(from,weight,nodes[to]);
		}
		
		bfs(nodes,1);
		
		br.close();
		bw.flush();
		bw.close();
	}

	private static void bfs(Node[] nodes, int start) {
		
		boolean[] visited = new boolean[nodes.length];
		Queue<Integer> queue = new LinkedList<Integer>();
		//PriorityQueue<Node> pq = new PriorityQueue<Node>((a,b)->a.weight-b.weight);
		//Node list;
		
		queue.offer(start);
		visited[start]=true;
		
		
		while(!queue.isEmpty()) {
			
			int cur = queue.poll();
			//list=nodes[cur];
			
			System.out.println(cur);
			for(Node temp = nodes[cur];temp!=null;temp=temp.link) {
				if(!visited[temp.Vertex]) {
					queue.offer(temp.Vertex);
					visited[temp.Vertex] = true;
				}
			}
		}
		
		
	}

}
