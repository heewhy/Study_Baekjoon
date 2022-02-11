package com.Bronze3;

import java.util.Scanner;

public class Quiz11021 {

	public static void main(String[] args) {
		// A+B - 7
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int i=1;i<=tc;i++) {
			int a = sc.nextInt();
			int b=  sc.nextInt();
			System.out.printf("Case #%d: %d\n",i,a+b);
		}

	}

}
