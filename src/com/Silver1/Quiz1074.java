package com.Silver1;

import java.io.*;
import java.util.*;

public class Quiz1074 {
	
	//static int cnt=0;
	static int row,col;

	public static void main(String[] args) throws Exception{
		// Z
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		
		//배열의 크기 2^N
		int size = 1<<N;
		int cnt=0;
		
		//find(size,row,col);
		find2(0,0,size,0);
		
		//sb.append(cnt);
		//bw.write(sb.toString());
		
		br.close();
		//bw.flush();
		//bw.close();
	}
	
	/**
	 * @param 시작 row 값
	 * @param 시작 c 값
	 * @param 변의길이
	 * @param 지나온 횟수
	 * */
	public static void find2(int si, int sj, int length, int cnt){ 
        if(length==2){
            for (int i = si; i <= si+1; i++) {
                for (int j = sj; j <= sj+1; j++) {
                    if(i==row && j==col){
                        System.out.println(cnt);
                        System.exit(0);
                        return;
                    }
                    cnt++;
                }
            }
            return;
        }

        int half = length/2;

        // si, sj, half, cnt
        // si, sj+half, half, half*half*2
        // si+half, sj, half, half*half
        // si+half, sj+half, half, half*half*3

        if(si<=row && row<si+half && sj<=col && col<sj+half){
            find2(si, sj, half, cnt);
        }else if(si<=row && row<si+half && sj+half<=col && col<sj+length){
            find2(si, sj+half, half, cnt+half*half);
        }else if(si+half<=row && row<si+length && sj<=col && col<sj+half){
            find2(si+half, sj, half, cnt+half*half*2);
        }else{
            find2(si+half, sj+half, half, cnt+half*half*3);
        }
    }
}


	/**
	 * find //메모리 초과
	 * @param 한 변의 크기
	 * @param 찾는 행
	 * @param 찾는 열
	 * */
//	private static void find(int size, int row, int col) {
//		if(size == 1)
//			return;
//		//좌상
//		if(row < size/2 && col < size/2) {
//			find(size/2, row, col);
//		}//우상
//		else if(row < size/2 && col >= size/2) {
//			//좌상 방문 값 더해주기
//			cnt += size * size / 4;
//			find(size/2, row, col - size/2);
//		}//좌하
//		else if(row >= size/2 && col < size/2) {
//			//좌상 우상 사분면을 방문 값 더해주기
//			cnt += (size * size / 4) * 2;
//			find(size/2, row - size/2, col);
//		}//우하
//		else {
//			//좌상 우상 좌하 사분면을 방문 값 더해주기
//			cnt += (size * size / 4) * 3;
//			find(size/2, row - size/2, col - size/2);
//		}
//	}
//
//}


/*
public class Main_BJ_1074_Z_이길상 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = 1<<sc.nextInt(), R = sc.nextInt(), C = sc.nextInt();
		int result = 0;
		while ((N/=2) > 0) {
			result += (N*N)*(2*(R/N) + C/N);
			R %= N;
			C %= N;
		}
		System.out.println(result);
	}
}
 * */
