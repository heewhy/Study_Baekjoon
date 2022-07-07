package com.Gold4;

import java.io.*;
import java.util.*;

public class Quiz21940 {

	public static void main(String[] args) throws Exception{
		// 가운데에서 만나기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //도시의 개수
		int M = Integer.parseInt(st.nextToken()); //도로의 개수
		int INF = 10001;
		
		int[][] dist = new int[N+1][N+1];
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				dist[i][j] = INF;
			}
			dist[i][i]=0;
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			
			dist[start][end] = time;
		}
		
		int K = Integer.parseInt(br.readLine()); //총인원
		int[] city = new int[K];
		st = new StringTokenizer(br.readLine());
		//살고있는 도시정보 저장
		for(int i=0;i<K;i++) {
			city[i] = Integer.parseInt(st.nextToken());
		}
		
		//경유지->출발지->도착지
		for(int k=1;k<=N;k++) {
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					if(dist[i][j] > dist[i][k]+dist[k][j]) dist[i][j] = dist[i][k]+dist[k][j];
				}
			}
		}
		
		//각 도시에서 왕복거리 구하기
		int[] max = new int[N+1];
		int min = Integer.MAX_VALUE;
		for(int i=1;i<=N;i++) {
			for(int j=0;j<K;j++) {
				//자신이 살고 있는 도시에서 도시 X로 이동하는 시간과 도시 X에서 다시 자신이 살고 있는 도시로 이동하는 시간을 합한 것
				max[i] = Math.max(max[i], dist[city[j]][i]+dist[i][city[j]]);
			}
			min = Math.min(min,max[i]);
		}
		
		//최대가 최소가 되는 거리
		ArrayList<Integer> result = new ArrayList<>();
        for(int i=1;i<=N;i++) {
            if(min == max[i]) result.add(i);
        }
        Collections.sort(result);
 
        for(int ans : result) {
            System.out.print(ans+" ");
        }
		
		br.close();
	}

}
