package com.Bronze3;

import java.util.Scanner;

public class Quiz2439 {

	public static void main(String[] args) {
		// 별 찍기 - 2
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i=0; i<n;i++) {
			for(int j=0; j<n;j++) {
				if(i+j>=n-1) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}	
			}
			System.out.println();
		}

	}

}
