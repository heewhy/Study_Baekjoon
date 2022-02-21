package com.Silver5;

import java.io.*;
import java.util.*;

public class Quiz2635 {

	static int ans;
	static int[] arr,numbers;
	
	public static void main(String[] args) throws Exception{
		// 수 이어가기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		arr[0] = N;
		
		check(N,0,1,true);
		
		sb.append(ans+"\n");
		for(int i:numbers) {
			sb.append(i+" ");
		}
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}

	private static void check(int n,int i,int cnt,boolean check) {
		
		if(i<0) {
			return;
		}
		
		if(cnt>ans) {
			numbers = Arrays.copyOf(arr, cnt+1);
			//System.out.println(Arrays.toString(arr));
			ans=Math.max(ans, cnt+1);
		}
		
		if(check) {
			for(int k=1;k<n;k++) {
				arr[1] = n-k;
				check(n,n-k,cnt,false);
			}
		}else {
			arr[cnt+1] = n-i;
			check(i,n-i,cnt+1,false);
		}
		
	}

}
