package com.Gold2;

import java.io.*;
import java.util.*;

public class Quiz12100 {

	static int N,ans;
	static int[][] map;
	
	public static void main(String[] args) throws Exception{
		// 2048 (Easy)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		//5번 가능 기저조건
		//가장 큰 블록의 값 승리조건
		//1 1 1 1 1   중복조합?
		//움직임에 따라서 굴려주는 함수가필요

		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		game(0);
		
		sb.append(ans);
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}

    public static void game(int count) {
        if(count==5) {
        	for(int i=0;i<N;i++) {
        		for(int j=0;j<N;j++) {
        			ans = Math.max(ans,map[i][j]);
        		}
        	}
            return;
        }
        int temp[][] = new int[N][N];
        for(int i=0;i<N;i++) {
        	temp[i] = map[i].clone();
        }
        
        for(int i=0;i<4;i++) {
            move(i);
            game(count+1);
            for(int a=0;a<N;a++)
                map[a] = temp[a].clone();
        }
    }
    
    public static void move(int dir) {
        switch(dir) {
            case 0:
                for(int i=0;i<N;i++) {
                    int idx = 0;
                    int cube = 0;
                    for(int j = 0; j < N; j++) {
                        if(map[j][i]!=0) {
                            if(cube==map[j][i]) {
                                map[idx-1][i] = cube*2;
                                cube = 0;
                                map[j][i] = 0;
                            }
                            else {
                                cube=map[j][i];
                                map[j][i]=0;
                                map[idx][i]=cube;
                                idx++;
                            }
                        }
                    }
                }
                break;
            case 1:
                for(int i=0;i<N;i++) {
                    int idx = N-1;
                    int cube = 0;
                    for(int j = N-1; j>=0;j--) {
                        if(map[j][i]!=0) {
                            if(cube==map[j][i]) {
                                map[idx+1][i] = cube*2;
                                cube = 0;
                                map[j][i] = 0;
                            }
                            else {
                                cube = map[j][i];
                                map[j][i] = 0;
                                map[idx][i] = cube;
                                idx--;
                            }
                        }
                    }
                }
                break;
            case 2:
                for(int i=0;i<N;i++) {
                    int idx = 0;
                    int cube = 0;
                    for(int j=0;j<N;j++) {
                        if(map[i][j]!=0) {
                            if(cube==map[i][j]) {
                                map[i][idx-1] = cube*2;
                                cube = 0;
                                map[i][j] = 0;
                            }
                            else {
                                cube = map[i][j];
                                map[i][j] = 0;
                                map[i][idx] = cube;
                                idx++;
                            }
                        }
                    }
                }
                break;
            case 3:
                for(int i=0;i<N;i++) {
                    int idx = N-1;
                    int cube = 0;
                    for(int j = N-1; j>=0;j--) {
                        if(map[i][j]!=0) {
                            if(cube==map[i][j]) {
                                map[i][idx+1] = cube*2;
                                cube = 0;
                                map[i][j] = 0;
                            }
                            else {
                                cube = map[i][j];
                                map[i][j] = 0;
                                map[i][idx] = cube;
                                idx--;
                            }
                        }
                    }
                }
                break;
        }
    }

}

	


