package com.Silver4;

import java.io.*;
import java.util.*;

public class Quiz1920 {
	
	public static int[] arr;

	public static void main(String[] args) throws Exception{
		// 수 찾기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb= new StringBuilder();
		StringTokenizer st;
		
		
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		// 배열은 반드시 정렬되어있어야한다.
		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < M; i++) {
			
			// 찾고자 하는 값이 있을 경우 1, 없을 경우 0을 출력해야한다.
			if(binarySearch(Integer.parseInt(st.nextToken())) >= 0) {
				sb.append(1).append('\n');
			}
			else {
				sb.append(0).append('\n');
			}
		}
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}

	/**
	 * 
	 * @param key 찾으려는 값
	 * @return key와 일치하는 배열의 인덱스
	 */
	private static int binarySearch(int key) {
		int lo = 0;					// 탐색 범위의 왼쪽 끝 인덱스
		int hi = arr.length - 1;	// 탐색 범위의 오른쪽 끝 인덱스
 
		// lo가 hi보다 커지기 전까지 반복한다.
		while(lo <= hi) {
 
			int mid = (lo + hi) / 2;	// 중간위치를 구한다.
 
			// key값이 중간 위치의 값보다 작을 경우
			if(key < arr[mid]) {
				hi = mid - 1;
			}
			// key값이 중간 위치의 값보다 클 경우
			else if(key > arr[mid]) {
				lo = mid + 1;
			}
			// key값과 중간 위치의 값이 같을 경우
			else {
				return mid;
			}
		}
 
		// 찾고자 하는 값이 존재하지 않을 경우
		return -1;
	}

}

/*		시간초과
		int N = Integer.parseInt(br.readLine());
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		st = new StringTokenizer(br.readLine());
		while(N-->0) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		int M = Integer.parseInt(br.readLine());
		
		st= new StringTokenizer(br.readLine());
		while(M-->0) {
			if(list.contains(Integer.parseInt(st.nextToken()))) {
				sb.append(1+"\n");
			}else {
				sb.append(0+"\n");
			}
		}
*/
