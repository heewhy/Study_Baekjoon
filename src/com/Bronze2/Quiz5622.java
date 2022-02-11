package com.Bronze2;

import java.io.*;
import java.util.*;

public class Quiz5622 {

	public static void main(String[] args) throws Exception{
		// 다이얼
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		int time=0;
		
		for(int i=0;i<str.length();i++) {
			char c = str.charAt(i);
			int check = c-'A'; //0~25
			
			if(check<3) {
				time+=3;
			}else if(check<6) {
				time+=4;
			}else if(check<9) {
				time+=5;
			}else if(check<12) {
				time+=6;
			}else if(check<15) {
				time+=7;
			}else if(check<19) {
				time+=8;
			}else if(check<22) {
				time+=9;
			}else if(check<=25) {
				time+=10;
			}
		
		}
		
		StringBuilder sb = new StringBuilder();
				
		sb.append(time);
		
		bw.write(sb+"\n");
		
		br.close();
		bw.flush();
		bw.close();
	}

}
