package com.Gold4;

import java.io.*;
import java.util.*;

public class Quiz17779 {

	static int N;
	static int[][] people;
	static int ans;
	
	public static void main(String[] args) throws Exception{
		// 게리멘더링 2
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		people = new int[N][N];
		int total =0;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				people[i][j] = Integer.parseInt(st.nextToken());
				total += people[i][j];
			}
		}
		
		ans = Integer.MAX_VALUE;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				for(int d1=1;d1<N;d1++) {
					for(int d2=1;d2<N;d2++) {
						//(d1, d2 ≥ 1, 1 ≤ x < x+d1+d2 ≤ N, 
						//1 ≤ y-d1 < y < y+d2 ≤ N)
						if(i+d1+d2>=N||j-d1<0||j+d2>=N) continue;
						
						gerrymandering(i,j,d1,d2,new boolean[N][N],total);
					}
				}
			}
		}
		
		
		System.out.println(ans);
	}

	private static void gerrymandering(int r, int c, int d1, int d2, boolean[][] border, int total) {
		
		for(int i=0;i<=d1;i++) {
			//경계선1
			border[r+i][c-i] = true;
			//경계선3
			border[r+d2+i][c+d2-i] = true;
		}
		
		for(int i=0;i<=d2;i++) {
			//경계선2
			border[r+i][c+i] = true;
			//경계선4
			border[r+d1+i][c-d1+i] = true;
		}
		
		int[] eachPeople = new int[5];
		
		//1구역
		for(int i=0;i<r+d1;i++) {
			for(int j=0;j<=c;j++) {
				if(border[i][j]) break;
				eachPeople[0] += people[i][j];
			}
		}
		total-=eachPeople[0];
		
		 //2구역
        for (int i=0;i<=r+d2;i++) {
            for (int j=N-1;j>c;j--) {
                if (border[i][j]) break;
                eachPeople[1] += people[i][j];
            }
        }
        total-=eachPeople[1];

        //3구역
        for (int i=r+d1;i<N;i++) {
            for (int j=0;j<c-d1+d2;j++) {
                if (border[i][j]) break;
                eachPeople[2] += people[i][j];
            }
        }
        total-=eachPeople[2];

        //4구역
        for (int i=r+d2+1;i<N;i++) {
            for (int j=N-1;j>=c-d1+d2;j--) {
                if (border[i][j]) break;
                eachPeople[3] += people[i][j];
            }
        }
        total-=eachPeople[3];

        eachPeople[4] = total;

        Arrays.sort(eachPeople);

        ans = Math.min(ans, eachPeople[4] - eachPeople[0]);
	}

}
