package com.Silver2;

import java.io.*;
import java.util.*;

public class Quiz2304 {

	public static void main(String[] args) throws Exception{
		// 창고 다각형
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		//기둥 개수 입력받기
		int N = Integer.parseInt(br.readLine());
		//기둥 정보를 담아 둘 공간
		ArrayList<top> arr = new ArrayList<>();
		//면적
		int ans=0;
		
		//기둥 정보 입력받기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr.add(new top(x, y));
		}
		
		//정렬
		Collections.sort(arr);
		
		int maxX=0;

		//오른쪽에서 왼쪽으로
		top currenttop=arr.get(0);
		for (int i = 1; i < N; i++) {
			if(currenttop.y <= arr.get(i).y) {
				ans += (arr.get(i).x - currenttop.x) * currenttop.y;
				currenttop = arr.get(i);
				maxX = i;
			}
		}
		
		//왼쪽에서 오른쪽으로
		currenttop = arr.get(N-1);
		for (int i = 0; i < N-maxX; i++) {
			if(currenttop.y <= arr.get(N-i-1).y) {
				ans += (currenttop.x - arr.get(N-i-1).x ) * currenttop.y;
				currenttop = arr.get(N-i-1);
			}
		}
		ans += currenttop.y;
		
		sb.append(ans);
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
	
	static class top implements Comparable<top> {
		int x;
		int y;

		public top(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(top o) {
			return this.x - o.x;
		}

	}

}
