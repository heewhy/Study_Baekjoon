package com.Gold5;

import java.io.*;
import java.util.*;

public class Quiz1753 {
	
	static class Node implements Comparable<Node>{
	    int to, weight;

	    public Node(int to, int weight){
	        this.to = to;
	        this.weight = weight;
	    }

	    @Override
	    public int compareTo(Node o) {
	        return weight - o.weight;
	    }
	}

	static int N,E;
	static List<Node>[] graph;
    static int[] distance;
	
	public static void main(String[] args) throws Exception{
		// 최단경로
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		//정점의 개수
		N = Integer.parseInt(st.nextToken());
		//연결 상태 저장 배열
		graph = new ArrayList[N+1];;
		
		for(int i=1;i<=N;i++) {
			graph[i] = new ArrayList<>();
		}
		//간선의 개수
		E = Integer.parseInt(st.nextToken());
		//시작 정점의 번호
		int start = Integer.parseInt(br.readLine());
		
		//간선정보 입력
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			graph[from].add(new Node(to,weight));
		}
		
		// 출발지에서 자신으로 오는 최소비용
		distance = new int[N+1]; 
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		
		dijkstra(start);
		
		for(int i=1;i<=N;i++) {
			if(distance[i]==Integer.MAX_VALUE) sb.append("INF"+"\n");
			else sb.append(distance[i]+"\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
	
	private static void dijkstra(int start){
	       PriorityQueue<Node> queue = new PriorityQueue<>();
	       boolean[] check = new boolean[N + 1];
	       queue.add(new Node(start, 0));
	       //시작점 0
	       distance[start] = 0;

	       while(!queue.isEmpty()){
	           Node curNode = queue.poll();
	           int cur = curNode.to;

	           if(check[cur] == true) continue;
	           check[cur] = true;

	           for(Node node : graph[cur]){
	               if(distance[node.to] > distance[cur] + node.weight){
	                   distance[node.to] = distance[cur] + node.weight;
	                   queue.add(new Node(node.to, distance[node.to]));
	               }
	           }
	       }
	}

}
