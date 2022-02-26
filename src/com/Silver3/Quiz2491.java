package com.Silver3;

import java.io.*;
import java.util.*;

public class Quiz2491 {

	public static void main(String[] args) throws Exception{
		// 수열
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] upcnt = new int[N];
		int[] downcnt = new int[N];
 		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int upidx=0;
		int downidx=0;
		for(int i=0;i<N-1;i++) {
			if(arr[i]==arr[i+1]){
				upcnt[upidx]++;
				downcnt[downidx]++;
			}
			else if(arr[i]<arr[i+1]) {
				upcnt[upidx]++;
				downidx++;
			}else{
				downcnt[downidx]++;
				upidx++;
			}
		}
		//System.out.println(Arrays.toString(upcnt));
		//System.out.println(Arrays.toString(downcnt));
		
		Arrays.sort(upcnt);
		Arrays.sort(downcnt);
		
		
		int ans = Math.max(upcnt[N-1]+1, downcnt[N-1]+1);
		sb.append(ans);
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}

}
