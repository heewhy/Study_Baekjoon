package com.Bronze1;

import java.util.Scanner;

public class Quiz1110 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int cnt=0;
		int num = sc.nextInt();
		int T = num;
		
		while(true) {
			if(num-10<0) {
				int a = 0;
				int b = num;
				int answer = (a+b)%10;
				
				num= (b*10)+answer;
				cnt++;				
			}else {
				int a = num/10;
				int b = num%10;
				int answer = (a+b)%10;
				
				num= (b*10)+answer;
				cnt++;
			}
			if(T==num) break;
		}
		System.out.println(cnt);
	}

}
