package com.Gold2;

import java.io.*;
import java.util.*;

public class Quiz20061 {

	static int score;
	static int[][] green, blue;
	
	public static void main(String[] args) throws Exception{
		// 모노미노도미노 2
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		blue = new int[4][6];
		green = new int[6][4];
		
		//블록을 놓은 횟수
		int N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int shape = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			//블록세팅
			setBlock(shape,r,c);
			//점수구하고
			getScore();
			//정리
			pushGreen(checkGreen());
            pushBlue(checkBlue());
			
		}
		
		System.out.println(score);
		System.out.println(count());
		
		br.close();
	}
	
	public static int count() {
        int count = 0;
        for(int i=0;i<4;i++) {
            for(int j=0;j<6;j++) {
                if(blue[i][j]==1) count++;
                if(green[j][i]==1) count++;
            }
        }
    
        return count;
    }
	
	public static int checkGreen() {
        int count = 0;
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 4; j++)
                if(green[i][j] == 1) {
                    count++;
                    break;
                }
        }
        
        return count;
    }
    
    public static int checkBlue() {
        int count = 0;
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 4; j++)
                if(blue[j][i] == 1) {
                    count++;
                    break;
                }
        }
        
        return count;
    }
	
	public static void pushGreen(int count) {
        for(int i=5;i>=2;i--) {
            for(int j=0;j<4;j++)
                green[i][j] = green[i-count][j];
        }
        
        for(int i=0;i<2;i++) {
        	for(int j=0; j<4;j++) {
        		green[i][j] = 0;
        	}
        }
    }
    
    public static void pushBlue(int count) {
        for(int i=5;i>=2;i--) {
            for(int j=0;j<4;j++)
                blue[j][i] = blue[j][i-count];
        }
        
        for(int i=0;i<2;i++) {
        	for(int j=0;j<4;j++) {
        		blue[j][i] = 0;
        	}
        }
    }
    
	private static void getScore() {
		for(int i=5;i>=2;i--) {
            int count = 0;
            for(int j=0;j<4;j++) {
                if(green[i][j] == 0) break;
                else count++;
            }
            if(count==4) {
                score++;
                cleanGreen(i);
                i++;
            }
        }
    
        for(int i=5;i>=2;i--) {
            int count = 0;
            for(int j=0;j<4;j++) {
                if(blue[j][i] == 0) break;
                else count++;
            }
            if(count==4) {
                score++;
                cleanBlue(i);
                i++;
            }
        }
		
	}
	
	private static void cleanBlue(int idx) {
		for(int j=idx;j>0;j--) {
            for(int i=0;i<4;i++) {
                blue[i][j] = blue[i][j-1];
            }
        }		
	}

	private static void cleanGreen(int idx) {
		for(int i=idx;i>0;i--) {
            for(int j=0;j<4;j++) {
                green[i][j] = green[i-1][j];
            }
        }		
	}

	public static void setBlock(int shape, int r, int c) {
        int index;
        switch(shape) {
            //1x1
            case 1 :
                blue[r][0] = 1;
                green[0][c] = 1;
                index = 1;
                while(index<6 && blue[r][index] == 0) {
                    blue[r][index-1] = 0;
                    blue[r][index] = 1;
                    index++;
                }
                index = 1;
                while(index<6 && green[index][c]==0) {
                    green[index-1][c] = 0;
                    green[index][c] = 1;
                    index++;
                }
                break;
            //1x2
            case 2 :
                blue[r][0] = 1;
                blue[r][1] = 1;
                green[0][c] = 1;
                green[0][c+1] = 1;
                index = 2;
                while(index<6 && blue[r][index]==0) {
                    blue[r][index-2] = 0;
                    blue[r][index] = 1;
                    index++;
                }
                index = 1;
                while(index<6 && green[index][c]==0 && green[index][c+1]==0) {
                    green[index-1][c] = 0;
                    green[index-1][c+1] = 0;
                    green[index][c] = 1;
                    green[index][c+1] = 1;
                    index++;
                }
                break;
            //2x1
            case 3 :
                blue[r][0] = 1;
                blue[r+1][0] = 1;
                green[0][c] = 1;
                green[1][c] = 1;
                index = 1;
                while(index<6 && blue[r][index]==0 && blue[r+1][index]==0) {
                    blue[r][index-1] = 0;
                    blue[r+1][index-1] = 0;
                    blue[r][index] = 1;
                    blue[r+1][index] = 1;
                    index++;
                }
                index = 2;
                while(index<6 && green[index][c]==0) {
                    green[index-2][c] = 0;
                    green[index][c] = 1;
                    index++;
                }
                break;
        }
    }
	
}
