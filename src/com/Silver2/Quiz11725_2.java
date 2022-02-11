package com.Silver2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Quiz11725_2 {
	/*static int count = -1;
    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {1, -1, 2, -2, 2, -2, 1, -1};*/
    //static boolean visited[];
    static int n;
    //static int graph[][];
    static ArrayList<ArrayList<Integer>> queue;
    static int list[];

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String num = br.readLine();
        n = Integer.parseInt(num);
        list = new int[n+1];
        queue = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            ArrayList<Integer> tmp = new ArrayList<>();
            queue.add(tmp);
        }

        for (int i = 0; i < n - 1; i++) {
            String[] tmp = br.readLine().split(" ");
            int a = Integer.parseInt(tmp[0]);
            int b = Integer.parseInt(tmp[1]);
            queue.get(a).add(b);
            queue.get(b).add(a);
        }

        dfs(1);

        for (int i = 2;i<list.length;i++)
            bw.write(list[i] + "\n");


        br.close();
        bw.close();
    }

    private static void dfs(int start) {
        for (int i = 0; i < queue.get(start).size(); i++) {
            int index = queue.get(start).get(i);
            if (list[index] == 0) {
                list[index] = start;
                dfs(index);
            }
        }
    }

}
