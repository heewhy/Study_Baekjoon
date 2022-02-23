package com.Gold3;

import java.io.*;
import java.util.*;

public class Quiz16236 {
	
	static int N;
	static int[][] map;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception{
		// 아기 상어
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());

		int x = -1, y = -1;
		map = new int[N][N];

		// 입력받으며 상어 위치 파악
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				// 상어 위치 저장, map에서 0으로 초기화
				if (map[i][j] == 9) {
					x = i;
					y = j;
					map[i][j] = 0;
				}
			}
		}

		int time = 0; // 시간초 -> time++, count++
		int level = 2; // 상어의 레벨
		int count = 0; // 현재 레벨에서 먹은 개수

		while (true) {

			/* 진행상황 테스트
			System.out.println("now lv: "+level+"/ now cnt: "+count);
			for(int[] iii: map){
				System.out.println(Arrays.toString(iii));
			}
			System.out.println("*********");
			 */

			Shark next = bfs(x, y, level);

			// 먹을 상어가 존재할 경우
			if(next != null){
				map[x][y] = 0;
				time += next.distance;

				// 만약 레벨 수만큼 먹었다면, 레벨업
				if (++count == level) {
					++level;
					count = 0;
				}

				// 상어 이동
				x = next.x;
				y = next.y;
				map[x][y] = 0;

			} else {
				break;
			}
		}
		sb.append(time);
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}

	private static Shark bfs(int x, int y, int level) {

		ArrayList<Shark> list = new ArrayList<>(); // 같은 distance가 같은 상어들이 저장될 ArrayList
		boolean[][] isVisited = new boolean[N][N]; // 방문 저장용 배열
		Queue<int[]> queue = new LinkedList<>(); // bfs를 진행할 큐

		int count = 0;
		isVisited[x][y] = true;
		queue.offer(new int[] { x, y, count });

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			x = now[0];
			y = now[1];
			count = now[2];

			// 리스트에 후보 상어가 들어와있을 경우에,
			// 현재 탐색할 상어의 거리가 리스트 내의 상어보다 크다면 탐색 종료
			if(!list.isEmpty() && list.get(0).distance < count){
				break;
			}

			// 현재 상어의 정보를 ArrayList에 저장
			if(map[x][y] < level && map[x][y] != 0){
				list.add(new Shark(x, y, count));
			}

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= N)
					continue;

				if (map[nx][ny] > level || isVisited[nx][ny])
					continue;

				queue.offer(new int[] { nx, ny, count + 1 });
				isVisited[nx][ny] = true;
			}
		}

		// 탐색을 마쳤을 때, 후보 상어들이 없다면 null return
		if (list.isEmpty()){
			return null;
		}

		// 후보 상어가 있다면, 정렬 후 거리가 가장 가까운 상어 중 상, 좌 우선순위로 가장 첫 상어 return
		Collections.sort(list);
		return list.get(0);
	}

	static class Shark implements Comparable<Shark> {
		int x;
		int y;
		int distance;

		public Shark(int x, int y, int distance) {
			super();
			this.x = x;
			this.y = y;
			this.distance = distance;
		}

		@Override
		public int compareTo(Shark o) {
			if (this.distance != o.distance) {
				return this.distance - o.distance;
			}

			if (this.x != o.x) {
				return this.x - o.x;
			}

			return this.y - o.y;
		}

	}
}