package com.Bronze2;

import java.util.Scanner;

public class Quiz2577 {

	public static void main(String[] args) {
		// 숫자의 개수
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		int value = a*b*c;
		
		String s = Integer.toString(value);
		
		for(int i=0; i<10; i++) {
			int count = 0;
			for(int j=0;j<s.length();j++) {
				if((s.charAt(j)-'0')==i) {
					count++;
				}
			}
			System.out.println(count);
		}
		
	}

}
