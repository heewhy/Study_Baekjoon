package com.Bronze5;

import java.util.Scanner;

public class Quiz8393 {

	public static void main(String[] args) {
		// 합
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int sum = 0;
		for(int i=0; i<=a;i++) {
			sum+=i;
		}
		System.out.println(sum);
	}

}
