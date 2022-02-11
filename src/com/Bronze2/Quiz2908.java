package com.Bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Quiz2908 {

	public static void main(String[] args) throws IOException {
		// 상수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		char[] a = st.nextToken().toCharArray();
		char[] b = st.nextToken().toCharArray();
		
		boolean check = true; //true a false b
		
		for(int i=2;i>=0;i--) {
			if(a[i]>b[i]) {
				break;
			}else if(a[i]<b[i]){
				check=false;
				break;
			}
		}
		if(check) {
			for(int i=2;i>=0;i--) {
				System.out.print(a[i]);
			}
		}else {
			for(int i=2;i>=0;i--) {
				System.out.print(b[i]);
			}
		}

	}

}
