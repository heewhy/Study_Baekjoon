package com.Silver3;

import java.io.*;
import java.util.*;

public class Quiz14501 {

	static int ans;
	
	public static void main(String[] args) throws Exception{
		// 퇴사
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//N일
		int N = Integer.parseInt(br.readLine());
		
		//[0] 상담에 걸리는 기간
		//[1] 상담을 했을 때 받을 수 있는 금액
		int[][] talk = new int[N][2];

		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());

			talk[i][0] = Integer.parseInt(st.nextToken());
			talk[i][1] = Integer.parseInt(st.nextToken());
		}
		
		ans=0;
		
		work(talk,0,0);
			
		System.out.println(ans);
		
		br.close();
	}

	private static void work(int[][] talk,int day,int money) {
		
		if(day>=talk.length) {
			ans = Math.max(ans, money);
			return;
		}
		
		//원래일수+걸리는시간이 총일보다 적을 경우에 
		//일한다 원래일수+걸리는시간 돈+버는돈
		if(day+talk[day][0]<= talk.length) work(talk,day+talk[day][0],money+talk[day][1]);
		
		//하루를 보낸다
		work(talk,day+1,money);
	}

}
