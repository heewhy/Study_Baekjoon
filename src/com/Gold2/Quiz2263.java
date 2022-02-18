package com.Gold2;

import java.io.*;
import java.util.*;

public class Quiz2263 {

	public static void main(String[] args) throws Exception{
		// 트리의 순회
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		//좌 루트 우
		String inorder = br.readLine();
		inorder = inorder.replace(" ","");
		//좌 우 루트
		String postorder = br.readLine();
		postorder = postorder.replace(" ","");
		//결과는 루트 좌 우
		
		//System.out.println(inorder);
		//System.out.println(postorder);
		
		//postorder에서 루트를 구해서 inorder 자르기
		char c = postorder.charAt(N-1);
		String root = String.valueOf(c);
		//System.out.println(root);
		
		//split[0] = 좌
		//split[1] = 우
		String[] split = inorder.split(root);

		//System.out.println(split[0]);
		//System.out.println(split[1]);
		
		//결과는 루트 좌 우
		sb.append(root+" ");
		for(int i=0;i<split[0].length();i++) {
			sb.append(split[0].charAt(i)+" ");
		}
		for(int i=0;i<split[1].length();i++) {
			sb.append(split[1].charAt(i)+" ");
		}
		
		sb.deleteCharAt(sb.length()-1);
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}
	//크기가 홀수다 찍고
	//짝수다 바꿔서찍기
}
/*
6
5 2 4 1 6 3
5 4 2 6 3 1
답: 1 2 5 4 3 6

10
1 3 2 5 4 6 8 7 10 9
1 2 3 4 5 8 10 9 7 6
답: 6 5 3 1 2 4 7 8 9 10 

11
8 4 2 9 5 1 10 6 3 11 7
8 4 9 5 2 10 6 11 7 3 1
답: 1 2 4 8 5 9 3 6 10 7 11

21
1 3 2 7 4 6 5 15 11 9 12 8 13 10 14 21 19 17 20 16 18
1 2 3 4 5 6 7 11 12 9 13 14 10 8 15 19 20 17 18 16 21
답: 21 15 7 3 1 2 6 4 5 8 9 11 12 10 13 14 16 17 19 20 18

 */
