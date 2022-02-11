package com.Bronze2;

import java.util.Scanner;

public class Quiz3052 {

	public static void main(String[] args) {
		// 나머지
		int sum = 0;
		int[] arr = new int[42];
		
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<10;i++) {
			int n = sc.nextInt();
			arr[n%42]++;
		}
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>0) sum++;
		}
		System.out.println(sum);
	}

}
