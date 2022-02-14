package com.Bronze2;

import java.io.*;
import java.util.*;

public class Quiz2292 {

	public static void main(String[] args) throws Exception{
		// 벌집
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int wall=2;
		int cnt=1;
		
		if(N==1) sb.append(cnt);
		else {
			while(wall<=N) {
				wall=wall+(6*cnt);
				cnt++;
			}
			sb.append(cnt);			
		}
		
		bw.write(sb.toString());
		
				
		br.close();
		bw.flush();
		bw.close();

	}

}
