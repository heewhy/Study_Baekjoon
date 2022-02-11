package com.Silver5;

import java.io.*;
import java.util.*;


public class Quiz1316 {

	public static void main(String[] args) throws Exception{
		// 그룹 단어 체커
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		
		int N = Integer.parseInt(br.readLine());
		int cnt =0;
		
		for(int st=0;st<N;st++) {
			String s = br.readLine();
			
			if(isGroupWord(s)) cnt++;
		}
		
		sb.append(cnt);
		
		bw.write(sb+"");
		br.close();
		bw.flush();
		bw.close();
	}
	
	public static boolean isGroupWord(String word) {
		ArrayList<String> alpList = new ArrayList<String>();
        
		for(int i = 0; i < word.length(); i++) {
			String alp =  word.substring(i, i+1); // 알파벳으로 나눔
			if(!alpList.contains(alp)) { // 알파벳이 alpList에 없다면 추가한다.
				alpList.add(alp);	
			} else if(word.charAt(i-1) != word.charAt((i))) { 
           	 // 알파벳이 alpList에 있는데 앞 단어와 같지 않다면 그룹단어가 아니므로 false를 리턴한다.
				return false;
			}
		}
		return true;
	}

}
