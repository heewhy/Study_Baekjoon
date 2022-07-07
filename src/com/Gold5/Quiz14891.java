package com.Gold5;

import java.io.*;
import java.util.*;

public class Quiz14891 {
	
	static int GEAR_COUNT = 4;
	static int GEAR_INFO_COUNT = 8;
	static int GEAR_TOP_INFO = 0;
	static int GEAR_RIGHT_INFO = 2;
	static int GEAR_LEFR_INFO = 6;
	
	static int[][] totalGearInfo = new int[GEAR_COUNT][GEAR_INFO_COUNT];

	public static void main(String[] args) throws Exception{
		// 톱니바퀴
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		for(int i=0;i<GEAR_COUNT;i++) {
			String gearInfo = input.readLine();
			for(int j=0;j<GEAR_INFO_COUNT;j++) {
				totalGearInfo[i][j] = gearInfo.charAt(j)-'0';
			}
			
		}
		
		int TURN_COUNT = Integer.parseInt(input.readLine());
		
		while(TURN_COUNT-->0) {
			st = new StringTokenizer(input.readLine());
			int gearNum = Integer.parseInt(st.nextToken())-1;
			int rotationDir = Integer.parseInt(st.nextToken());
			
			checkLeftChain(gearNum-1,-rotationDir);
			checkRigthChain(gearNum+1,-rotationDir);
			rotate(gearNum,rotationDir);
			
		}
		
		int score = getScore(0);
		
		System.out.println(score);
		
		input.close();
	}

	/** 왼쪽 기어 기준 오른쪽 검사
	 * @param gearNum 기어 번호
	 * @param rotationDir 회전 방향
	 * */
	private static void checkLeftChain(int gearNum, int rotationDir) {
		if (gearNum < 0) return;

        if (totalGearInfo[gearNum][GEAR_RIGHT_INFO] != totalGearInfo[gearNum + 1][GEAR_LEFR_INFO]) {
        	checkLeftChain(gearNum - 1, -rotationDir);
            rotate(gearNum, rotationDir);
        }
	}
	/** 오른쪽 기어 기준 왼쪽 검사
	 * @param gearNum 기어 번호
	 * @param rotationDir 회전 방향
	 * */
	private static void checkRigthChain(int gearNum, int rotationDir) {
		if (gearNum > 3) return;

        if (totalGearInfo[gearNum][GEAR_LEFR_INFO] != totalGearInfo[gearNum - 1][GEAR_RIGHT_INFO]) {
        	checkRigthChain(gearNum + 1, -rotationDir);
            rotate(gearNum, rotationDir);
        }
	}
	
	/** 회전방향에 따라 회전
	 * @param gearNum 기어 번호
	 * @param rotationDir 회전 방향
	 * */
	private static void rotate(int gearNum, int rotationDir) {
		 if (rotationDir == 1) {
	            int temp = totalGearInfo[gearNum][7];

	            for (int i = 7; i > 0; i--) {
	            	totalGearInfo[gearNum][i] = totalGearInfo[gearNum][i - 1];
	            }

	            totalGearInfo[gearNum][0] = temp;

	        } else {
	            int temp = totalGearInfo[gearNum][0];

	            for (int i = 0; i < 7; i++) {
	            	totalGearInfo[gearNum][i] = totalGearInfo[gearNum][i + 1];
	            }

	            totalGearInfo[gearNum][7] = temp;
	        }
	}

	private static int getScore(int score) {
		for(int i=0;i<GEAR_COUNT;i++) {
			score+=totalGearInfo[i][0]*(1<<i);
		}
		return score;
	}

	

}
