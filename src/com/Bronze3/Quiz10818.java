package com.Bronze3;

import java.util.Scanner;

public class Quiz10818 {

	public static void main(String[] args) {
		// 최소, 최대
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		int[] arr = new int[cnt];
		
		for(int i=0;i<arr.length;i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i]<min) {
				min = arr[i];
			}
			if(arr[i]>max) {
				max = arr[i];		
			}
		}
		
		System.out.printf("%d %d",min,max);
		
	}

}
