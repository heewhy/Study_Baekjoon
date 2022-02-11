package com.Bronze3;

import java.util.Scanner;

public class Quiz2438 {

	public static void main(String[] args) {
		// 별 찍기 - 1
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i =0; i<n; i++) {
			for(int j=0;j<i+1;j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
