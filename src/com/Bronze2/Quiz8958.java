package com.Bronze2;

import java.util.Scanner;

public class Quiz8958 {

	public static void main(String[] args) {
		// OX퀴즈
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=0;tc<T;tc++) {
			int score = 0;
			int cnt =1;
			String s = sc.next();
			char[] arr = new char[s.length()];
			for(int i=0;i<arr.length;i++) {
				arr[i] = s.charAt(i);
				if(arr[i]=='O') {
					score+=cnt;
					cnt++;
				}else {
					cnt=1;
				}
			}
			
			System.out.println(score);
		}
	}

}
