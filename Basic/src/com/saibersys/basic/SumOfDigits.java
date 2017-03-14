package com.saibersys.basic;

public class SumOfDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=8999;
		int j,k;
		int sum=0;
		k=i;
		for(int n=0;n<=i;n++){
			if(k!=0){
				j=k%10;
				sum=sum+j;
				k=k/10;
			}
		}
		System.out.println("sum="+sum);
	}

}
