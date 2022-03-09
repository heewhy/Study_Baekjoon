package com.Bronze2;

import java.io.*;
import java.util.*;

public class Quiz13458 {
	
	public static void main(String[] args) throws Exception{
		//시험 감독
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		
		//시험장 개수
		int N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		ArrayList<Integer> exam = new ArrayList<Integer>();
		
		while(N-->0) {
			exam.add(Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(br.readLine());
		//총 감독관 감시 인원
		int B = Integer.parseInt(st.nextToken());
		//감독관 감시 인원
		int C = Integer.parseInt(st.nextToken());
		
		long ans=0L;
		
		for(int i=0;i<exam.size();i++) {
			
			//시험장 1개의 응시생 수
			int temp = exam.get(i);
			
			//총감독관배치
			temp-=B;
			ans++;
			
			//부감독관배치 temp가 0이하일때
			if(temp>0) {
				ans+= temp/C;
				if(temp%C!=0) ans++;
			}
		}
		
		sb.append(ans);
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}
}
