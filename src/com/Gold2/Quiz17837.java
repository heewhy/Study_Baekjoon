package com.Gold2;

import java.io.*;
import java.util.*;

public class Quiz17837 {
	
	static int N, K;
	static int[][] map;
	static Token[] tokens;
	static List<Integer>[][] list;
	static int[][] dir = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
	static int[] direct = {1, 0, 3, 2};

	static class Token {
		int r, c, d;

		public Token(int y, int x, int d) {
			this.r = y;
			this.c = x;
			this.d = d;
		}
	}
	
	public static void main(String[] args) throws Exception{
		// 새로운 게임2
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		list = new ArrayList[N][N];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				list[i][j] = new ArrayList<>();
			}
		}

		tokens = new Token[K];
		for (int i = 0; i < K; ++i) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken()) - 1;

			tokens[i] = new Token(r, c, d);
			list[r][c].add(i);
		}

		System.out.println(solve(1));
		br.close();
	}
	
	public static int solve(int turn) {
		if (turn > 1000) return -1;
		
		for (int i = 0; i < K; ++i) {
			if (moveTheNode(i) >= 4) {
				return turn;
			}
		}
		
		return solve(turn + 1);
	}
	
	public static int moveTheNode(int idx) {
		int r = tokens[idx].r;
		int c = tokens[idx].c;
		int d = tokens[idx].d;
		
		int ny = r + dir[d][0];
		int nx = c + dir[d][1];
		//이동할 벽이 파란 벽인 경우
		if (ny < 0 || nx < 0 || ny >= N || nx >= N || map[ny][nx] == 2) {
			tokens[idx].d = direct[d];
			ny = r + dir[tokens[idx].d][0];
			nx = c + dir[tokens[idx].d][1];
			//방향을 바꿔서 이동해도 파란 벽이면 종료
			if (ny < 0 || nx < 0 || ny >= N || nx >= N || map[ny][nx] == 2) {
				return list[r][c].size();
			}
		}
		
		int index = 0;
		int size = list[r][c].size();

		//현재 노드의 높이를 구함
		for (int i = 0; i < size; ++i) {
			if (list[r][c].get(i) == idx) {
				index = i;
				break;
			}
		}

		//이동할 벽이 빨간 벽이면 노드들의 순서를 변경
		if (map[ny][nx] == 1) {
			ArrayList<Integer> temp = new ArrayList<>();
			
			for (int i = index; i < size; ++i) {
				temp.add(list[r][c].get(i));
			}
			for (int i = 0; i < temp.size(); ++i) {
				list[r][c].remove(list[r][c].size() - 1);
			}
			for (int i = temp.size() - 1; i >= 0; --i) {
				list[r][c].add(temp.get(i));
			}
		}

		//노드들을 이동, 좌표도 변경해줌
		int cnt = 0;
		for (int i = index; i < list[r][c].size(); ++i) {
			int pos = list[r][c].get(i);
			tokens[pos].r = ny;
			tokens[pos].c = nx;
			list[ny][nx].add(pos);
			cnt++;
		}

		//이전의 노드 제거
		for (int i = 0; i < cnt; ++i) list[r][c].remove(list[r][c].size() - 1);

		return list[ny][nx].size();
	}

}
