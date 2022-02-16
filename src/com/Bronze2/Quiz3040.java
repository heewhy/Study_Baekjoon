package com.Bronze2;

import java.io.*;
import java.util.*;

public class Quiz3040 {

	static int N,R,smalls[],result[];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		// 백설 공주와 일곱 난쟁이
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		N = 9;
		R = 7;
		
		smalls = new int[N];
		result = new int[R];
		
		for(int i=0;i<N;i++) {
			smalls[i] = Integer.parseInt(br.readLine());
		}
		
		comb(0,0);
		
		bw.write(sb.toString());
		
		
		br.close();
		bw.flush();
		bw.close();

	}

	static void comb(int cnt,int start) { 
		if(cnt==R) {
			if(sumcheck(result)) {
				for(int i : result) {
					sb.append(i+"\n");
				}
				//System.out.println(Arrays.toString(result));
				
			}
			return;
		}
		
		for(int i=start;i<N;i++) { 
			result[cnt]=smalls[i];
			comb(cnt+1,i+1);
		}
		
	}

	private static boolean sumcheck(int[] arr) {
		int sum=0;
		for(int i=0;i<arr.length;i++) {
			sum+=arr[i];
		}
		if(sum==100) return true;
		else return false;
	}

}
