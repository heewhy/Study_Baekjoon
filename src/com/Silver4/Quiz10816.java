package com.Silver4;

import java.io.*;
import java.util.*;

public class Quiz10816 {

	public static void main(String[] args) throws Exception{
		// 숫자 카드 2
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb= new StringBuilder();
		StringTokenizer st;
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		int N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			int key = Integer.parseInt(st.nextToken());
			
			/* 
			 * getOrDefault(key, defaultValue)
			 * key에 대해 map에 저장 된 value를 반환한다.
			 * 만약 value가 없을 경우 defaultValue값을 반환한다.
			 */
			map.put(key, map.getOrDefault(key, 0) + 1);
		}
		
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			int key = Integer.parseInt(st.nextToken());
			
			sb.append(map.getOrDefault(key, 0)).append(' ');
		}
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();

	}

}
/* 시간초과
		int N = Integer.parseInt(br.readLine());
		int[] card = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		int[] check = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			check[i] = Integer.parseInt(st.nextToken());
		}
		
		
		for(int i=0;i<M;i++) {
			int cnt=0;
			for(int j=0;j<N;j++) {
				if(check[i]==card[j]) {
					cnt++;
				}
			}
			sb.append(cnt+" ");
		}
 */
