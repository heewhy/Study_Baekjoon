package com.Bronze4;

import java.util.Scanner;

public class Quiz1330 {

	public static void main(String[] args) {
		// 두 수 비교하기
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		if(a>b) {
			System.out.println(">");
		}
		if(a<b) {
			System.out.println("<");
		}
		if(a==b){
			System.out.println("==");
		}
	}

}
