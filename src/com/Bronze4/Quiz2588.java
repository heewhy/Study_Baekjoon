package com.Bronze4;

import java.util.Scanner;

public class Quiz2588 {

	public static void main(String[] args) {
		// 곱셈
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		//100, 10, 1의 자리 분리
		int i = b/100;
		int j = b/10-i*10;
		int k = b - (b/10)*10;
//		System.out.println(i);
//		System.out.println(j);
//		System.out.println(k);
		
		System.out.println(a*k);
		System.out.println(a*j);
		System.out.println(a*i);
		System.out.println(a*b);
	}

}
