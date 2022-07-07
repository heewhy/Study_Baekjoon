package com.Gold5;

import java.io.*;
import java.util.*;

public class Quiz2240 {
	
	public static void main(String[] args) throws Exception{
		// 자두나무
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		int[] nums = new int[T+1];
		int[][] memo = new int[T+1][W+1]; 
		
		for(int i=1;i<=T;i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=1;i<=T;i++) {
			int num = nums[i];
			
			for(int j=0;j<=W;j++) {
				if(j==0) {
					if(num==1) memo[i][j] = memo[i-1][j]+1;
					else memo[i][j] = memo[i-1][j];
					continue;
				}
				
				if(j%2==0) {
                    if(num==1) 
                        memo[i][j] = Math.max(memo[i-1][j-1], memo[i-1][j]+1);
                    else 
                    	memo[i][j] = Math.max(memo[i-1][j-1]+1, memo[i-1][j]);
                }
                
                else {
                    if(num==1)
                        memo[i][j] = Math.max(memo[i-1][j-1]+1, memo[i-1][j]);
                    else
                        memo[i][j] = Math.max(memo[i-1][j-1], memo[i-1][j]+1);
                }
			}
			
		}
		
		//for(int[] i : memo) System.out.println(Arrays.toString(i));
		
		int ans = 0;
		for(int i=0;i<=W;i++) {
			ans = Math.max(ans, memo[T][i]);
		}
		
		System.out.println(ans);
		
		br.close();
	}



}
