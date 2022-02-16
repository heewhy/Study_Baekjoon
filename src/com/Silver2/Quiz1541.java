package com.Silver2;

import java.io.*;
import java.util.*;

public class Quiz1541 {

	public static void main(String[] args) throws Exception{
		// 잃어버린 괄호
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		//-로 문자열 분리
		String[] strs = str.split("-");
		int sum = 0;
		//처음 체크
		boolean check = true;
		
		for(int i=0; i<strs.length;i++) {
			
			int temp=0;
			//+로 문자열 분리
			String[] strs2 = strs[i].split("\\+");
			//+도 \\
			//System.out.println(Arrays.toString(strs2));
			
			for(int j=0;j<strs2.length;j++) {
//				if(j==0) {
//					sum = Integer.parseInt(strs2[0]);
//				}
				//분리된 값 더하기
				temp+=Integer.parseInt(strs2[j]);
			}
			
			//처음 토큰만 더하고 나머지는 빼기
			if(check) {
				sum=temp;
				check=false;
			}else {
				sum-=temp;
			}
			
		}
		
		sb.append(sum);
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}

}
