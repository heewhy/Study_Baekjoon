package com.Gold2;

import java.io.*;
import java.util.*;

public class Quiz3109 {
	
	//배열 행, 열, 설치 성공한 파이프 개수
	static int R,C,cnt; 
	//맵정보
	static char[][] map;
	//파이프 라인 설치 성공 여부(C-2 에서 deltas떄문에 증가안하도록)
	static boolean isSuccess;
	//우상, 우, 우하 행변화량
	final static int dr[] = {-1,0,1};
	
	
	public static void main(String[] args) throws Exception{
		// 빵집
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		
		//맵 정보 입력
		map = new char[R][C];
		for(int i=0;i<R;i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		cnt=0;
		
		//i행을 시작점으로 파이프라인 설치 시도
		for(int i=0;i<R;i++) {
			isSuccess =false;
			setPipe(i,0);
		}
		
		sb.append(cnt);
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}

	/**
	 * 현재 위치(r,c 에 파이프 하나를 설치, 다음 파이프 설치를 넘기기
	 * @param r 현재 위치의 행 값
	 * @param c 현재 위치의 열 값
	 * */
	private static void setPipe(int r, int c) {
		//현재 위치가 마지막 열인 경우(파이프라인 끝까지 연결 성공)
		if(c==C-1) {
			//파이프라인 성공 개수 증가
			cnt++; 
			isSuccess =true;
			for(char[] a : map)System.out.println(Arrays.toString(a));
			return;
		}
		
		//설치 전 현재 위치가 경계를 벗어나거나 빈칸이 아니라면 설치 실패
		if(r<0||r>=R||map[r][c]!='.') return;
		
		//파이프 설치
		map[r][c] = '-';	
		
		//3방향 탐색
		for(int d=0;d<3;d++) {
			
			//다음 설치할 파이프의 좌표 우상 우 우하
			int nr = r+dr[d];
			int nc = c+1;
			
			setPipe(nr,nc);
			
			//가지치기 - 다음 방향을 살펴보는 경우의 수를 걸러냄
			//isSuccess가 true인 경우
			if(isSuccess) return;
		}
	}

}
