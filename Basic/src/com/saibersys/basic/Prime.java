package com.saibersys.basic;

public class Prime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i,j,k;
		for(i=1;i<=100;i++){
			k=0;
			for(j=1;j<=i;j++){
		if(i%j==0){
		k=k+1;	
			}
		}
			if(k==2){
			System.out.println(i);	
			}
			}
		}

}
