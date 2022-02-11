package com.Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class CountWorm {
	static boolean[][] map;
	static boolean[][] check;
	static int count;

	public static void main(String[] args) throws Exception{
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Queue<int[]> q = new LinkedList<>();
		
		int testCase = Integer.parseInt(reader.readLine());
		
		for(int tc = 1; tc <= testCase; tc++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			int n = Integer.parseInt(st.nextToken()); //가로 c
			int m = Integer.parseInt(st.nextToken()); //세로 r
			int v = Integer.parseInt(st.nextToken());
			
			//맵 정보 입력
			map = new boolean[m][n];
			check = new boolean[m][n];
			for(int i = 0; i < v; i++) {
				st = new StringTokenizer(reader.readLine());
				
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				map[r][c] = true;
			}
			
			//배추가 있고 아직 탐색하지 않은 배추라면
			for(int i = 0; i < m; i++)
				for(int j = 0; j < n; j++) {
					if(map[i][j] && !check[i][j]) {
						q.add(new int[] {i, j});
						
						bfs(q);
					}
				}
			
			System.out.println(count);
			count = 0;
		}
	}
	
	public static void bfs(Queue<int[]> q) {
		System.out.println("-------------------------------------------");
		//위, 아래, 오른쪽, 왼쪽
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, 1, -1};
		
		while(!q.isEmpty()) {
			int[] forcheck = q.poll();
			int r = forcheck[0];
			int c = forcheck[1];
			System.out.println("r : "+r);
			System.out.println("c : "+c);
			System.out.println("++++++++++++");
			//for(boolean[] a : map)System.out.println(Arrays.toString(a));System.out.println();
			check[r][c]=true;
			for(int i = 0; i < 4; i++) {
				if(r + dr[i] < map.length && r + dr[i] >= 0 && c + dc[i] < map[r].length && c + dc[i] >= 0 && //탐색할 칸이 범위 내면
						map[r + dr[i]][c + dc[i]] && !check[r + dr[i]][c + dc[i]]) { //그 칸에 배추가 있으면, 탐색 안한 거면
					//check[r + dr[i]][c + dc[i]] = true;			//왜 얘를 61번에 넣으면 안돼?
					q.add(new int[] {r + dr[i], c + dc[i]}); //큐 탐색 대기열에 추가
				}
			}
		}
		count++;
	}

}
