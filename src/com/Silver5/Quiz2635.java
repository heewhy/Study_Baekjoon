package com.Silver5;

import java.io.*;
import java.util.*;

public class Quiz2635 {

	//static int ans;
	//static int[] arr,numbers;
	
	public static void main(String[] args) throws Exception{
		// 수 이어가기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int cnt = 0; //리스트 최대 크기 저장
		
		ArrayList<Integer> result = new ArrayList<>();
		
		for(int i=1;i<=N;i++) {
			// 현재경우의 숫자 조합을 저장할 리스트
			ArrayList<Integer> nowlist = new ArrayList<Integer>();   
			// n을 리스트의 1번 i를 리스트의 2번에 저장해두고 계산 시작
            nowlist.add(N);                                      
            nowlist.add(i);
            int prev1 = N;
            int prev2 = i;
            
            // 결과가 0보다 큰 동안 앞앞 숫자에서 앞 숫자를 빼준값을 리스트에 저장
            while(true) {                                        
                int temp = prev1 - prev2;
                if(temp>=0) {
                    nowlist.add(temp);
                }else {
                    break;
                }
                // 앞앞 숫자와 앞 숫자를 새로 지정
                prev1 = prev2;                                    
                prev2 = temp;
            }
            // 이번 회차가 최대 개수의 숫자라면 해당 개수를 max에 저장하고 리스트의 숫자 조합을 maxlist에 저장
            if(cnt < nowlist.size()) {                            
                cnt = nowlist.size();
                result = nowlist;
            }
		}
		
		sb.append(cnt+"\n");
		for(int i=0;i<result.size();i++) {
			sb.append(result.get(i)+" ");
		}
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}
/* 틀린거찾기
 		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		if(N<7) arr = new int[8];
		arr[0] = N;
		
		check(N,0,1,true);
		
		sb.append(ans+"\n");
		for(int i:numbers) {
			sb.append(i+" ");
		}
		
		if(N==1) sb.append(1);
		//main
 
	private static void check(int n,int i,int cnt,boolean check) {
		
		if(i<0) {
			return;
		}
		
		if(cnt>=ans) {
			numbers = Arrays.copyOf(arr, cnt+1);
			//System.out.println(Arrays.toString(arr));
			ans=Math.max(ans, cnt+1);
		}
		
		if(check) {
			for(int k=1;k<n;k++) {
				arr[1] = n-k;
				check(n,n-k,cnt,false);
			}
		}else {
			arr[cnt+1] = n-i;
			check(i,n-i,cnt+1,false);
		}
		
	}
*/
}
