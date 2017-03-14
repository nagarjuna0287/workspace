package com.saibersys.basic;

import java.util.Scanner;

public class StudentResults {

	private static Scanner sc1;

	public static void main(String[] args) {
		sc1 = new Scanner(System.in);
		
		
		System.out.println("Enter first subject name:");
		String first=sc1.nextLine();
		
		System.out.println("Enter student"+" " +first+" "+"subject marks:");
		int marks1=sc1.nextInt();
		
		System.out.println("Enter second subject name:");
		String second=sc1.nextLine();
		
		System.out.println("Enter student"+" "+second+" "+"subject marks:");
		int marks2=sc1.nextInt();
		
		System.out.println("Enter third subject name:");
		String third=sc1.nextLine();
		
		System.out.println("Enter student"+" "+third+" "+"subject marks:");
		int marks3=sc1.nextInt();
		
		int total=(marks1+marks2+marks3);
		double per=total/3;
		System.out.println("Percentage="+per);
		if(per>=90){
			System.out.println("Grade=A");
			}
			else if(per>=80&&per<90){
				System.out.println("Grade=B");
			}
				else if(per>=70&&per<80){
					System.out.println("Grade=C");
			}
				else if(per>=60&&per<70){
					System.out.println("Grade=D");
				}
				else{
					System.out.println("Fail");	
					}
					}
}
