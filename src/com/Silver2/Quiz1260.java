package com.Silver2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Quiz1260 {

	public static void main(String[] args) {
		// DFS와 BFS
		Scanner sc = new Scanner(System.in);
		
		int node_count = sc.nextInt()+1;
		int line_count = sc.nextInt();
		int first = sc.nextInt();
		
		int[][] tree = new int[node_count][node_count];
		boolean[] check = new boolean[node_count];
		
		for(int i=0;i<line_count;i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			
			tree[start][end]=1;
			tree[end][start]=1;
		}
		
		
		dfs(first,tree,check);
		System.out.println();
		check = new boolean[node_count];
		bfs(first,tree,check);
		
	}

	private static void dfs(int first,int[][] tree,boolean[] check) {
		Stack<Integer> stack = new Stack<>();
		stack.push(first);
		check[first] = true;
		while(!stack.empty()) {
			System.out.print(stack.pop()+" ");
		}
		for(int i=1;i<tree.length;i++) {
			if(tree[first][i]==1&&!check[i]) {
				dfs(i,tree,check);
			}
		}
	}
	
	private static void bfs(int first,int[][] tree,boolean[] check) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(first);
		check[first]=true;
		while(!q.isEmpty()) {
			int start = q.poll();
			System.out.print(start+" ");
			for(int i=1;i<tree.length;i++) {
				if(tree[start][i]==1&&!check[i]) {
					q.offer(i);
					check[i]=true;
				}
			}
		}
		
	}

	

}
