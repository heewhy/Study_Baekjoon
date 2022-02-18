package com.Silver5;

import java.io.*;
import java.util.*;

public class Quiz2609 {

	public static void main(String[] args) throws Exception{
		//최대 공약수와 최소공배수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb= new StringBuilder();
		
		//GCD 유클리드 호제법
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		//최대공약수
		int d = gcd(a, b);
		//최대 공배수
		int m = a*b/d;
		
		sb.append(d+"\n").append(m+"\n");
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
	
	/**
	 * 최대 공약수를 찾는 함수
	 * @param a 최대공약수를 찾는 첫번째 숫자
	 * @param b 최대공약수를 찾는 두번째 숫자
	 * @return 최대공약수
	 */
	private static int gcd(int a, int b) {
		//기저조건
		if (b == 0)
			return a;
            
		// GCD(a, b) = GCD(b, r)이므로 (r = a % b)
		return gcd(b, a % b);
	}

}
