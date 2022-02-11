package com.Bronze3;

import java.util.Scanner;

public class Quiz11022 {

	public static void main(String[] args) {
		// A+B - 8
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int i=1;i<=tc;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.printf("Case #%d: %d + %d = %d\n",i,a,b,a+b);
		}

	}

}
