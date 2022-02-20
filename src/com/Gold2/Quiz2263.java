package com.Gold2;

import java.io.*;
import java.util.*;

public class Quiz2263 {
	
	static int N;
	static int[] in_order;
	static int[] in_order_idx; // 중위 순회 루트들의 인덱스 정보
	static int[] post_order;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception{
		//트리의 순회
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		sb = new StringBuilder();

		in_order = new int[N+1];
		in_order_idx = new int[N+1];
		post_order = new int[N+1];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			in_order[i] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			post_order[i] = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++)
			in_order_idx[in_order[i]] = i;

		getPreOrder(0, N - 1, 0, N - 1);
		bw.write(sb.toString());
        
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static void getPreOrder(int in_start, int in_end, int p_start, int p_end) throws Exception {
		if (in_start > in_end || p_start > p_end)
			return;

		// 루트 구하기. 후위 순회의 마지막 인덱스 p_end = 루트의 인덱스
		int root = post_order[p_end];
		sb.append(root + " ");

		// 중위 순회에서 루트의 인덱스 구하
		int rootIdx = in_order_idx[root];
		// 중위 순회에서 루트 기준 왼쪽에 노드 개수 계산
		int left = rootIdx - in_start;

		// 좌측 자식 노드
		getPreOrder(in_start, rootIdx - 1, p_start, p_start + left - 1);

		// 우측 자식 노드
		getPreOrder(rootIdx + 1, in_end, p_start + left, p_end - 1);
	}
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
