package com.Bronze5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Quiz18108 {

	public static void main(String[] args) throws IOException {
		// 1998년생인 내가 태국에서는 2541년생?! 543
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int a = Integer.parseInt(br.readLine());
		sb.append(a-543);
		
		System.out.println(sb.toString());
		
	}

}
