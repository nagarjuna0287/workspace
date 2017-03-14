package com.saibersys.basic;

 class InheritanceDemo {
	int a=10;
	int b=25,c;
	public void add(){
		c=a+b;
		System.out.println(c);
	}

}
public class Inheritance extends InheritanceDemo{

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Inheritance id=new Inheritance();
			id.add();
		
	}
}