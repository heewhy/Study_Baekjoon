package com.Gold4;

import java.io.*;
import java.util.*;

public class Quiz17140 {
	
	static int R,C;
	
	public static void main(String[] args) throws Exception{
		// 이차원 배열과 연산
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken())-1;
		int c = Integer.parseInt(st.nextToken())-1;
		int k = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[100][100];
		for(int i=0;i<3;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		R = 3;
		C = 3;
		sort(r,c,k,map,0);
		
		br.close();
	}

	private static void sort(int r, int c, int k, int[][] map, int cnt) {
		
		if(cnt==100) {
			System.out.println(-1);
			System.exit(0);
		}
		
		if(map[r][c]==k) {
			System.out.println(cnt);
			System.exit(0);
		}
		
		//R=map.length();
		//C=map[0].length();
		if(R>=C) {
			int max = 0; 
			for(int i=0;i<R;i++) {
				int cntnum[] = new int[101];
				for( int j=0;j<C;j++) {
					cntnum[map[i][j]]++;
				}
				int idx = 0; 
				for(int j=1;j<=C&&idx<100;j++) {
					for(int z=1;z<101;z++) {
						//0이 아닌것 -> i
						if(cntnum[z]==j) {
							map[i][idx++] = z;
							map[i][idx++] = j;
						}
					}
				}
				for(int j=idx;j<=C&&j<100;j++) {
					map[i][j] = 0;
				}
				max = Math.max(max, idx);
			}
			C = max;
		}else {
			int max = 0; 
			for(int j=0;j<C;j++) {
				int count[] = new int[101];
				for(int i = 0; i<R;i++) {
					count[map[i][j]]++;
				}
				int idx = 0; 
				for(int i=1;i<=R;i++) {
					for(int z= 1;z<101; z++) {
						//0이 아닌것 -> i
						if(count[z]==i) {
							map[idx++][j] = z;
							map[idx++][j] = i;
						}
					}
				}
				for(int i=idx;i<=R&&i<100;i++) {
					map[i][j] = 0;
				}
				max = Math.max(max, idx);
			}
			R = max;
		}
			
		sort(r,c,k,map,cnt+1);
			
	}
		
}

