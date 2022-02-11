package com.Bronze1;

import java.util.Scanner;

public class Quiz1546 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] arr = new int[T];
		int max= Integer.MIN_VALUE;
		double val = 0.0;
		int cnt=0;
		
		for(int i=0;i<T;i++) {
			arr[i] = sc.nextInt();
			if(arr[i]>max) {
				max = arr[i];
				cnt = i;
			}
		}
		
		for(int i=0;i<arr.length;i++) {
			val += (1.0*arr[i]/max)*100;
		}
		System.out.println(val/T);
	}

}
