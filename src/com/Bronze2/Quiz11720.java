package com.Bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Quiz11720 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 숫자의 합
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(bf.readLine());
		
		String s = bf.readLine();
		char[] arr = s.toCharArray();
		int sum=0;
		
		for(char a : arr) {
			sum+= a-'0';
		}
		
		System.out.println(sum);
		
	}

}
