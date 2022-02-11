package com.Gold3;

import java.io.*;
import java.util.*;

public class Quiz1167 {
	
	static int N,depth,result[],tree[][],length[][];
	static boolean check,visited[];

	public static void main(String[] args) throws Exception{
		// 트리의 지름
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		tree = new int[N+1][N+1];
		result = new int[N+1];
		length = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		while(N-->0) {
			st= new StringTokenizer(br.readLine());

			int i = Integer.parseInt(st.nextToken());
			while(st.countTokens()!=1) {
				int j = Integer.parseInt(st.nextToken());
				int k = Integer.parseInt(st.nextToken());
				tree[i][j] = 1;
				tree[j][i] =1;
				length[i][j] = k;
				length[j][i] = k;
			}
			st.nextToken();
		}
		
		dfs(1,1);
		
		//System.out.println("result :"+Arrays.toString(result));
		
		
		
		br.close();
		bw.flush();
		bw.close();
	}//main
	
	//깊이 우선 탐색
	private static void dfs(int first,int depth) {
		Stack<Integer> stack = new Stack<>();
		stack.push(first);
		visited[first] = true;
		while(!stack.empty()) {
			int end = stack.pop();
			//System.out.println("end  :" +end);
			//System.out.println("depth : "+depth);
			if(result[depth]!=0)result[depth]=end;
			
		}
		for(int i=1;i<tree.length;i++) {
			if(tree[first][i]==1&&!visited[i]) {
				dfs(i,depth+1);
			}
		}			
		
	}

}
