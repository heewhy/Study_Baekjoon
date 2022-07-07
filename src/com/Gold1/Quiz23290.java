package com.Gold1;

import java.io.*;
import java.util.*;

public class Quiz23290 {

	public static int N = 4;
	public static int M, S;
    public static int s_r, s_c;
    public static int[][] smell;
    public static int[] dr = {0, -1, -1, -1, 0, 1, 1, 1};
    public static int[] dc = {-1, -1, 0, 1, 1, 1, 0, -1};
    public static ArrayList<ArrayList<ArrayList<Integer>>> map;
    public static ArrayList<Integer> moving_list;
    public static int max_eat;
    public static int[] s_dr = {-1, 0, 1, 0};
    public static int[] s_dc = {0, -1, 0, 1};
    public static class Fish{
        int r;
        int c;
        int dir;
        public Fish(int r, int c, int dir){
            this.r = r;
            this.c = c;
            this.dir = dir;
        }
    }
    public static void main(String[] args) throws Exception {
    	//마법사 상어와 복제
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        smell = new int[N][N];
        Queue<Fish> q_first = new LinkedList<>();

        map = new ArrayList<>();
        for(int i=0;i<N;i++){
            map.add(new ArrayList<>());
            for(int j=0;j<N;j++){
                map.get(i).add(new ArrayList<>());
            }
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            map.get(r-1).get(c-1).add(dir-1);
        }

        st = new StringTokenizer(br.readLine(), " ");
        s_r = Integer.parseInt(st.nextToken()) -1;
        s_c = Integer.parseInt(st.nextToken()) -1;

        int time = 1;
        while (time<=S){
            // 복사
            q_first.clear();
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    for(int k=0;k<map.get(i).get(j).size();k++){
                        q_first.offer(new Fish(i, j, map.get(i).get(j).get(k)));
                    }
                }
            }

            // 물고기 이동
            ArrayList<ArrayList<ArrayList<Integer>>> map_copy = new ArrayList<>();
            for(int i=0;i<N;i++){
                map_copy.add(new ArrayList<>());
                for(int j=0;j<N;j++){
                    map_copy.get(i).add(new ArrayList<>());
                }
            }

            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    for(int k=0;k<map.get(i).get(j).size();k++){
                        int first_dir =  map.get(i).get(j).get(k);
                        boolean check = true;
                        int nr = i, nc = j;

                        for(int d=0;d<8;d++){
                            int ndir = ((first_dir-d)+8) % 8;
                            nr = i + dr[ndir];
                            nc = j + dc[ndir];
                            if(!isIn(nr,nc)) continue;
                            if(smell[nr][nc] != 0 && time - smell[nr][nc] <= 2) continue;
                            if(nr == s_r && nc == s_c) continue;
                            map_copy.get(nr).get(nc).add(ndir);
                            check = false;
                            break;
                        }

                        if(check){
                            map_copy.get(i).get(j).add(first_dir);
                        }

                    }

                }
            }

            map = map_copy;

            // 상어의 이동
            max_eat = 0;
            moving_list = new ArrayList<>();
            dfs(0, new int[3]);
            Collections.sort(moving_list);
            String moving_str = String.valueOf(moving_list.get(0));
                for (int i = 0; i < 3; i++) {
                    int dir = moving_str.charAt(i) - '1';
                    s_r += s_dr[dir];
                    s_c += s_dc[dir];
                    // 죽이면서 냄새 뿌리기
                    if (map.get(s_r).get(s_c).size() > 0) {
                        map.get(s_r).get(s_c).clear();
                        smell[s_r][s_c] = time;
                    }

                }

            // 복제 마법

            while (!q_first.isEmpty()){
                Fish f = q_first.poll();
                map.get(f.r).get(f.c).add(f.dir);
            }


            time++;
        }


        // 물고기 갯수 출력
        int ans = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                ans += map.get(i).get(j).size();
            }
        }
        System.out.println(ans);
    }

    // 상어가 이동할 수 있는 3연속 방향의 중복순열을 구하는 dfs
    public static void dfs(int depth, int[] arr){
        if(depth==3){
            int[] arr_copy = new int[3];
            String str = "";
            for(int i=0;i<3;i++){
                arr_copy[i] = arr[i];
                str += String.valueOf(arr_copy[i]);
            }

            int cnt = eatCount(str);

            if(max_eat < cnt){
                moving_list.clear();
                moving_list.add(Integer.parseInt(str));
                max_eat = cnt;
            } else if (max_eat == cnt){
                moving_list.add(Integer.parseInt(str));
            }

            return;
        }
        for(int i=1;i<=N;i++){
            arr[depth] = i;
            dfs(depth+1, arr);
        }
    }

    // 해당 방향으로 3연속 이동할 때 먹을 수 있는 물고기 갯수 카운트
    public static int eatCount(String dir){
        int r = s_r;
        int c = s_c;
        int eat_cnt = 0;
        boolean[][] vistied = new boolean[N][N];

        for(int i=0;i<3;i++){
            int d = dir.charAt(i) - '1';
            r += s_dr[d];
            c += s_dc[d];
            if(!isIn(r,c)){
                return -1;
            }
            if(!vistied[r][c]) eat_cnt += map.get(r).get(c).size();
            vistied[r][c] = true;
        }
        return eat_cnt;
    }
    
    public static boolean isIn(int r, int c) {
    	return r>=0 && r<N && c>=0 && c<N;
    }
}