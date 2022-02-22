package com.Silver3;

import java.io.*;
import java.util.*;

public class Quiz1244 {
	
	static int[] arr;

	public static void main(String[] args) throws Exception{
		// 스위치 켜고 끄기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int R = Integer.parseInt(br.readLine());
		
		while(R-->0){
			st = new StringTokenizer(br.readLine());
			int who = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			if(who==1) {
				//남자 배수 스위치전환
				for(int k=1;k<=N;k++) {
					if(k%num==0) {
						reverse(k);
					}
				}
			}else if(who==2) {
				//여자 양쪽이 같으면 
				for(int k=1;k<=N/2;k++) {
					if(num-k>=0&&num+k<=N&&arr[num-k]==arr[num+k]) {
						reverse(num-k);
						reverse(num+k);
					}else if(num-k>=1&&num+k<=N&&arr[num-k]!=arr[num+k]) {
						//경계 안인데 다를경우
						reverse(num);
						break;
					}else if(num-k<1||num+k>N) {
						//경계밖으로 나간경우
						reverse(num);
						break;
					}
					
				}
			}
			
		}
		
		int cnt=0;
		for(int i : arr) {
			sb.append(i+" ");
			cnt++;
			if(cnt!=0&&cnt%21==0) sb.append("\n");
		}
		
		sb.delete(0, 2);
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}

	private static void reverse(int k) {
		if(arr[k]==1) {
			arr[k]=0;
		}else {
			arr[k]=1;
		}
		
	}

}
