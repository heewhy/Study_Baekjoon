package com.Bronze2;

public class Quiz15596{
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4};
		System.out.println(Test(arr));
	}
	
	 public static long Test(int[] a){
		long sum = 0;
		
		for(int i=0;i<a.length;i++) {
			sum+=a[i];
		}
		return sum;
	}

}
