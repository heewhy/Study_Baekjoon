package com.Gold5;

import java.io.*;
import java.util.*;

public class Quiz16234 {
	
	static int N,L,R;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {1, 0, -1, 0};
	static int[] dc = {0, 1, 0, -1};
	static ArrayList<Node> list;

	public static void main(String[] args) throws Exception{
		// 인구이동
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(getDays());
		
		br.close();
	}

	private static int getDays() {
		 int result = 0;
	        while(true) {
	            boolean isMove = false;
	            visited = new boolean[N][N];
	            for(int i = 0; i < N; i++) {
	                for(int j = 0; j < N; j++) {
	                    if(!visited[i][j]) {
	                        int sum = bfs(i, j); 
	                        if(list.size() > 1) {
	                            changePopulation(sum); 
	                            isMove = true;
	                        }    
	                    }
	                }
	            }
	            if(!isMove) return result;;
	            result++;
	        }
	}
	
	public static int bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        list = new ArrayList<>();
        
        q.offer(new Node(x, y));
        list.add(new Node(x, y));
        visited[x][y] = true;
        
        int sum = map[x][y];
        while(!q.isEmpty()) {
            Node current = q.poll();
            
            for(int i = 0; i < 4; i++) {
                int nx = current.x + dc[i];
                int ny = current.y + dr[i];
                if(nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
                    int diff = Math.abs(map[current.x][current.y] - map[nx][ny]);
                    if(L <= diff && diff <= R) {
                        q.offer(new Node(nx, ny));
                        list.add(new Node(nx, ny));
                        sum += map[nx][ny];
                        visited[nx][ny] = true;
                    }        
                }
            }
        }
        return sum;
    }
    
    public static void changePopulation(int sum) {
        int avg = sum / list.size();
        for(Node n : list) {
            map[n.x][n.y] = avg;
        }
    }
    
    public static class Node {
        int x; 
        int y;
        
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
