package com.Silver5;

import java.util.Scanner;

public class Quiz17478 {
	
	public static int cnt;
	public static void repeat(int n) {
		if(n==0) {
			print();
			System.out.println("\"재귀함수가 뭔가요?\"");
			print();
			System.out.println("\"재귀함수는 자기 자신을 호출하는 함수라네\"");
			print();
			System.out.println("라고 답변하였지.");
			cnt--;
			return;
		}
		print();
		System.out.println("\"재귀함수가 뭔가요?\"");
		print();
		System.out.println("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
		print();
		System.out.println("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
		print();
		System.out.println("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
		cnt++;
		repeat(n-1);
		print();
		cnt--;
		System.out.println("라고 답변하였지.");
	}
	
	public static void print() {
		for(int i=0;i<cnt;i++) {
			System.out.print("____");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		
		repeat(n);
	
		
		
	}

}
/*
 * package com.ssafy.d0203;

import java.util.Scanner;

public class Main_BJ_17478_재귀함수가_뭔가요_김주은 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		recursive("",N);
		
	}
	
	public static void recursive(String s,int N) {
		
		String s1 = s+"\"재귀함수가 뭔가요?\"";
		String s2 = s+"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n"
				+ s + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n"
				+ s + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
		String s3 = s+"라고 답변하였지.";
		String s4 = s+"\"재귀함수는 자기 자신을 호출하는 함수라네\"";
		
		if(N<0) return;
		
		System.out.println(s1);
		if(N!=0) System.out.println(s2);
		else System.out.println(s4);
		recursive(s+"____", N-1);
		System.out.println(s3);
	}

}

 * */