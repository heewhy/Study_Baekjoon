package com.Bronze2;

import java.io.*;
import java.util.*;

public class Quiz2231 {

	public static void main(String[] args) throws Exception{
		// 분해합
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		int N = Integer.parseInt(str);
		int length = str.length();
		int result=0;
		
		for(int i=(N-(length*9));i<N;i++) {
			int number = i;
			int sum=0;
			
			while(number!=0) {
				sum +=number%10;
				number/=10;
			}
			
			if(sum+i==N) {
				result=i;
				break;
			}
		}
		sb.append(result);
		
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();

	}

}
