package com.Gold4;

import java.io.*;
import java.util.*;

public class Quiz16235 {
	
	static class Tree implements Comparable<Tree>{
		int x;
		int y;
		int age;

		Tree(int x, int y, int age) {
			this.x = x;
			this.y = y;
			this.age = age;
		}

		@Override
		public int compareTo(Tree t) {
			return this.age - t.age;
		}		
		
	}
	
	static int N, M, K;
	static int[][] A;
	static int[][] map;
	static ArrayList<Tree> trees = new ArrayList<>();
	static ArrayList<Tree> liveTrees;
	static ArrayList<Tree> deadTrees;
	static int[] dr = {-1,-1,-1,0,0,1,1,1};
	static int[] dc = {-1,0,1,-1,1,-1,0,1};
	
	public static void main(String[] args) throws Exception{
		// 나무 제테크
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		A = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = 5;
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			trees.add(new Tree(Integer.parseInt(st.nextToken()) - 1, 
					Integer.parseInt(st.nextToken()) - 1,
					Integer.parseInt(st.nextToken())));

		}
		
		while(K-->0) {
			//for(int[] i : map) System.out.println(Arrays.toString(i));
			liveTrees = new ArrayList<>();
			deadTrees = new ArrayList<>();
			Collections.sort(trees);
			spring();
			summer();
			fall();
			winter();
		}
		
		System.out.println(trees.size());
		br.close();
	}
	

	private static void spring() {
		//자신의 나이만큼 양분(나무가 있는 칸만)을 먹기
		//여러개의 나무 -> 나이가 어린 나무부터 양분 먹기
		for (int i = 0; i < trees.size(); i++) {
			Tree t = trees.get(i);
			if (t.age > map[t.x][t.y]) {
				deadTrees.add(t);
			} else {
				map[t.x][t.y] -= t.age;
				t.age += 1;
				liveTrees.add(t);
			}
		}
		// 나무 리스트 리셋 후 살아있는 나무로 초기화
		trees.clear();
		trees.addAll(liveTrees);
	}
	private static void summer() {
		//죽은 나무 양분으로 변환 죽은 나무 나이 /2
		for (int i = 0; i < deadTrees.size(); i++) {
			Tree t = deadTrees.get(i);
			map[t.x][t.y] += t.age / 2;
		}
	}
	private static void fall() {
		//나무의 나이가 5의 배수라면 번식
		//인접한 8개의 칸에 나이가 1인 나무가 생김
		for (int i = 0; i < trees.size(); i++) {
			Tree t = trees.get(i);
			if (t.age % 5 == 0) {
				for (int j = 0; j < 8; j++) {
					int px = t.x + dc[j];
					int py = t.y + dr[j];
					if (0 <= px && px < N && 0 <= py && py < N) {
						trees.add(new Tree(px, py, 1));
					}
				}
			}
		}
	}
	private static void winter() {
		//양분 추가
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] += A[i][j];
			}
		}
	}

}
