package com.Silver4;

import java.io.*;
import java.util.*;

public class Quiz10158 {

	public static void main(String[] args) throws Exception{
		// 개미
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		//행 크기
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		//개미 위치
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		//시간
		int time = Integer.parseInt(br.readLine());
		
		//더한거에 나머지가 그건가? 온거랑 간거를 어떻게 구분하지
		//x = (x+time)%W;
		//x = W-(x+time)%W;
		//y = (y+time)%H;
		//y = H-(y+time)%H;
		
		if(((x+time)/W)%2==0) {
			x = (x+time)%W;
		}else {
			x = W-(x+time)%W;;
		}
		
		if(((y+time)/H)%2==0) {
			y = (y+time)%H;
		}else {
			y = H-(y+time)%H;
		}
		
		sb.append(x).append(" ").append(y);
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}

}

//boolean updown = true;
//boolean leftright = true;
//
//
//while(time>0) {
//	
//	//벽을 만났을 때
//	if(y==H) {
//		updown=false;
//	}else if(y==0) {
//		updown=true;
//	}
//	
//	if(x==W) {
//		leftright=false;
//	}else if(x==0) {
//		leftright=true;
//	}
//	
//	//개미 이동
//	if(updown) {
//		y++;
//	}else {
//		y--;
//	}
//	if(leftright) {
//		x++;
//	}else {
//		x--;
//	}
//}