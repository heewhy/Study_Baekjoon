package com.Gold5;

import java.io.*;
import java.util.*;

public class Quiz10026 {

	static int N;
	static char[][] map;
	static boolean[][] visited;
	static int[] dr = {-1,0,1,0};//상우좌하
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception{
		// 적록색약
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visited = new boolean[N][N];
		
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		//일반사람
		int cnt = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j]){
                    bfs(i,j);
                    cnt++;
                }
            }
        }
        
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j]=='G'){
                    map[i][j] = 'R'; // G를 R로 바꿔준다.
                }
            }
        }
        //적록색약
        int cnt2 = 0;
        visited = new boolean[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j]){
                    bfs(i,j);
                    cnt2++;
                }
            }
        }
        
        sb.append(cnt+" "+cnt2);
        bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}

	private static void bfs(int i, int j) {
		LinkedList<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {i,j});
		visited[i][j] = true;
		char c = map[i][j];
		
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			int row = temp[0];
			int col = temp[1];
			
			for(int d=0;d<4;d++) {
				int nr = row + dr[d];
				int nc = col + dc[d];
				
				if(nr>=0&&nc>=0&&nr<N&&nc<N&&!visited[nr][nc]&&map[nr][nc]==c) {
					visited[nr][nc] = true;
					queue.offer(new int[] {nr,nc});
				}
			}
			
		}
		
		
	}

}
