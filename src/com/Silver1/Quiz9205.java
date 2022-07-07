package com.Silver1;

import java.io.*;
import java.util.*;

public class Quiz9205 {
	
	public static void main(String[] args) throws Exception{
		// 맥주 마시면서 걸어가기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			
			int N = Integer.parseInt(br.readLine());
			
			//집 좌표
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			//편의점 좌표
			List<int[]> stores = new ArrayList<int[]>();
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				stores.add(new int[] {a,b});
			}
			
			//축제 좌표
			st = new StringTokenizer(br.readLine());
			int endX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());
			
			if(isValid(N,x,y,stores,endX,endY)){
				System.out.println("happy");
			}else {
				System.out.println("sad");
			}
		}
		
		br.close();
	}

	/**
	 * BFS
	 * @param n
	 * @param x
	 * @param y
	 * @param stores
	 * @param endX
	 * @param endY
	 * @return
	 */
	private static boolean isValid(int n, int x, int y, List<int[]> stores, int endX, int endY) {
		
		Queue<int[]> q = new LinkedList<int[]>();
		boolean[] visited = new boolean[n];
		q.offer(new int[] {x,y});
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			int curX = temp[0];
			int curY = temp[1];
			
			//도착지까지 갈 수 있다면
			if(getDistance(curX, endX, curY, endY)<=1000) {
				return true;
			}
			
			for(int i=0;i<n;i++) {
				
				if(visited[i]) continue;
				
				//편의점 좌표
				int nX = stores.get(i)[0];
				int nY = stores.get(i)[1];
				
				int dist = getDistance(curX,nX,curY,nY);
				//1000m 안쪽이면 갈수있다.
				if(dist<=1000) {
					visited[i] = true;
					q.offer(new int[] {nX,nY});
				}
					
				
			}
		}
	
		return false;
	}
	
	/**
	 * 맨해튼 거리 공식
	 * @param x1
	 * @param x2
	 * @param y1
	 * @param y2
	 * @return
	 */
	private static int getDistance(int x1,int x2,int y1,int y2) {
		return Math.abs(x1-x2)+Math.abs(y1-y2);
	}

}
