package com.Bronze5;

import java.util.Scanner;

public class Quiz2884 {

	public static void main(String[] args) {
		// 알람시계
		// 45분 일찍 알람 설정하기
		Scanner sc = new Scanner(System.in);
		
		int hour = sc.nextInt();
		int min = sc.nextInt();
		
		if(min<45) {
			if(hour>0) {
				hour--;
			}else hour=23;
			min=60-(45-min);
		
			System.out.println(hour + " " + min);
		}else {
			min-=45;
			System.out.println(hour + " " + min);
		}
		

	}

}
