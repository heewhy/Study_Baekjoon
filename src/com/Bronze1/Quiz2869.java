package com.Bronze1;

import java.io.*;
import java.util.*;

public class Quiz2869 {

	public static void main(String[] args) throws Exception{
		// 달팽이는 올라가고 싶다
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		//낮에 달팽이가 올라가는 길이
		int A = Integer.parseInt(st.nextToken());
		//밤에 달팽이가 미끄러지는 길이
		int B = Integer.parseInt(st.nextToken());
		//총나무높이
		int V = Integer.parseInt(st.nextToken());
		
		int day = (V-B) / (A-B);
		if((V-B)%(A-B)!=0) day++;
		
		sb.append(day);
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();	

	}

}
