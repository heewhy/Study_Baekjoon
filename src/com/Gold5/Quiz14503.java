package com.Gold5;

import java.io.*;
import java.util.*;

public class Quiz14503 {

    public static int N, M;
    public static int[][] map;
    public static int ans = 0;
    public static int[] dr = {-1, 0, 1, 0}; 
    public static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception{
		// 로봇 청소기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st ;
		
		st= new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        clean(r, c, dir);
		
        bw.write(ans + "\n");
        
		br.close();
		bw.flush();
		bw.close();
	}

	public static void clean(int row, int col, int dir) {
        //청소
		if (map[row][col] == 0) {
            map[row][col] = 2;
            ans++;
        }
		
		//왼쪽탐색
        boolean wall = false;
        int origin = dir;
        for (int i = 0; i < 4; i++) {
            int ndir = (dir + 3) % 4;
            int r = row + dr[ndir];
            int c = col + dc[ndir];

            if (r > 0 && c > 0 && r < N && c < M) {
                //청소하기전
            	if (map[r][c] == 0) {  
                    clean(r, c, ndir);
                    wall = true;
                    break;
                }
            }
            dir = (dir + 3) % 4;
        }
        
        //벽일때
        if (!wall) {
            int ndir = (origin + 2) % 4;
            int br = row + dr[ndir];
            int bc = col + dc[ndir];

            if (br > 0 && bc > 0 && br < N && bc < M) {
                if (map[br][bc] != 1) {
                    clean(br, bc, origin);
                }
            }
        }
    }
}


