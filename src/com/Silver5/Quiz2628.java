package com.Silver5;

import java.io.*;
import java.util.*;

public class Quiz2628 {

	public static void main(String[] args) throws Exception{
		// 종이자르기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		int cnt = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> row = new ArrayList<Integer>();
		ArrayList<Integer> col = new ArrayList<Integer>();
		
		
		
		while(cnt-->0) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			if(dir==0) {
				row.add(num);
			}else {
				col.add(num);
			}
		}
		
		row.add(R);
		col.add(C);
		
		row.sort((a,b)->a-b);
		col.sort((a,b)->a-b);
		
		int max_row = row.get(0);
		int max_col = col.get(0);
		//System.out.println(row);
		//System.out.println(col);
		
		for(int i=0;i<row.size()-1;i++) {
			max_row = Math.max(max_row, row.get(i+1)-row.get(i));
		}
		for(int i=0;i<col.size()-1;i++) {
			max_col = Math.max(max_col, col.get(i+1)-col.get(i));
		}
		
		//System.out.println(max_row);
		//System.out.println(max_col);
		
		if(row.size()==1) max_row = R;
		if(col.size()==1) max_col = C;
		sb.append(max_row*max_col);
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}

}
