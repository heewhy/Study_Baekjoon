package com.Silver4;

import java.util.Scanner;

public class Quiz1065 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		System.out.print(arithmetic_sequence(in.nextInt()));
	}

 
	public static int arithmetic_sequence(int num) {
		int cnt = 0; // 한수 카운팅
 
		if (num < 100) {
			return num;
		}
 
		else {
			cnt = 99;
			if (num == 1000) { // 예외처리 필수
				num = 999;
			}
 
			for (int i = 100; i <= num; i++) {
				int hun = i / 100; // 백의 자릿수
				int ten = (i / 10) % 10; // 십의 자릿수
				int one = i % 10;
 
				if ((hun - ten) == (ten - one)) { // 각 자릿수가 수열을 이루면
					cnt++;
				}
			}
		}
 
		return cnt;
	}
 
}