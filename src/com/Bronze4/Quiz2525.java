package com.Bronze4;

import java.io.*;
import java.util.*;

public class Quiz2525 {

	public static void main(String[] args) throws Exception{
		// 오븐 시계
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		//현재 시각
		int hour = Integer.parseInt(st.nextToken());
		int min = Integer.parseInt(st.nextToken());
		
		//요리하는데 필요한 시간
		int cook = Integer.parseInt(br.readLine());
		
		//분에 더하기
		min += cook;
		
		
		//60분 이상이면 시간을 올려주고 시간이 24가되면 0으로
		while(min>=60) {
			min-=60;
			hour++;
			
			if(hour==24) {
				hour=0;
			}
		}
		
		
		sb.append(hour).append(" ").append(min);
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();

	}

}
