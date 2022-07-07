package com.Gold3;

import java.io.*;
import java.util.*;

public class Quiz14890 {
	
	/**
	 * @author 윤성희
	 * @since 2022-03-19
	 * 백준 14890 경사로 문제풀이
	 * */
	
	static int mapSize,runwaySize;
	
	public static void main(String[] args) throws Exception{
		// 경사로
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(input.readLine());
		mapSize = Integer.parseInt(st.nextToken());
		runwaySize = Integer.parseInt(st.nextToken())-1;
		int roadCount = 0;
		
		int[][] map = new int[mapSize][mapSize];
		int[][] switchmap = new int[mapSize][mapSize];
		
		for(int i=0;i<mapSize;i++) {
			st = new StringTokenizer(input.readLine());
			for(int j=0;j<mapSize;j++) {
				int temp = Integer.parseInt(st.nextToken());
				map[i][j] = temp;
				switchmap[j][i] = temp;
			}
		}
		
		//for(int[] a: switchmap)System.out.println(Arrays.toString(a));
		//System.out.println(runwaySize);
		
		for(int i=0;i<mapSize;i++) {
			if(ismakeroad(map[i],new boolean[mapSize])) roadCount++;
			if(ismakeroad(switchmap[i],new boolean[mapSize])) roadCount++;
		}
				
		//if(ismakeroad(new int[] {1,1,2,3,3,3},new boolean[mapSize])) roadCount++;
		
		System.out.println(roadCount);
		
		input.close();
	}

	/**
	 * 길을 만들 수 있는지 판별하는 함수
	 * @param roadHeight 길의 높이 정보를 가진 배열
	 * @param ismakerunway 경사로를 세웠는지 여부를 판별
	 * */
	private static boolean ismakeroad(int[] roadHeight,boolean[] ismakerunway) {
		for(int i=0;i<mapSize-1;i++) {
			int j= i+1;
			if(roadHeight[i]-roadHeight[j]==0) continue;
			else if(roadHeight[i]-roadHeight[j]==1) {
				//높이가 낮아지는 경우
				if(j+runwaySize<mapSize) {
					for(int k=j;k<=j+runwaySize;k++) {
						if(ismakerunway[k]||roadHeight[j]!=roadHeight[k]) return false;
						
						ismakerunway[k] = true;
					}						
				}
				else return false;
			}else if(roadHeight[i]-roadHeight[j]==-1) {
				//높이가 높아지는 경우
				if(i-runwaySize>=0) {
					for(int k=i;k>=i-runwaySize;k--) {
						if(ismakerunway[k]||roadHeight[i]!=roadHeight[k]) return false;
						
						ismakerunway[k] = true;
					}						
				}
				else return false;
			}else {
				return false;
			}
						
		}
		return true;
	}

}
