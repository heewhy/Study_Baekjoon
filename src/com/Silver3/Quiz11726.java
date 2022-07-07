package com.Silver3;

import java.io.*;
import java.util.*;

public class Quiz11726 {

	public static void main(String[] args) throws Exception{
		// 2×n 타일링
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int [N+1];
		dp[1] = 1;
		//dp[2] =2;
		
		for(int i=2;i<=N;i++) {
			if(i==2) dp[2] = 2;
			else dp[i] = (dp[i-2]+dp[i-1])%10007; 
		}
		
		//dp[N]%10007 X
		//결과를 ~로 나눈 나머지를 출력하는 문제는 일반적으로 그 수가 너무 커서 
		//일반적인 자료형에 담을 수 없기 때문에 
		//그런 조건을 만들어 둔 것
		//답이 중도에 너무 커져서 int가 담을 수 있는 수의 범위를 초과하기 때문에 오버플로가 발생
		System.out.println(dp[N]);
		
		br.close();
	}

}
