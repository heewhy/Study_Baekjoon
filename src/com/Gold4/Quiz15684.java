package com.Gold4;

import java.io.*;
import java.util.*;

public class Quiz15684 {

	static int colSize;
	static int rowCount;
	static int rowSize;
    static int failAddLadder = -1;
    static int [][] ladder;
	
	public static void main(String[] args) throws Exception{
		// 사다리조작
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(input.readLine());
		colSize = Integer.parseInt(st.nextToken());
        rowCount = Integer.parseInt(st.nextToken());
        rowSize = Integer.parseInt(st.nextToken());

        ladder = new int[rowSize+1][colSize+1];

        for(int i=0;i<rowCount;i++){
            st = new StringTokenizer(input.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());

            ladder[row][col] = 1;
            ladder[row][col+1] = -1;
        }

        for(int i=0;i<4;i++){
            addLadder(0,i);
        }
        System.out.print(failAddLadder);
    }
	
	/**
	 * 사다리를 설치하는 메서드
	 * @param addLadderCount 사다리 설치 개수
	 * @param totalLadderCount 총 사다리 설치 개수
	 */
    static void addLadder(int addLadderCount, int totalLadderCount){
        if(addLadderCount == totalLadderCount){
            if(isArrive()){
	            System.out.print(totalLadderCount);
	            System.exit(0);
            }
            return;
        }

        for(int i=1;i<=rowSize;i++){
            for(int j=1;j<colSize;j++){
                if(ladder[i][j]!=0 || ladder[i][j+1]>0) continue;
                ladder[i][j] = 1;
                ladder[i][j+1] = -1;
                addLadder(addLadderCount+1,totalLadderCount);
                ladder[i][j] = 0;
                ladder[i][j+1] = 0;
            }
        }
    }
    
    /**
     * 각 col에서 시작하여 같은 col에 도달 했는지 판단하는 메서드
     * @return 도착 여부
     */
    static boolean isArrive(){
        boolean success = true;
        for(int startColNum=1;startColNum<=colSize;startColNum++) {
            int row = 1;
            int col = startColNum;

            while(row<rowSize+1){
//                if(ladder[row][col]>0){
//                    col++;
//                }
//                else if(ladder[row][col]<0){
//                    col--;
//                }
                col+=ladder[row][col];
                row++;
            }
            
            if(col!=startColNum){
                success = false;
                break;
            }
        }
        return success;
    }
}

/*
public static void main(String[] args) throws Exception{
		// 사다리조작
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(input.readLine());
		int rowLineCount = Integer.parseInt(st.nextToken());
		int colLineCount = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());
		if(colLineCount>height) {
			System.out.println(-1);
			System.exit(0);
		}
		
		
		int[] rowLineHasCount = new int[rowLineCount]; 
		
		while(colLineCount-->0) {
			st = new StringTokenizer(input.readLine());
			st.nextToken();
			int colNum = Integer.parseInt(st.nextToken())-1;
			
			rowLineHasCount[colNum]++;
		}
		
		int addColLine = 0;
		for(int i=0;i<rowLineCount;i++) {
			if(rowLineHasCount[i]%2!=0) {
				addColLine++;
			}
		}
		if(addColLine>3) addColLine=-1;
		System.out.println(addColLine);
		input.close();
	}
*/
