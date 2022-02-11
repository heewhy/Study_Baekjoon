package com.Silver4;

import java.util.Scanner;
import java.util.Stack;

public class Quiz10773 {

	public static void main(String[] args) {
		// 제로
		
		Scanner sc = new Scanner(System.in);
		
		int size = sc.nextInt();
		
		Stack<Integer> stack = new Stack<>();
		int sum = 0;
		int[] arr = new int[size];
		
		for(int i=0;i<size;i++) {
			arr[i] = sc.nextInt();			
		}
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==0) {
				stack.pop();
			}else{
				stack.push(arr[i]);
			}			
		}
		while(!stack.empty()) {
			sum+=stack.peek();
			stack.pop();
		}
		
		System.out.println(sum);
	}

}
