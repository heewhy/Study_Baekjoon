package com.Gold4;

import java.io.*;
import java.util.*;

public class Quiz4485 {
	
	
  	static int dr[] = {-1,0,1,0};
 	static int dc[] = {0,1,0,-1};
	static int[][] cave;
	static int[][] dp;
	static int N;
  
  public static void main(String[] args) throws Exception{
	// 녹색 옷 입은 애가 젤다지?
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	
	
	int tc=0;
	while(true) {
		 N = Integer.parseInt(br.readLine());
		
		if(N==0) break;
		
		cave = new int[N][N];
		dp = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				cave[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = Integer.MAX_VALUE;
			}
		}
		bfs(0,0);
		
		++tc;
		System.out.println("Problem "+tc+": "+dp[N-1][N-1]);
	}
	
	br.close();
	}

  	
	private static void bfs(int i, int j) {
		LinkedList<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {i,j});
		dp[i][j] = cave[i][j];
		
				
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			int r = temp[0];
			int c = temp[1];
			
			for(int d=0;d<4;d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				
				if(nr>=0&&nc>=0&&nr<N&&nc<N) {
					if (dp[nr][nc] > dp[r][c] + cave[nr][nc]) {
						dp[nr][nc] = dp[r][c] + cave[nr][nc];
						q.add(new int[] {nr, nc});
					}
				}
			}
			
		}
	}
		
		
}
/* 메모리 초과
 * 1. 다익스트라
 * 2. 우선순위큐 (bfs)
package com.Gold4;

import java.io.*;
import java.util.*;

public class Quiz4485 {
	
	
  	static int dr[] = {-1,0,1,0};
 	static int dc[] = {0,1,0,-1};
	static int[][] cave;
	static int[][] dp;
	static boolean[][] visited;
	static int N;
	static int ans;
  
  public static void main(String[] args) throws Exception{
	// 녹색 옷 입은 애가 젤다지?
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	
	
	int tc=0;
	while(true) {
		 N = Integer.parseInt(br.readLine());
		
		if(N==0) break;
		
		cave = new int[N][N];
		dp = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				cave[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//for(int[] i :cave)System.out.println(Arrays.toString(i));
		ans= Integer.MAX_VALUE;
		bfs(0,0);
		
		++tc;
		System.out.println("Problem "+tc+": "+ans);
	}
	
	br.close();
	}


	private static void bfs(int i, int j) {
		LinkedList<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {i,j,cave[i][j]});
		visited[i][j] = true;
		dp[i][j] = cave[i][j];
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			int r = temp[0];
			int c = temp[1];
			//System.out.println("R : "+r);
			//System.out.println("C : "+c);
			visited[r][c] = true;
			if(r==N-1&&c==N-1) ans = Math.min(ans, temp[2]);
			
			for(int d=0;d<4;d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				
				if(nr>=0&&nc>=0&&nr<N&&nc<N) {
					if(!visited[nr][nc]||dp[nr][nc]>temp[2]+cave[nr][nc]) {
						q.add(new int[] {nr,nc,temp[2]+cave[nr][nc]});
						dp[nr][nc] = temp[2]+cave[nr][nc];
					}
				}
			}
			
		}
		
		
	}
		
}

 */

