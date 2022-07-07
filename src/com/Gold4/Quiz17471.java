package com.Gold4;

import java.io.*;
import java.util.*;

public class Quiz17471 {

	static int N;
	static int[] population;
	static boolean[] selected;
	static boolean[] visited;
	static int[][] adjMatrix;
	static int ans=0;
	
	public static void main(String[] args) throws Exception{
		// 게리맨더링
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		population = new int[N];
		adjMatrix = new int[N][N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}
		
		//System.out.println(Arrays.toString(population));
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int temp = Integer.parseInt(st.nextToken());
			for(int j=0;j<temp;j++) {
				int nodeNum = Integer.parseInt(st.nextToken())-1;
				adjMatrix[i][nodeNum] = 1;
			}
		}
		
		//for(int[] i : adjMatrix) System.out.println(Arrays.toString(i));
		ans = Integer.MAX_VALUE;
		//subSet(0);
		//굳이 다 할 필요도 없고 공집합과 전체를 제외하면 이득이기때문에
		//반복문 + 조합으로 접근
		
		for(int r=1; r<=N/2; r++) {
			selected = new boolean[N];
			comb(0,0,r);
		}
		
		if(ans == Integer.MAX_VALUE) ans = -1;
		
		System.out.println(ans);

		br.close();
	}

	/**
	 * 
	 * @param cnt
	 * @param start
	 * @param r 현재 조합의 뽑는 개수
	 */
	private static void comb(int cnt, int start, int r) {
		
		if(cnt==r) {
			
			if(isConnected()) {
				ans = Math.min(ans,getPopulation());
			}
			
			return;
		}
		
		for(int i=start;i<N;i++) {
			selected[i] = true;
			comb(cnt+1,i+1,r);
			selected[i] = false;
		}
		
	}


	private static boolean isConnected() {
		visited = new boolean[N];
		
		for(int i=0;i<N;i++) {
			if(selected[i]) {
				dfs(i,true);
				break;
			}
		}
		
		for(int i=0;i<N;i++) {
			if(!selected[i]) {
				dfs(i,false);
				break;
			}
		}
		
		for(int i=0;i<N;i++) {
			if(!visited[i]) return false;
		}
		
		return true;
	}
	
	private static void dfs(int from,boolean area) {
		visited[from] = true;
		
		for(int to=0;to<N;to++) {
			if(adjMatrix[from][to]!=0 && !visited[to] && selected[to]==area) {
				dfs(to,area);
			}
		}
		
	}

	private static int getPopulation() {
		int Asum=0;
		int Bsum=0;
		
		for(int i=0;i<N;i++) {
			if(selected[i]) Asum += population[i];
			else Bsum += population[i];
		}
		
		return Math.abs(Asum-Bsum);
	}


	private static void subSet(int cnt) {
		if(cnt==N) {
			//System.out.println(Arrays.toString(selected));
			//System.out.println("-------------------------");
			if(isSelected()&&isConnected()) {
				ans = Math.min(ans, getPopulation());
			}
			return;
		}
		
		selected[cnt] = true;
		subSet(cnt+1);
		selected[cnt] = false;
		subSet(cnt+1);
	}
	
	private static boolean isSelected() {
		boolean checkA=false;
		boolean checkB=false;
		for(int i=0;i<N;i++) {
			if(selected[i]) continue;
			checkA = true;
		}
		for(int i=0;i<N;i++) {
			if(!selected[i]) continue;
			checkB = true;
		}
		if(checkA&&checkB) return true;
		else return false;
	}
}

