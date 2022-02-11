package com.Bronze1;

import java.util.Scanner;

public class Quiz4344 {

	public static void main(String[] args) {
		// 평균은 넘겠지
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1;tc<=T;tc++) {
			
			int size = sc.nextInt();
			int[] arr = new int[size];
			int sum=0;
			double avg = 0.0;
			int cnt =0;
			
			for(int i=0;i<arr.length;i++) {
				arr[i] = sc.nextInt();
				sum += arr[i];
			}
			avg = 1.0*sum/size;
			
			for(int i=0;i<arr.length;i++) {
				if(arr[i]>avg) cnt++;
			}
			double val = 1.0*cnt/size*100;
			
			System.out.printf("%2.3f",val);
			System.out.println("%");
		}

	}

}
