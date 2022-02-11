package com.Bronze4;

import java.util.Scanner;

public class Quiz2753 {

	public static void main(String[] args) {
		// 윤년
		//연도가 주어졌을 때, 윤년이면 1, 아니면 0
		//윤년 연도가 4의 배수, 100의 배수가 아닐때 또는 400의 배수일때
		
		Scanner sc= new Scanner(System.in);
		int a = sc.nextInt();
		
		if(a%4==0) {
			if(a%400==0||a%100!=0) {
				System.out.println("1");
			}else {
				System.out.println("0");
			}
		}else {
			System.out.println("0");
		}

	}

}
