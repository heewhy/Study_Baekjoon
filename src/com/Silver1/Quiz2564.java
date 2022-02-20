package com.Silver1;

import java.io.*;
import java.util.*;

public class Quiz2564 {

	public static void main(String[] args) throws Exception{
		// 경비원
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(br.readLine());
		
		int[][] locations = new int[C+1][2];
		
		for(int i=0; i<C+1; i++) {
			st = new StringTokenizer(br.readLine());
			locations[i][0] = Integer.parseInt(st.nextToken());
			locations[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int sum = 0;
		int dir = locations[C][0];
		int num = locations[C][1];
		if(dir == 1) { //동근이가 상에 있을 때
			for(int i=0; i<C; i++) {
				if(locations[i][0] == 1) {
					sum += Math.abs(locations[i][1] - num);
				}else if(locations[i][0] == 2) {
					sum += Math.min(M + locations[i][1] + num, M + (N - locations[i][1]) + (N - num));
				}else if(locations[i][0] == 3) {
					sum += locations[i][1] + num;
				}else {
					sum += (M - locations[i][1]) + num;
				}
			}
		}
		else if(dir == 2){ //하
			for(int i=0; i<C; i++) {
				if(locations[i][0] == 1) {
					sum += Math.min(M + locations[i][1] + num, M + (N - locations[i][1]) + (N - num));
				}else if(locations[i][0] == 2) {
					sum += Math.abs(locations[i][1] - num);
				}else if(locations[i][0] == 3) {
					sum += (M - locations[i][1]) + num;
				}else {
					sum += (M - locations[i][1]) + (N - num);
				}
			}
		}
		else if(dir == 3) { //좌
			for(int i=0; i<C; i++) {
				if(locations[i][0] == 1) {
					sum += num + locations[i][1];
				}else if(locations[i][0] == 2) {
					sum += (M - num) + locations[i][1];
				}else if(locations[i][0] == 3) {
					sum += Math.abs(locations[i][1] - num);
				}else {
					sum += Math.min(N + locations[i][1] + num, N + (M - locations[i][1]) + (M - num));
				}
			}
		}
		else if(dir == 4) { //우
			for(int i=0; i<C; i++) {
				if(locations[i][0] == 1) {
					sum += num + (N - locations[i][1]);
				}else if(locations[i][0] == 2) {
					sum += (M - num) + (N - locations[i][1]);
				}else if(locations[i][0] == 3) {
					sum += Math.min(N + locations[i][1] + num, N + (M - locations[i][1]) + (M - num));
				}else {
					sum += Math.abs(locations[i][1] - num);
				}
			}
		}
		
		sb.append(sum+"\n");
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}

}
