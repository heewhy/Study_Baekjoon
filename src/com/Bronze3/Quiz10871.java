package com.Bronze3;

import java.util.Scanner;

public class Quiz10871 {

	public static void main(String[] args) {
		// X보다 작은 수
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int X = sc.nextInt();
		
		
		for(int i=0;i<n;i++) {
			int arr = sc.nextInt();
			if(arr<X) {
				System.out.printf("%d ",arr);
			}
		}
		
	}

}
