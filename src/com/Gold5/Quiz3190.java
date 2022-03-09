package com.Gold5;

import java.io.*;
import java.util.*;

public class Quiz3190 {

	
	public static void main(String[] args) throws Exception{
		// 뱀
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		//이동방향
		//이동
		//꼬리체크
		//사과 유무
		
		//보드의 크기
		int N = Integer.parseInt(br.readLine());
		LinkedList<int[]> snake = new LinkedList<int[]>();
		snake.add(new int[] {1,1});
		
		//사과의 개수
		int K = Integer.parseInt(br.readLine());
		ArrayList<int[]> apple = new ArrayList<int[]>();
		
		while(K-->0) {
			st = new StringTokenizer(br.readLine());
			int[] temp = new int[2];
			temp[0] = Integer.parseInt(st.nextToken());
			temp[1] = Integer.parseInt(st.nextToken());
			
			apple.add(temp);
		}
		
		//뱀의 방향 변환 정보
		int L = Integer.parseInt(br.readLine());
		char[] order = new char[10001];
		
		while(L-->0) {
			st = new StringTokenizer(br.readLine());
			
			order[Integer.parseInt(st.nextToken())] = st.nextToken().charAt(0);
		}
		
		int cnt=0;
		int dir=0;
		
		int[] dr = {0,1,0,-1}; //우하좌상
		int[] dc = {1,0,-1,0};
		
		loop:
		while(true) {
			cnt++;
			
			if(order[cnt-1]=='D') {
				if(dir==3) dir=0;
				else dir++;
			}else if(order[cnt-1]=='L') {
				if(dir==0) dir=3;
				else dir--;
			}
			
			boolean isEat = false;
			
			if(dir==0) {
				int[] temp = snake.peek().clone();
				temp[0] += dr[0];
				temp[1] += dc[0];
				
				if(temp[0]>=1&&temp[0]<=N&&temp[1]>=1&&temp[1]<=N) {
					
					//System.out.println(temp[0]); 1
					//System.out.println(temp[1]); 2 1+dc
					
					//꼬리체크
					for(int i=0;i<snake.size();i++) {
						int[] arr = snake.get(i).clone();
						
						//System.out.println(arr[0]); 1
						//System.out.println(arr[1]); 1 2? 깊은복사하자
						
						if(arr[0]==temp[0]&&arr[1]==temp[1]) {
							break loop;
						}
					}
					
					
					//사과를 먹자
					for(int i=0;i<apple.size();i++) {
						int[] eat = apple.get(i).clone();
						if(temp[0]==eat[0]&&temp[1]==eat[1]) {
							apple.remove(i);
							snake.addFirst(temp);
							isEat = true;
							break;
						}
					}
					//사과가 없다
					if(!isEat) {
						snake.pollLast();
						snake.addFirst(temp);
					}
					
				}else break;
				
			}else if(dir==1) {
				int[] temp = snake.peek().clone();
				temp[0] += dr[1];
				temp[1] += dc[1];
				
				if(temp[0]>=1&&temp[0]<=N&&temp[1]>=1&&temp[1]<=N) {
					
					//꼬리체크
					for(int i=0;i<snake.size();i++) {
						int[] arr = snake.get(i);
						
						if(arr[0]==temp[0]&&arr[1]==temp[1]) {
							break loop;
						}
					}
					
					//사과를 먹자
					for(int i=0;i<apple.size();i++) {
						int[] eat = apple.get(i);
						if(temp[0]==eat[0]&&temp[1]==eat[1]) {
							apple.remove(i);
							snake.addFirst(temp);
							isEat = true;
							break;
						}
					}
					//사과가 없다
					if(!isEat) {
						snake.pollLast();
						snake.addFirst(temp);
					}
					
				}else break;
				
			}else if(dir==2) {
				int[] temp = snake.peek().clone();
				temp[0] += dr[2];
				temp[1] += dc[2];
				
				if(temp[0]>=1&&temp[0]<=N&&temp[1]>=1&&temp[1]<=N) {
					
					//꼬리체크
					for(int i=0;i<snake.size();i++) {
						int[] arr = snake.get(i);
						
						if(arr[0]==temp[0]&&arr[1]==temp[1]) {
							break loop;
						}
					}
					
					//사과를 먹자
					for(int i=0;i<apple.size();i++) {
						int[] eat = apple.get(i);
						if(temp[0]==eat[0]&&temp[1]==eat[1]) {
							apple.remove(i);
							snake.addFirst(temp);
							isEat = true;
							break;
						}
					}
					//사과가 없다
					if(!isEat) {
						snake.pollLast();
						snake.addFirst(temp);
					}
					
				}else break;
			}else if(dir==3) {
				int[] temp = snake.peek();
				temp[0] += dr[3];
				temp[1] += dc[3];
				
				if(temp[0]>=1&&temp[0]<=N&&temp[1]>=1&&temp[1]<=N) {
					
					//꼬리체크
					for(int i=0;i<snake.size();i++) {
						int[] arr = snake.get(i);
						
						if(arr[0]==temp[0]&&arr[1]==temp[1]) {
							break loop;
						}
					}
					
					//사과를 먹자
					for(int i=0;i<apple.size();i++) {
						int[] eat = apple.get(i);
						if(temp[0]==eat[0]&&temp[1]==eat[1]) {
							apple.remove(i);
							snake.addFirst(temp);
							isEat = true;
							break;
						}
					}
					//사과가 없다
					if(!isEat) {
						snake.pollLast();
						snake.addFirst(temp);
					}
					
				}else break;
			}
			
		}
		
		sb.append(cnt);
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}

}
