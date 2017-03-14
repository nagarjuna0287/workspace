package com.saibersys.basic;

import java.util.Scanner;

public class ReverseWords {

	public static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		System.out.println("Enter Statement:");
		String word=sc.nextLine();
		System.out.println("Enter the position of the word to reverse:");
		int position=sc.nextInt();
		String reverse=" ";
		int l=word.length();
		for(int i=l-1;i>=0;i--){
			reverse=reverse+word.charAt(i);
				}
		char c=' ';
		int spaces=0;
		//int count=1;
		int cha=0;
		String rev=" ";
			for(int j=0;j<l;j++){
			char ch=word.charAt(j);
			if(ch!=c){
				cha=cha+1;				
				}
			if(ch==c){
				//count=count+1;
				spaces=spaces+1;
				
				if(spaces==position){
					int sp=(spaces-1);
					int sum=cha+sp;
					for(int k=sum;k>=0;k--){
					rev=rev+word.charAt(k);	
					if(word.charAt(k)==' '){
						break;
					}
					}
					break;
				}
				
					
				}
			}
			//System.out.println("NO.of words are:"+count);
			System.out.println("No.of characters are:"+cha);
			System.out.println("No.of spaces are:"+spaces);
		System.out.println("Reversed String is:"+reverse);
		System.out.println("final output is"+rev);
	
	}
}