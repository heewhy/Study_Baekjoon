package com.Gold4;

import java.io.*;
import java.util.*;

public class Quiz20955 {
	
	static int N;
	static int[] parents;
	static int cnt;
	
	public static void main(String[] args) throws Exception{
		// 민서의 응급수술
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		parents = new int[N+1];
		for(int i=1;i<=N;i++) {
			parents[i] = i;
		}
		
		while(M-->0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(!union(a,b)) cnt++;
		}
		
		HashSet<Integer> hs = new HashSet<>();
		//int num = findSet(1);
		for(int i=1;i<=N;i++) {
			hs.add(findSet(i));
//			if(num!=findSet(i)) {
//			cnt++;
//			num = findSet(i);
		}
		
		System.out.println(cnt+=hs.size()-1);
		
		br.close();
	}

	public static int findSet(int a) {
		if(a==parents[a]) return a;
		return parents[a] = findSet(parents[a]);
	}
	
	public static boolean union(int a,int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot==bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
}
