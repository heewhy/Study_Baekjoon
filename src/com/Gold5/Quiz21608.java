package com.Gold5;

import java.io.*;
import java.util.*;

public class Quiz21608 {

	static int N,M;
	static int[][] map;
	static ArrayList<Integer>[] list;
	static int[] order;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	static class seatInfo implements Comparable<seatInfo>{
		int r,c,favCnt,EmptyCnt;

		public seatInfo(int r, int c, int favCnt, int emptyCnt) {
			super();
			this.r = r;
			this.c = c;
			this.favCnt = favCnt;
			this.EmptyCnt = emptyCnt;
		}

		@Override
		public int compareTo(seatInfo o) {
			if(this.favCnt==o.favCnt) {
				if(this.EmptyCnt==o.EmptyCnt) {
					if(this.r==o.r) return this.c-o.c;
					return this.r-o.r;
				}
				return o.EmptyCnt-this.EmptyCnt;
			}
			return o.favCnt-this.favCnt;
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		// 상어 초등학교
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		M = (int) Math.pow(N, 2);
		list = new ArrayList[M+1];
		order = new int[M+1];
		
		for(int i=1;i<=M;i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int studentNum = Integer.parseInt(st.nextToken());
			order[i] = studentNum;
			list[studentNum].add(Integer.parseInt(st.nextToken()));
			list[studentNum].add(Integer.parseInt(st.nextToken()));
			list[studentNum].add(Integer.parseInt(st.nextToken()));
			list[studentNum].add(Integer.parseInt(st.nextToken()));
		}

		setStudent();
		
		System.out.println(getSatisfaction());
		
		br.close();
	}

	private static int getSatisfaction() {
		int total=0;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				
				int curNum = map[i][j];
				int cnt = 0;
				
				for(int d=0;d<4;d++) {
					int r = i + dr[d];
					int c = j + dc[d];
					
					if(isIn(r, c)) {
						for(int k=0;k<list[curNum].size();k++) {
							if(map[r][c]==list[curNum].get(k)) {
								cnt++;
							}
						}
					}
					
				}
				
				switch (cnt) {
				case 1: total+=1; 
						break;
				case 2: total+=10; 
						break;
				case 3: total+=100; 
						break;
				case 4: total+=1000; 
						break;
				default:
					break;
				}
				
			}
		}
		
		return total;
	}

	private static void setStudent() {
		for(int student : order) {
			if(student == 0) continue;
			
			PriorityQueue<seatInfo> pq = new PriorityQueue<>();
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j]!=0) continue;
					
					getCnt(student,i,j,pq);
				}
			}
			
			seatInfo curSeat = pq.poll();
			map[curSeat.r][curSeat.c] = student;
		}
	}

	private static void getCnt(int num, int i, int j, PriorityQueue<seatInfo> pq) {
		int favCnt = 0;
		int emptyCnt = 0;
		
		for(int d=0;d<4;d++) {
			int r = i + dr[d];
			int c = j + dc[d];
			
			if(isIn(r,c)) {
				//비어 있는 칸
				if(map[r][c]==0) {
					emptyCnt++;
				}
				//좋아하는 학생수
				else {
					for(int k=0;k<list[num].size();k++) {
						if(map[r][c]==list[num].get(k)) {
							favCnt++;
						}
					}
				}
			}
		}
		seatInfo info = new seatInfo(i,j,favCnt,emptyCnt);
		pq.add(info);
	}

	private static boolean isIn(int r, int c) {
		return r>=0 && c>=0 && r<N && c<N;
	}
	
	private static void print() {
		for(int[] i:map)System.out.println(Arrays.toString(i));
	}

}
