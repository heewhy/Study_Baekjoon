package com.Silver5;

import java.awt.datatransfer.SystemFlavorMap;
import java.io.*;
import java.util.*;

public class Quiz10814 {

	public static void main(String[] args) throws Exception{
		// 나이순 정렬
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		Person[] N = new Person[Integer.parseInt(br.readLine())];
		
		for(int i=0;i<N.length;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N[i] = new Person(Integer.parseInt(st.nextToken()),st.nextToken());
		}
		
		Arrays.sort(N, (a,b)->a.age-b.age);
		
		for(Person p : N) {
			sb.append(p.toString());
		}
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}

}

class Person{
	int age;
	String name;
	
	Person(int age,String name){
		this.age = age;
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(age).append(" ").append(name).append("\n");
		return sb.toString();
	}
	
	
}