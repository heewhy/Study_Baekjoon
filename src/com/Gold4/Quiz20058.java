package com.Gold4;

import java.io.*;
import java.util.*;

public class Quiz20058 {
    static int N, Q, total;
    static int[][] map;
    static int[] L;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};

    public static void main(String[] args) throws Exception {
    	//마법사 상어와 파이어스톰
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        N = (int) Math.pow(2, N);

        map = new int[N][N];
        for (int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<N;j++) {
            	int ice = Integer.parseInt(st.nextToken());
            	map[i][j] = ice;
            	total+=ice;
            }
        }

        L = new int[Q];
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<Q;i++) {
            L[i] = Integer.parseInt(st.nextToken());
        }
        for(int depth : L) {
        	map = divideMap(depth);
        	map = melt();
        }
        System.out.println(total);
        System.out.println(findBigIce());
        
        br.close();
    }

    static int[][] divideMap(int depth) {
        int[][] temp = new int[N][N];
        depth = (int) Math.pow(2, depth);

        for (int i=0;i<N;i+=depth) {
            for (int j=0;j<N;j+=depth) {
                rotate(i,j,depth,temp);
            }
        }
        return temp;
    }

    static void rotate(int r, int c, int len, int[][] temp) {
        for (int i=0;i<len;i++) {
            for (int j=0;j<len;j++) {
                temp[r+j][c+len-i-1] = map[r+i][c+j];
            }
        }
    }

    static int[][] melt() {
        int[][] temp = new int[N][N];

        for (int i=0;i<N;i++) {
            temp[i] = Arrays.copyOf(map[i], N);
        }

        for (int r=0;r<N;r++) {
            for (int c=0;c<N;c++) {
                int cnt = 0;
                if (map[r][c] == 0)
                    continue;
                for (int d=0;d<4;d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if (isIn(nr,nc) && map[nr][nc]>0) {
                        cnt++;
                    }
                }
                if (cnt<3) {
                    temp[r][c]--;
                    total--;
                }
            }
        }
        return temp;
    }

    static int findBigIce() {
        boolean[][] visited = new boolean[N][N];
        LinkedList<int[]> q = new LinkedList<>();
        int land = 0;
        for (int i=0;i<N;i++) {
            for (int j=0;j<N;j++) {
                if (map[i][j]>0 && !visited[i][j]) {
                    q.offer(new int[] { i, j });
                    visited[i][j] = true;
                    int count = 1;
                    while (!q.isEmpty()) {
                        int[] temp = q.poll();
                        int r = temp[0];
                        int c = temp[1];

                        for (int d=0;d<4;d++) {
                            int nr = r + dr[d];
                            int nc = c + dc[d];

                            if (isIn(nr, nc) && map[nr][nc]>0 && !visited[nr][nc]) {
                                count++;
                                visited[nr][nc] = true;
                                q.offer(new int[] { nr, nc });
                            }
                        }
                    }
                    land = Math.max(count, land);
                }
            }
        }
        return land;
    }

    static boolean isIn(int r, int c) {
        return r>=0 && r<N && c>=0 && c<N;
    }

	private static void print() {
		for(int[] i: map) {
			for(int j: i) {
				System.out.print(j);
			}
			System.out.println();
		}
		System.out.println("===================================");
	}
}
