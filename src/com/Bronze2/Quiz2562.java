package com.Bronze2;

import java.util.Scanner;

public class Quiz2562 {

	public static void main(String[] args) {
		// 최댓값
		int max = Integer.MIN_VALUE;
		int cnt =0;
		Scanner sc = new Scanner(System.in);
		
		for(int i=0;i<9;i++) {
			int n = sc.nextInt();
			if(n>max) {
				max = n;
				cnt = i;
			}
		}
		
		System.out.println(max);
		System.out.println(cnt+1);
	}

}
