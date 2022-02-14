package com.Bronze2;

import java.io.*;
import java.util.*;

public class Quiz12833 {

	public static void main(String[] args) throws Exception{
		// XORXORXOR
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
			
		int result=0;
		
		if(C%2==0) result=A;
		else result=A^B;
		
		sb.append(result);
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}

}
