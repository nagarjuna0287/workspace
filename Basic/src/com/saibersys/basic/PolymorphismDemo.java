package com.saibersys.basic;

class Polymorphism{
	
	int add(int x,int y){
		int z=x+y;
		return z;
	}
	int add(int x,int y,int z){
		int s=x+y+z;
		return s;
	}
	double add(double a ,double b,double d){
		double c=a+b+d;
		return c;
	}	
}

class PolymorphismDemo extends Polymorphism{
	public static void main(String arg[]){
		PolymorphismDemo po=new PolymorphismDemo();
		int s1=po.add(2,3);
		double s2=po.add(7.4, 8.8, 5.5);
		int s3=po.add(10,20,30);
	
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		}
	int add(int a,int b, int c){
		int d=a+b+c;
		System.out.println("overridded method");
		return d;
	}
}
