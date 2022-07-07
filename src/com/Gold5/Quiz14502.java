package com.Gold5;

import java.io.*;
import java.util.*;

public class Quiz14502 {

	static int N,M,ans;
	static int[][] map;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};

	public static void main(String[] args) throws Exception{
		// 연구소
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		makeWall(0);
		
		System.out.println(ans);
		
		br.close();
	}

	/**
	 * 벽 세우기
	 * @param cnt 세운 벽의 개수
	 */
	private static void makeWall(int cnt) {
		
		//벽 3개를 세운 경우
		if(cnt==3) {
			int[][] temp = new int[N][M];
			for(int i=0;i<N;i++) {
				temp[i] = map[i].clone();
			}
			//바이러스 퍼지기
			spreadV(temp);
			return;
		}
		
		//모든 경우 벽 세우기
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]!=0) continue;
				
				map[i][j] = 1;
				makeWall(cnt+1);
				map[i][j] = 0;
			}
		}
		
	}

	/**
	 * 바이러스 퍼지기
	 * @param spMap
	 */
	private static void spreadV(int[][] spMap) {
		Queue<int[]> q = new LinkedList<int[]>();
		
		//바이러스 담기
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(spMap[i][j]==2) {
					q.add(new int[] {i,j});
				}
			}
		}
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			int r = temp[0];
			int c = temp[1];
			
			for(int d=0;d<4;d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr<0||nc<0||nr>=N||nc>=M||spMap[nr][nc]!=0) continue;
				
				spMap[nr][nc] = 2;
				q.add(new int[] {nr,nc});
			}
			
		}
		
		//0 개수 세기
		int zeroCnt=0;
		for(int[] i : spMap) {
			for(int j : i) {
				if(j==0) {
					zeroCnt++;
				}
			}
		}
		
		//최대 값 갱신
		ans = Math.max(ans, zeroCnt);
		
	}

}
/*
package com.Gold5;

import java.awt.Point;
import java.io.*;
import java.util.*;

public class Quiz14502 {

	public static int[][] map = new int[9][9];
    public static int[][] copy_map = new int[9][9];
    public static int[][] spread_map = new int[9][9];
    public static int N, M;
    public static int[] dr = {-1, 0, 1, 0};
    public static int[] dc = {0, -1, 0, 1};
    public static int ans = 0;
	
	public static void main(String[] args) throws Exception{
		// 연구소
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
		//연구소 가로세로
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		
		LinkedList<int[]> q = new LinkedList<int[]>();
		
		//연구소 정보 입력받기
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                copy_map[i][j] = map[i][j];
            }
        }
		
		//벽을 모든 경우의 수에 세워보고
		//2를 bfs 태웠을 때 최대 0의 값?
		
        makeWall(0);
        
        bw.write(ans + "\n");
		
		br.close();
		bw.flush();
		bw.close();
	}

	public static void makeWall(int cnt) {
        if (cnt == 3) { // 벽 3개 다 세웠을 경우
            spreadVirus();  // 바이러스 퍼뜨리기
            countZero();    // 안전 영역 카운트
            return;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (copy_map[i][j] == 0) {
                    copy_map[i][j] = 1;
                    makeWall(cnt + 1);
                    copy_map[i][j] = 0;
                }
            }
        }
    }

    public static void spreadVirus() {
        Queue<Point> q = new LinkedList<Point>();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                spread_map[i][j] = copy_map[i][j];
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (spread_map[i][j] == 2) {
                    q.add(new Point(i, j));
                }
            }
        }

        while (!q.isEmpty()) {
            int r = q.peek().x;
            int c = q.peek().y;
            q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr > 0 && nc > 0 && nr <= N && nc <= M) {
                    if (spread_map[nr][nc] == 0) {
                        spread_map[nr][nc] = 2;
                        q.add(new Point(nr, nc));
                    }
                }
            }
        }
    }

    public static void countZero(){
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (spread_map[i][j] == 0) {
                    cnt++;
                }
            }
        }
        ans = Math.max(ans, cnt);
    }
}
 */
 