package com.Gold4;

import java.io.*;
import java.util.*;

public class Quiz15685 {

	static boolean[][] map = new boolean[101][101];
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,-1,0,1};
	
	public static void main(String[] args) throws Exception{
		// 드래곤 커브
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int dragonCurveCount = Integer.parseInt(input.readLine());
		
		
		while(dragonCurveCount-->0) {
			st = new StringTokenizer(input.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int direction = Integer.parseInt(st.nextToken());
			int generation = Integer.parseInt(st.nextToken());
			
			dragonCurve(x,y,direction,generation);
		}
		
		int ans = 0;
		for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] && map[i][j + 1] && map[i + 1][j] && map[i + 1][j + 1]) {
                    ans++;
                }
            }
        }
		
		System.out.println(ans);
		input.close();
	}

	public static void dragonCurve(int x, int y, int d, int g) {
        List<Integer> d_list = new ArrayList<>();
        d_list.add(d);

        for (int i = 1; i <= g; i++) {
            for (int j = d_list.size() - 1; j >= 0; j--) {
                d_list.add((d_list.get(j) + 1) % 4);
            }
        }

        map[y][x] = true;
        for (Integer direction : d_list) {
            x += dx[direction];
            y += dy[direction];
            map[y][x] = true;
        }
    }

}
