package com.Gold5;

import java.io.*;
import java.util.*;

public class Quiz15686 {
	
	static ArrayList<int[]> cases = new ArrayList<>();
	static int[] index;
	static int N, M;
	static int chickenCount;

	public static void combi(int cnt, int start) {
		if (cnt == M) {
			cases.add(Arrays.copyOf(index, index.length));
			return;
		}

		for (int i = start; i < chickenCount; i++) {
			index[cnt] = i;
			combi(cnt + 1, i + 1);
		}

	}	

	public static void main(String[] args) throws Exception{
		// 치킨 배달
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];

		ArrayList<int[]> chickens = new ArrayList<>();
		ArrayList<int[]> houses = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					chickens.add(new int[] { i, j });
				} else if (map[i][j] == 1) {
					houses.add(new int[] { i, j });
				}
			}
		}

		chickenCount = chickens.size();

		index = new int[M];
		combi(0, 0);
		int shortestCase = Integer.MAX_VALUE;
		for (int[] ints : cases) {
			// ints = [0,1,2]
			int total = 0;
			for (int[] house : houses) {
				// 각 집들에 대해서...
				int shortest = Integer.MAX_VALUE;
				for (int i = 0; i < ints.length; i++) {
					int[] nowChicken = chickens.get(ints[i]);
					int dist = Math.abs(house[0] - nowChicken[0]) + Math.abs(house[1] - nowChicken[1]);
					if (dist < shortest) {
						shortest = dist;
					}
				}
				total += shortest;
			}
			if (total < shortestCase) {
				shortestCase = total;
			}
		}
		sb.append(shortestCase);
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}

}
