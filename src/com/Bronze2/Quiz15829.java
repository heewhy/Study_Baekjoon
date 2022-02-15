package com.Bronze2;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Quiz15829 {

	public static void main(String[] args) throws Exception{
		// Hashing
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		
		BigInteger r = new BigInteger("31");
		BigInteger M = new BigInteger("1234567891");
		
		//문자열의 길이
		int L = Integer.parseInt(br.readLine());
		
		String s = br.readLine();

		BigInteger answer = new BigInteger("0");
		
		for(int i=0;i<L;i++) {
			BigInteger num;
			num = BigInteger.valueOf((s.charAt(i)-'a')+1);
			//System.out.println("num :"+num);
			answer = answer.add(r.pow(i).mod(M).multiply(num));
			//System.out.println("answer : "+answer);
		}
		
		answer = answer.mod(M);
		
		sb.append(answer);
		
		bw.write(sb.toString());
		
		
		br.close();
		bw.flush();
		bw.close();
	}

}
