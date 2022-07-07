package com.Gold5;

import java.io.*;
import java.util.*;

public class Quiz12865 {

	public static void main(String[] args) throws Exception{
		// 평범한 배낭
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //물품의 수
		int K = Integer.parseInt(st.nextToken()); //최대 무게
		
		int[] weights = new int[N+1];
		int[] profits = new int[N+1];
		
		int[][] results = new int[N+1][K+1];
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			weights[i] = Integer.parseInt(st.nextToken());
			profits[i] = Integer.parseInt(st.nextToken());
		}
		
		int itemWeight = 0;
		int itemProfit = 0;
		
		for(int item=1;item<=N;item++) {
			itemWeight = weights[item];
			itemProfit = profits[item];
			
			for(int weight=1;weight<=K;weight++) {
				if(itemWeight <= weight) {
					results[item][weight] = 
							Math.max(results[item-1][weight], itemProfit+results[item-1][weight-itemWeight]);
				}
				else {
					results[item][weight] = results[item-1][weight];
				}
				
			}
			
		}
		
		System.out.println(results[N][K]);
		
		br.close();
	}

}
