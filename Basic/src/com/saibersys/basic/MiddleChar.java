package com.saibersys.basic;

import java.util.Scanner;

public class MiddleChar {

	public static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		System.out.println("Enter the string name:");
		String st=sc.nextLine();
		int count=st.length();
		int n1,n2,k;
		while(count!=0){
			if(count>2){
			if(count%2==0){
				n1=(count/2)-1;
				n2=n1+1;
				System.out.println("Middle characters are:"+st.charAt(n1)+" "+st.charAt(n2));
				return;
			}
			else{
				k=(count-1)/2;
				System.out.println("Middle character is:"+st.charAt(k));
				return;
			}}
			else{
				System.out.println("string must be more than 3 characters");
				return;
			}
		}
	}

}
