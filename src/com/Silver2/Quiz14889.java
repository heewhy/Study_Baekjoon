package com.Silver2;

import java.io.*;
import java.util.*;

public class Quiz14889 {
	
	/**
	 * @author 윤성희
	 * @since 2022-03-19
	 * 백준 14889 스타트와 링크 문제 풀이
	 * */
	
	static int totalSoccerPlayers,bestDiffernceTwoTeamPower,teamPlayerCount;
	static int[][] playerPowerCase;
	static boolean[] isSelectedPlayer;
	

	public static void main(String[] args) throws Exception{
		// 스타트와 링크
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//14 41 - 23 32
		//13 31 - 24 42
		//12 21 - 34 43
		
		totalSoccerPlayers = Integer.parseInt(input.readLine());
		teamPlayerCount = totalSoccerPlayers/2;
		playerPowerCase = new int[totalSoccerPlayers][totalSoccerPlayers];
		
		for(int i=0;i<totalSoccerPlayers;i++) {
			st = new StringTokenizer(input.readLine());
			for(int j=0;j<totalSoccerPlayers;j++) {
				playerPowerCase[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//for(int[] i : map)System.out.println(Arrays.toString(i));
		
		bestDiffernceTwoTeamPower = Integer.MAX_VALUE;
		isSelectedPlayer = new boolean[totalSoccerPlayers];
		
		divideTeam(0,0);
		
		System.out.println(bestDiffernceTwoTeamPower);
		
		input.close();
	}

	/**
	 * 주어진 players들을 두 팀으로 나누는 함수
	 * teamPlayerCount 함수에서 true가 start팀 false가 link팀으로 나뉜다.
	 * @param selectedcount start팀에 선택된 플레이어 수
	 * @param numberStartPoint 반복문 시작점을 갱신하기 위한 변수
	 * */
	private static void divideTeam(int selectedcount,int numberStartPoint) {

		if(selectedcount==teamPlayerCount) {
			findBestMatch();
			return;
		}
		
		for(int i=numberStartPoint;i<totalSoccerPlayers;i++) {
			if(isSelectedPlayer[i]) continue;
			
			isSelectedPlayer[i] = true;
			divideTeam(selectedcount+1, i);
			isSelectedPlayer[i] = false;
		}
		
	}

	
	/**
	 * 두 팀의 능력치를 비교해서 가장 작은 차이를 찾는 함수
	 * */
	private static void findBestMatch() {
		int startTeamPower = 0;
		int linkTeamPower = 0;
		
		for (int i = 0; i < totalSoccerPlayers; i++) {
			for (int j = i + 1; j < totalSoccerPlayers; j++) {
				// i 번째 사람과 j 번째 사람이 true라면 스타트팀으로 점수 플러스 
				if (isSelectedPlayer[i]&& isSelectedPlayer[j]) {
					startTeamPower += playerPowerCase[i][j];
					startTeamPower += playerPowerCase[j][i];
				}
				// i 번째 사람과 j 번째 사람이 false라면 링크팀으로 점수 플러스 
				else if (!isSelectedPlayer[i]&& !isSelectedPlayer[j]) {
					linkTeamPower += playerPowerCase[i][j];
					linkTeamPower += playerPowerCase[j][i];
				}
			}
		}
		
		int differnceTwoTeamPower = Math.abs(startTeamPower-linkTeamPower);
		
		if (differnceTwoTeamPower == 0) {
			System.out.println(differnceTwoTeamPower);
			System.exit(0);
		}
		
		bestDiffernceTwoTeamPower = Math.min(bestDiffernceTwoTeamPower, differnceTwoTeamPower);
	}
	
}
/*
static int N,min;
	static int[][] map;
	static int[] team;
	static boolean[] visited;
	

	public static void main(String[] args) throws Exception{
		// 스타트와 링크
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		//14 41 - 23 32
		//13 31 - 24 42
		//12 21 - 34 43
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		team = new int[N];
		visited = new boolean[N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//for(int[] i : map)System.out.println(Arrays.toString(i));
		
		min = Integer.MAX_VALUE;
		match(0);
		
		sb.append(min);
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();

	}

	private static void match(int cnt) {
		
		//1423 조합인가 1 4 |  2 3
		//4132
		//12 34
		//13 24
		//14 23
		//23 14 x
		//24 13 x
		//oh?
		if(team[0]!=0) return; //이래도 시간초과
		
		if(cnt==N) {
			int startteam=0;
			int linkteam=0;
			//System.out.println(Arrays.toString(team));
			for(int i=0;i<N;i++) {
				if(i<N/2) {
					for(int j=i+1;j<N/2;j++) {
						startteam += map[team[i]][team[j]];
						startteam += map[team[j]][team[i]];
					}
				}else {
					for(int j=i+1;j<N;j++) {
						linkteam += map[team[i]][team[j]];
						linkteam += map[team[j]][team[i]];
					}
				}
			}
			
			min = Math.min(min, Math.abs(startteam-linkteam));
			return;
		}
		
		//1에서 N까지의 숫자중에서
		//순열 이네
		
		for(int i=0;i<N;i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			team[cnt] = i;
			match(cnt+1);
			visited[i] = false;
		}
		
	}
*/
