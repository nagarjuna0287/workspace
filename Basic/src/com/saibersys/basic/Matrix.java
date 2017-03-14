package com.saibersys.basic;

public class Matrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][]ab= new int[2][2];
		for( int i=0;i<ab.length;i++){
			for(int j=0;j<ab.length;j++){
				ab[i][j]=i+j;
				
			}
		}
		for(int i=0;i<ab.length;i++){
			for(int j=0;j<ab.length;j++){
				System.out.print(ab[i][j]+ "\t");
				
			}
			System.out.println("");
		}
	
	}

}
