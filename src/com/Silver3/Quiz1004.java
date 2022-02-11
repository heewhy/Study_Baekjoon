package com.Silver3;

import java.io.*;
import java.util.*;


public class Quiz1004 {

	public static void main(String[] args) throws Exception{
		// 어린왕자
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			
			int cnt=0;
			
			st = new StringTokenizer(br.readLine());
			
			int start_x = Integer.parseInt(st.nextToken());
			int start_y = Integer.parseInt(st.nextToken());
			int end_x = Integer.parseInt(st.nextToken());
			int end_y = Integer.parseInt(st.nextToken());
			
			int N = Integer.parseInt(br.readLine());
			
			while(N-->0) {
				st=new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				
				boolean hasStartContain = hasContain(start_x, start_y, x, y, r);
                boolean hasEndContain = hasContain(end_x, end_y, x, y, r);
                
                if (!(hasStartContain && hasEndContain) && (hasStartContain || hasEndContain))
                {
                    cnt++;
                }
			}
			
			sb.append(cnt+"\n");
		}
		
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	/**
     * 출발/도착점 포함 여부 반환 함수
     *
     * @param xo: [int] 출발/도착점의 x좌표
     * @param yo: [int] 출발/도착점의 y좌표
     * @param x: [int] 행성의 x좌표
     * @param y: [int] 행성의 y좌표
     * @param r: [int] 행성의 반지름
     *
     * @return [boolean] 출발/도착점 포함 여부
     */
	private static boolean hasContain(int xo, int yo, int x, int y, int r)
    {
        return Math.sqrt(Math.pow(xo - x, 2) + Math.pow(yo - y, 2)) < r;
    }

}
