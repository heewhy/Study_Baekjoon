package com.Gold2;

import java.io.*;
import java.util.*;


public class Quiz17143 {
	
	static int R,C,m,cur_C, total;
	static int[][] map;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,1,-1};
	static int[][] shark;

	public static void main(String[] args) throws Exception{
		// 낚시왕
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine()," ");
		R= Integer.parseInt(st.nextToken());
		C= Integer.parseInt(st.nextToken());
		m= Integer.parseInt(st.nextToken());
		map = new int[R][C];
		total = 0;
		// r,c, 속력 , 방향,크기 
		shark = new int[m+1][5];
		for(int i=1;i<=m;i++) {
			st= new StringTokenizer(br.readLine()," ");
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken())-1;
			int z = Integer.parseInt(st.nextToken());
			shark[i][0] = r;
			shark[i][1] = c;
			shark[i][2] = s;
			shark[i][3] = d;
			shark[i][4] = z;
			map[r][c] = i;
		}
		
		//낚시 시작
		cur_C=-1;
		while(true) {
			// 오른쪽으로 이동 
			if(cur_C==C-1) break;
			cur_C ++;
			
			// 가까운 상어 잡기 
			fishing();
			// 상어 이동
			move();
		}
		System.out.println(total);
		
	}
	
	private static void fishing() {
		for(int i=0;i<R;i++) {
			if(map[i][cur_C]!=0) {
				int shark_idx = map[i][cur_C];
				map[i][cur_C] = 0;
				total += shark[shark_idx][4];
				shark[shark_idx][0] = -1;
				break;
			}
		}
	}
	
	private static void move() {
		map = new int[R][C];
		for(int i=1;i<=m;i++) {
			// 상어가 존재 한다
			if(shark[i][0]!=-1) {
				int r = shark[i][0];
				int c = shark[i][1];
				int s = shark[i][2];
				int d = shark[i][3];
				int z = shark[i][4];
				for(int j=0;j<s;j++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					if(0>nr) {
						nr = 1 ;
						d=1;
					}
					else if(0>nc) {
						nc = 1;
						d=2;
					}
					else if(nr>R-1) {
						nr = R-2;
						d=0;
					}
					else if(nc>C-1) {
						nc = C-2;
						d=3;
					}
					r = nr;
					c = nc;
				}
				shark[i][0]=r;
				shark[i][1]=c;
				shark[i][2]=s;
				shark[i][3]=d;
				shark[i][4]=z;
				
				// 해당 맵에 상어가 있다
				if(map[r][c]!=0) {
					// 누가 더 큰지 따져준다
					if(shark[map[r][c]][4] > z) {
						shark[i][0] = -1;
					}
					else {
						shark[map[r][c]][0] = -1;
						map[r][c] = i;
					}
				}
				//없다
				else {
					map[r][c] = i;
				}
			}
		}
	}

}
//	private static void fishing(int dist) {
//		if(dist>C) return;
//			
//		Collections.sort(sharks);
//		//낚시왕이 있는 열에 있는 상어 중에서 땅과 제일 가까운 상어를 잡는다. 
//		//상어를 잡으면 격자판에서 잡은 상어가 사라진다.
//		for(int i=0;i<sharks.size();i++) {
//			if(sharks.get(i).c==dist) { //가까운거 추가 , sort좀 해야겟
//				ans+= sharks.get(i).z;
//				sharks.remove(i);
//				break;
//			}
//		}
//		//상어가 이동한다.
//		moveSharks();
//		
//		//낚시왕 오른쪽 한 칸 이동
//		fishing(dist+1);
//	}
//
//
//	private static void moveSharks() {
//		for(int i=0;i<sharks.size();i++) {
//			for(int j=0;j<sharks.get(i).s;j++) {
//				int r = sharks.get(i).r+dr[sharks.get(i).d];
//				int c = sharks.get(i).c+dc[sharks.get(i).d];
//				
//				if(r>=0&&c>=0&&r<R&&c<C) {
//					sharks.get(i).r=r;
//					sharks.get(i).c=c;
//				}else {
//					//벽에 닿으면 방향을 바꾸어 이동
//					if(sharks.get(i).d<2) {
//						sharks.get(i).d = (sharks.get(i).d+1)%2; 
//					}else {
//						sharks.get(i).d = ((sharks.get(i).d+1)%2)+2;
//					}
//					j--;
//				}
//			}
//		}
//		//어레이리스트하나만들어서 빼서 제거하고 관리하자
//		//or 위에서부터 같은자리인지 검사하자
//		//or map에 표시해서 검사하자
//		//하나의 칸에 다수의 상어면 크기가 큰 상어가 잡아먹음
//		for(int i=sharks.size()-1;i>=1;i--) {
//			//같은자리
//			for(int j=i-1;j>=0;j--) {
//				if(sharks.get(i).isSamePlace(sharks.get(j))) {
//					//System.out.println(sharks.get(i).isBig(sharks.get(j)));
//					if(sharks.get(i).isBig(sharks.get(j))) {
//						sharks.remove(j);
//					}else {
//						sharks.remove(i);
//					}
//					
//				}
//			}
//		}
//		
//	}
