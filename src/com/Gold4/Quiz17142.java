package com.Gold4;

import java.io.*;
import java.util.*;

public class Quiz17142 {
	
	static int N,M,ans,zeroCnt;
	static int[][] map;
	static LinkedList<int[]> virus = new LinkedList<int[]>();
	static int[] dr = {-1,0,1,0}; //상우하좌
	static int[] dc = {0,1,0,-1};

	public static void main(String[] args) throws Exception{
		// 연구소 3
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); //활성화할 바이러스 개수
		
		map = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==2) {
					//바이러스 더해주기
					virus.add(new int[] {i,j});
				}
				if(map[i][j]==0) {
					//빈공간 세기
					zeroCnt++;
				}
			}
		}
		
		ans = Integer.MAX_VALUE;
		getSpreadMinTime(new int[M],0,0);
		
		//맵이 이미 바이러스로 가득차있는경우
		if(zeroCnt==0) System.out.println(0);
		//방법이없다면 -1
		else System.out.println(ans==Integer.MAX_VALUE?-1:ans);
		
		br.close();
	}

	/**
	 * 조합으로 바이러스 뽑기
	 * @param selected
	 * @param cnt
	 * @param start
	 */
	private static void getSpreadMinTime(int[] selected,int cnt, int start) {
		if(cnt==M) {
			LinkedList<int[]> selectedVirus = new LinkedList<int[]>();
			boolean[][] visited = new boolean[N][N];
			//선택된 virus
			for(int i=0;i<M;i++) {
				selectedVirus.add(virus.get(selected[i]));
				visited[virus.get(selected[i])[0]][virus.get(selected[i])[1]] = true;
			}
			
			//map 복사
			int[][] copyMap = new int[N][N];
			for(int i=0;i<N;i++) {
				copyMap[i] = map[i].clone();
			}
			
			spreadVirus(copyMap,selectedVirus,visited,zeroCnt);
			
			return;
		}
		
		for(int i=start;i<virus.size();i++) {
			selected[cnt] = i;
			getSpreadMinTime(selected,cnt+1,i+1);
		}

	}

	/**
	 * 바이러스를 너비우선탐색으로 퍼트리기
	 * @param copyMap
	 * @param selectedVirus
	 * @param visited
	 * @param total
	 */
	private static void spreadVirus(int[][] copyMap, LinkedList<int[]> selectedVirus, boolean[][] visited, int total) {
		int time = 0;
		while(!selectedVirus.isEmpty()) {
			int size = selectedVirus.size();
			
			for(int i=0;i<size;i++) {
				
				int temp[] = selectedVirus.poll();
				int r = temp[0];
				int c = temp[1];
				
				for(int d=0;d<4;d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					
					if(nr>=0&&nc>=0&&nr<N&&nc<N&&!visited[nr][nc]) {
						//벽인경우 패스
						if(copyMap[nr][nc]==1) continue;
						
						//바이러스 퍼트리기
						if(copyMap[nr][nc]==0) {
							visited[nr][nc] = true;
							total--;
							if(total==0) {
								ans = Math.min(ans, time+1);
							}
							copyMap[nr][nc] = 2;
							selectedVirus.add(new int[] {nr,nc});
						}
						//비활성화 바이러스 활성화해주기
						if(copyMap[nr][nc]==2) {
							visited[nr][nc] = true;
							selectedVirus.add(new int[] {nr,nc});
						}
						
					}
				}
				
			}
			time++;
		}
		
	}

}
