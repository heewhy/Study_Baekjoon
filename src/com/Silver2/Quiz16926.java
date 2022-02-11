package com.Silver2;

import java.io.*;
import java.util.*;

public class Quiz16926 {

	public static void main(String[] args) throws Exception{
		// 배열 돌리기1
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		
		
		for(int i=0;i<N;i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				int r =0;
				int c =0;
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		//for(int[] a : map)System.out.println(Arrays.toString(a));
		
		//사각형의 개수
		int min = Math.min(N, M)/2;
		
		//우 하 좌 상 ,값 덮어씌우기
		int[] di = {0,1,0,-1};
		int[] dj = {1,0,-1,0};
		
		for(int spin=0;spin<R;spin++) {
			//사각형의 개수만큼
			for(int i=0;i<min;i++) {
				//방향타
				int dir=0;
				//시작점 , 저장
				int sr = i;
				int sc = i;
				//System.out.println(sr);
				//System.out.println(sc);
				int temp = map[sr][sc];
				
				while(dir<4) {
					int r = sr+di[dir];
					int c = sc+dj[dir];
					
					//회전영역
					if(r>=i&&r<N-i&&c>=i&&c<M-i) {
						map[sr][sc]=map[r][c];
						sr=r;
						sc=c;
						//System.out.println("sr change : "+sr);
						//System.out.println("sc change : "+sc);
					}else {
						//방향전환
						dir++;
					}
				}
				//빼놓은거 넣기
				//System.out.println("i : " +i);
				map[i+1][i] = temp;
			}			
		}
		
		for(int[] b : map) {
			for(int a : b) {
				sb.append(a+" ");
			}
			sb.append("\n");
		}
		
		bw.write(sb.toString());

		br.close();
		bw.flush();
		bw.close();
	}

}
