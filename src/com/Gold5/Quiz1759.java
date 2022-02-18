package com.Gold5;

import java.io.*;
import java.util.*;

public class Quiz1759 {
	
	static int L,C;
	static char[] input,numbers;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception{
		// 암호 만들기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st= new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		input = new char[C];
		numbers = new char[L];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<C;i++) {
			input[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(input);
		//System.out.println(Arrays.toString(input));
		comb(0,0);
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}

	private static void comb(int cnt, int start) {
		if(cnt==L) {
			if(check()) {
				for(char c: numbers) {
					sb.append(c);
				}
				sb.append("\n");
				return;
			}
			return;
		}
		
		for(int i=start;i<C;i++) {
			numbers[cnt]=input[i];
			comb(cnt+1,i+1);
		}
		
	}

	private static boolean check() {
		int cnt1=0;
		int cnt2=0;
		for(int i=0;i<L;i++) {
			if(numbers[i]=='a'||numbers[i]=='e'||numbers[i]=='i'||numbers[i]=='o'||numbers[i]=='u') {
				cnt1++;
			}else {
				cnt2++;
			}
		}
		if(cnt1<1) return false;
		if(cnt2<2) return false;
		return true;
	}

}
