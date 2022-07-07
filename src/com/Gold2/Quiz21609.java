package com.Gold2;

import java.io.*;
import java.util.*;

public class Quiz21609 {
	
	static int N,M,score;
	static int[][] map;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	static class blockInfo implements Comparable<blockInfo>{
		int shape,size,rainbowCnt,r,c;
		LinkedList<int[]> hasBlock = new LinkedList<int[]>();

		public blockInfo(int shape, int size, int rainbowCnt, int r, int c) {
			super();
			this.shape = shape;
			this.size = size;
			this.rainbowCnt = rainbowCnt;
			this.r = r;
			this.c = c;
		}

		@Override
		public int compareTo(blockInfo o) {
			if(this.size==o.size) {
				if(this.rainbowCnt==o.rainbowCnt) {
					if(this.r==o.r) return o.c-this.c;
					return o.r-this.r;
				}
				return o.rainbowCnt-this.rainbowCnt;
			}
			return o.size-this.size;
		}
		
	}

	public static void main(String[] args) throws Exception{
		// 상어 중학교
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		playAuto();
		
		System.out.println(score);
		
		br.close();
	}

	private static void playAuto() {
		while(removeBigBlock()) {
			//System.out.println("블록제거");
			//print();
			applyGravity();
			//System.out.println("중력작용");
			//print();
			map = rotateMap();
			//System.out.println("블록회전");
			//print();
			applyGravity();
			//System.out.println("중력작용");
			//print();
		}
	}

	private static boolean removeBigBlock() {
		boolean[][] visited = new boolean[N][N];
		PriorityQueue<blockInfo> pq = new PriorityQueue<>();
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!isShape(i,j)||visited[i][j]) continue;
				
				getBlockSize(i,j,pq,visited,new boolean[N][N]);
			}
		}
		
		blockInfo bi = pq.poll();
		
		//사이즈가 2가안됨 게임종료
		if(bi==null||bi.size<2) {
			return false;
		}
		
		score += bi.size*bi.size;
		
		//가장 큰 블록 삭제 (-2)
		while(!bi.hasBlock.isEmpty()) {
			int[] temp = bi.hasBlock.poll();
			int r = temp[0];
			int c = temp[1];
			map[r][c] = -2;
		}
		
		return true;
	}
	
	/**
	 * 벽이거나 무지개블록일때 false
	 * 숫자면 true
	 * @param i
	 * @param j
	 * @return
	 */
	private static boolean isShape(int i, int j) {
		return map[i][j]>0;
	}

	private static void getBlockSize(int i, int j, PriorityQueue<blockInfo> pq, boolean[][] visited, boolean[][] bfsvisited) {
		LinkedList<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {i,j});
		visited[i][j] = true;
		bfsvisited[i][j] = true;
		blockInfo bi = new blockInfo(map[i][j],1,0,i,j); //모양, 크기, 레인보우블록 개수, 좌표
		bi.hasBlock.add(new int[]{i,j});
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			int r = temp[0];
			int c = temp[1];
			
			for(int d=0;d<4;d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(isInMap(nr,nc)&&!bfsvisited[nr][nc]&&map[nr][nc]>=0) {
					//무지개 블록일 때
					if(map[nr][nc]==0) {
						bfsvisited[nr][nc] = true;
						q.offer(new int[] {nr,nc});
						bi.size++;
						bi.rainbowCnt++;
						bi.hasBlock.add(new int[] {nr,nc});
					}
					//같은 블록일 때
					else if(map[nr][nc]==bi.shape) {
						bfsvisited[nr][nc] = true;
						visited[nr][nc] = true;
						q.offer(new int[] {nr,nc});
						bi.size++;
						bi.hasBlock.add(new int[] {nr,nc});
					}
				}
			}
		}
		pq.add(bi);
	}

	private static boolean isInMap(int r, int c) {
		return r>=0&&c>=0&&r<N&&c<N;
	}

	private static void applyGravity() {
		// TODO 밑에서부터 내리면서 -2가 아닐때 까지인가
		for(int r=N-2;r>=0;r--) {
			for(int c=0;c<N;c++) {
				//벽이거나 빈공간일때
				if(map[r][c]<0) continue;
				
				int height = r;
				while(height+1<N&&map[height+1][c]==-2) {
					map[height+1][c] = map[height][c];
					map[height][c] = -2;
					height++;
				}
			}
		}
	}

	private static int[][] rotateMap() {
		// TODO 90도 반시계 회전
		int[][] temp = new int[N][N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				temp[i][j] = map[j][N-i-1];
			}
		}
		
		return temp;
	}
	
	private static void print() {
		for(int[] i : map) System.out.println(Arrays.toString(i));
		System.out.println("=======================================");
	}

}
