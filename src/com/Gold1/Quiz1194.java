package com.Gold1;

import java.io.*;
import java.util.*;

public class Quiz1194 {

	static class Node{
		int r,c,key;

		public Node(int r, int c, int key) {
			super();
			this.r = r;
			this.c = c;
			this.key = key;
		}
		
		
	}
	
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int N,M;
	static char[][] map;
	static boolean[][][] visited; 
	
	public static void main(String[] args) throws Exception{
		// 달이 차오른다, 가자.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		visited = new boolean[N][M][64];
		
		Node start = null;
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j]=='0') {
					start = new Node(i,j,0);
				}
			}
		}
		
		bfs(start);
		
		System.out.println(-1);
		br.close();
	}
	
	private static void bfs(Node start) {
		Queue<Node> q = new LinkedList<>();
		
		//초기 탐색 정보 저장
		q.offer(start);
		visited[start.r][start.c][0] = true;
		
		int depth = 0;
		
		while(!q.isEmpty()) {
			
			int size = q.size();
			while(size-->0) {
				Node n = q.poll();
				int r = n.r;
				int c = n.c;
				
				//현재 위치가 도착 지점이라면 depth 출력 후 종료
				if(map[r][c] =='1') {
					System.out.println(depth);
					System.exit(0);
				}
				
				//사방 탐색
				for(int d=0;d<4;d++) {
					int nr = r+dr[d];
					int nc = c+dc[d];
					int key = n.key;
					
					//경계 벗어가거나, 벽을 만나거나, 현재 열쇠소지 정보인채로 방문한적이있다면? 다음 탐색
					if(nr<0||nr>=N||nc<0||nc>=M||map[nr][nc]=='#'||visited[nr][nc][key]) continue;
					
					int val = map[nr][nc];
					
					//열쇠를 찾은 경우
					if(isKey(val)) {
						//열쇠 정보 추가(비트 연산자 setter)
						key |= (1<<(val-'a'));
					}
					//문을 찾은 경우
					if(isDoor(val)){
						//열쇠가 없는 경우 지나갈 수 없기 때문에 continue;
						if((key & 1<<(val - 'A')) == 0) continue;
					}
					
					
					q.offer(new Node(nr,nc,key));
					visited[nr][nc][key] = true;
					
				}
				
			}
			depth++;
		}
		
	}

	private static boolean isKey(int val) {
		return 'a' <= val && val<='f';
	}
	private static boolean isDoor(int val) {
		return 'A' <= val && val <= 'F';
	}


}
/*

package com.Gold1;

import java.io.*;
import java.util.*;

//		System.out.println('a'^'A'); //32
//		System.out.println('b'^'B'); //32
public class Quiz1194 {

	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int N,M;
	static char[][] map;
	static boolean[][][] visited; 
	
	public static void main(String[] args) throws Exception{
		// 달이 차오른다, 가자.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		//0 열쇠 없는 경우 //1 a ...
		visited = new boolean[N][M][7];

		LinkedList<int[]> q = new LinkedList<int[]>();  
		
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j]=='0') {
					q.add(new int[] {i,j,0});
					visited[i][j][0] = true;
				}
			}
		}
		
		int step=0;
		while(!q.isEmpty()) {
			int size = q.size();
			
			for(int i=0;i<size;i++) {		
				int[] temp = q.poll();
				int r = temp[0];
				int c = temp[1];
				int keyNum = temp[2];
				
				for(int d=0;d<4;d++) {
					int nr = r+dr[d];
					int nc = c+dc[d];
					
					if(nr<0||nc<0||nr>=N||nc>=M||map[nr][nc]=='#'||visited[nr][nc][keyNum]) continue;
					//키를 줍지 않고 도달
					//키를 줍고 도달
					
					if(map[nr][nc]=='1') {
						System.out.println(step+1);
						System.exit(0);
					}
					
					if(map[nr][nc]!='.') {
						switch (map[nr][nc]) {
						case 'a':
							keyNum = 1;
							q.add(new int[] {nr,nc,keyNum});
							visited[nr][nc][keyNum] = true;
							break;
						case 'b':
							keyNum = 2;
							q.add(new int[] {nr,nc,keyNum});
							visited[nr][nc][keyNum] = true;
							break;
						case 'c':
							keyNum = 3;
							q.add(new int[] {nr,nc,keyNum});
							visited[nr][nc][keyNum] = true;
							break;
						case 'd':
							keyNum = 4;
							q.add(new int[] {nr,nc,keyNum});
							visited[nr][nc][keyNum] = true;
							break;
						case 'e':
							keyNum = 5;
							q.add(new int[] {nr,nc,keyNum});
							visited[nr][nc][keyNum] = true;
							break;
						case 'f':
							keyNum = 6;
							q.add(new int[] {nr,nc,keyNum});
							visited[nr][nc][keyNum] = true;
							break;
						case 'A':
							if(keyNum==1) {
								q.add(new int[] {nr,nc,keyNum});
								visited[nr][nc][keyNum] = true;
							}
							break;
						case 'B':
							if(keyNum==2) {
								q.add(new int[] {nr,nc,keyNum});
								visited[nr][nc][keyNum] = true;
							}
							break;
						case 'C':
							if(keyNum==3) {
								q.add(new int[] {nr,nc,keyNum});
								visited[nr][nc][keyNum] = true;
							}
							break;
						case 'D':
							if(keyNum==4) {
								q.add(new int[] {nr,nc,keyNum});
								visited[nr][nc][keyNum] = true;
							}
							break;
						case 'E':
							if(keyNum==5) {
								q.add(new int[] {nr,nc,keyNum});
								visited[nr][nc][keyNum] = true;
							}
							break;
						case 'F':
							if(keyNum==6) {
								q.add(new int[] {nr,nc,keyNum});
								visited[nr][nc][keyNum] = true;
							}
							break;
						
						}
					}
					else {
						q.add(new int[] {nr,nc,keyNum});
						visited[nr][nc][keyNum] = true;
					}
					
				}
				
			}
			step++;
			
		}
		
		System.out.println(-1);
		
		br.close();
	}

}
*/
