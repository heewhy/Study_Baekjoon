package com.Gold5;

import java.io.*;
import java.util.*;

public class Quiz15683 {
	
	//상 우 하 좌
		final static int[] dr = {-1, 0, 1, 0};
		final static int[] dc = {0, 1, 0, -1};
		
		//각 cctv 번호의 방향 정보 (여기서 숫자값은 델타정보의 인덱스 값을 의미)
		//dirCase[2] = [[0, 2], [1, 3]] 임
		//위의 의미는 2번 cctv에서 감시 가능한 상하, 좌우 두 가지의 경우의 수를 저장해놓은 것
	    static int[][][] dirCase = {
	            {},	//미사용인덱스
	            { {0},         {1},       {2},       {3} }, 						// 1번 cctv 경우의 수 - (상), (우), (하), (좌)
	            { {0, 2},      {1, 3} }, 							// 2번 cctv 경우의 수 - (상,하), (우,좌) 
	            { {0, 1},      {1, 2},    {2, 3},    {3, 0} }, 			// 3번 cctv 경우의 수 - (상,우), (우,하), (하,좌), (좌,상)
	            { {0, 1, 2},   {1, 2, 3}, {2, 3, 0}, {3, 0, 1}} , // 4번 cctv 경우의 수 - (상,우,하), (우,하,좌), (하,좌,상), (좌,상,우)
	            { {0, 1, 2, 3} }, 								// 5번 cctv 경우의 수 - (상,우,하,좌)
	    };
	    
	    static int minBlindCnt;	//사각지대 최솟값

		static int N,M;	//행열 크기
		
		static int[][] origin; 	//초기 정보 저장
		static int[][] map; 	//실제 사용할 배열
		
		static List<CCTV> cctvs = new ArrayList<>();	//cctv 정보
		 
		static class CCTV{
			int r, c;
			int[][] dirs;	//cctv 방향 경우의 수 정보
			//만약 2번 cctv라면 아래와 같은 값이 담김
			/*
			 * [
			 * 	[0, 2], 
			 * 	[1, 3]
			 * ]
			 */
			
			public CCTV(int r, int c, int[][] dirs) {
				super();
				this.r = r;
				this.c = c;
				this.dirs = dirs;
			}
		}
			//각 cctv의 경우의 수 선택정보 담을 공간
			//Ex) list에 [1번, 2번, 4번] cctv가 저장 되어 있을 때,
			//selectedDirCase의 값이 [3, 1, 0] 이라면? 1번 cctv는 (하), 2번 cctv는 (우좌), 4번 cctv는 (상우좌) 를 보고 있다는 의미
			static int[] selectedDirCase;	
		
		public static void main(String[] args) throws IOException {
			// 감시
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			origin = new int[N][M];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<M; j++) {
					int val = Integer.parseInt(st.nextToken());
					
					origin[i][j] = val;
					//cctv 정보 입력
					if(val!=0 && val !=6) cctvs.add( new CCTV(i, j, dirCase[val] ) );
					
				}
			}
			
			selectedDirCase = new int[cctvs.size()];
			
			minBlindCnt = Integer.MAX_VALUE;	//사각지대 개수 최소값 충분히 큰값으로 초기화
			
			
			selectDir( 0 );
			
			System.out.println(minBlindCnt);//결과 출력
		}

		

		/**
		 * cnt인덱스의 cctv의 방향을 설정
		 * @param cnt 방향을 설정할 cctv의 인덱스
		 */
		private static void selectDir(int cnt) {
			
			//step01. 모든 cctv의 방향 설정 완료
			if(cnt == cctvs.size()) {
				
				arrInitialize();	//map 배열 초기화
				
				//step 02. 설정된 방향대로 감시영역 체크
				watch();
				
				//step 03. 사각지대 개수 cnt
				int curBlindCnt = getCurBlindCnt();
				
				//step 04. 구한 사각지대 개수 최소값이라면 갱신
				minBlindCnt = Math.min(minBlindCnt, curBlindCnt);
				
				return;
			}
			
			
			//i는 cnt번째의 cctv가 바라볼 방향
			for(int i=0; i<cctvs.get(cnt).dirs.length; i++) {
				selectedDirCase[cnt] = i;
				
				//다음 cctv의 방향 설정
				selectDir( cnt+1 );
			}
			
		}



		/**
		 * 사각지대 개수 반환
		 * @return 사각지대 개수
		 */
		private static int getCurBlindCnt() {
			int cnt = 0;	//사각지대 개수
			
			for(int i=0; i< N;i ++) {
				for(int j=0; j<M; j++) {
					if(map[i][j] == 0) cnt++;
				}
			}
			return cnt;
		}

		/**
		 * 감시영역 체크
		 */
		private static void watch() {
			
			//i번째 cctv의 감시영역 체크
			for(int i=0; i<cctvs.size(); i++) {
				
				CCTV cctv = cctvs.get(i);	//cctv 정보 가져오기
				
				// 2번 cctv 라면
				//cctv.dirs[ selectedDirCase[i]] = [0, 2]
				for(int dir : cctv.dirs[ selectedDirCase[i]]) {
					
					//cctv의 좌표값 받아오기
					int r = cctv.r;
					int c = cctv.c;
					
					//해당 방향으로 한 칸씩 이동하며 감시영역 체크
					while(true) {
						//한 칸 이동
						r+= dr[dir];
						c+= dc[dir];
						
						//경계를 벗어나거나 벽(6)인 경우 해당 방향의 검사 마침
						if(r<0 || r>=N || c<0 || c>=M || map[r][c]==6) break;
						
						//위의 조건을 만족하지 않는다면 감시 영역 체크(-1로 체크)
						map[r][c] = -1;
					}
				}
			}
		}

		/**
		 * map 배열을 초기상태로 되돌리기
		 */
		private static void arrInitialize() {
			map = new int[N][];
			for(int i=0; i<N;i++) {
				map[i] = origin[i].clone();
			}
		}

	
	
}


