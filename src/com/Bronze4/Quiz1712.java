package com.Bronze4;

import java.io.*;
import java.util.*;

public class Quiz1712 {

	public static void main(String[] args) throws Exception{
		// 손익분기점
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[3];
		//고정비용
		arr[0] = Integer.parseInt(st.nextToken());
		//가변비용
		arr[1] = Integer.parseInt(st.nextToken());
		//판매비용
		arr[2] = Integer.parseInt(st.nextToken());
		
		//System.out.println(Arrays.toString(arr));
		
		int cnt=1;
		
		if(arr[1]>=arr[2]) cnt = -1;	
		else {
			cnt = arr[0]/(arr[2]-arr[1]);
		}
		
		sb.append(cnt+1);
		
		bw.write(sb+"\n");
		
		br.close();
		bw.flush();
		bw.close();
		

	}

}
