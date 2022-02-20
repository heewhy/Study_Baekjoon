package com.Silver1;

import java.io.*;
import java.util.*;

public class Quiz2527 {

	public static void main(String[] args) throws Exception{
		// 직사각형
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for(int tc=1;tc<=4;tc++) {
			st = new StringTokenizer(br.readLine());
			//첫번째 사각형
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			
			//두번째 사각형
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			int q2 = Integer.parseInt(st.nextToken());
			
			//겹치지 않을 경우
			if((x>p2)||(x2>p)||(y>q2)||(q<y2)) {
				sb.append('d'+"\n");
			}
			//점 점찢기
			else if((x==p2||x2==p)&&(y==q2)||(q==y2)) {
				sb.append('c'+"\n");
			}
			//선분
			else if((x==p2||x2==p)||(y==q2)||(q==y2)) {
				sb.append('b'+"\n");
			}
			//겹침
			else {
				sb.append('a'+"\n");
			}
		}
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();

	}
}

/*
for(int tc=1;tc<=4;tc++) {
			st = new StringTokenizer(br.readLine());

			int[][] map = new int[1000][1000];
			boolean check=true;
			int cnt=0;
			
			//첫번째 사각형
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			
			for(int i=x;i<p;i++) {
				for(int j=y;j<q;j++) {
					map[i][j]++;
				}
			}
			
			//첫번째 사각형
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			int q2 = Integer.parseInt(st.nextToken());
			
			for(int i=x2;i<p2;i++) {
				for(int j=y2;j<q2;j++) {
					map[i][j]++;
				}
			}
			
			loop:
			for(int i=0;i<map.length;i++) {
				for(int j=0;j<map[i].length;j++) {
					if(map[i][j]==2) {
						cnt++;
					}
					
					if(i>=x&&i<p&&j>=y&&j<q&&map[i][j]==2) {
						check=false;
						if(i+1<50001&&map[i+1][j]==2) {
							sb.append('a'+"\n");
							break loop;
						}else if(j+1<50001&&map[i][j+1]==2){
							sb.append('b'+"\n");
							break loop;
						}
					}
				}
			}
			if(check) {
				if(cnt==0) {
					sb.append('d'+"\n");
				}else if(cnt==1) {
					sb.append('c'+"\n");
				}
			}
		}
*/

/*
import java.util.*;
import java.io.*;

public class Main {
	
	public static char isRectangle (int minX, int minY, int maxX, int maxY, int width1, int height1, int width2, int height2) {
		if (((width1+width2 == maxX-minX) && (height1+height2 > maxY-minY)) || ((height1+height2 == maxY-minY) && (width1+width2 > maxX-minX)))
			return 'b';
		else if ((width1+width2 == maxX-minX) && (height1+height2 == maxY-minY)) // 점이 겹치는 경우
			return 'c';
		else if ((width1+width2 < maxX-minX) || (height1+height2 < maxY-minY)) // 공통부분이 없는 경우
			return 'd';
		else
			return 'a';
	}


	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 0; t < 4; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int p1 = Integer.parseInt(st.nextToken());
			int q1 = Integer.parseInt(st.nextToken());
			
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			int q2 = Integer.parseInt(st.nextToken());
			
			
			int minX = Math.min(x1, x2); // 입력받은 x좌표의 최솟값
			int maxX = Math.max(p1, p2); // 입력받은 x좌표의 최댓값
			int minY = Math.min(y1, y2); // 입력받은 y좌표의 최솟값
			int maxY = Math.max(q1, q2); // 입력받은 y좌표의 최댓값
			
			int width1 = p1 - x1; // 첫번째 직사각형의 가로 길이
			int height1 = q1 - y1; // 첫번째 직사각형의 세로 길이
			int width2 = p2 - x2; // 두번째 직사각형의 가로 길이
			int height2 = q2 - y2; // 두번째 직사각형의 세로 길이
			
			System.out.println(isRectangle(minX, minY, maxX, maxY, width1, height1, width2, height2));
		}
	}
} 
 
 */
