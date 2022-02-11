package com.Bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Quiz10809 {

	public static void main(String[] args) throws IOException {
		// 알파벳 찾기
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		char[] arr = bf.readLine().toCharArray();
		int[] answer = new int[26];
		
		for(int i=0;i<answer.length;i++) {
			if(answer[i]==0) {
				answer[i]=-1;
			}
		}
		
		for(int i=0;i<arr.length;i++) {
			if(answer[arr[i]-'a']==-1) {
				answer[arr[i]-'a']=i;
			}
		}
		
		
		for(int a : answer) {
			System.out.print(a+" ");
		}
		


	}

}
