package in.company.jdbc;

import java.util.ArrayList;

public class ArrayListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList al= new ArrayList();
			//al.add(new Integer(10));
			//al.add(new Integer(20));
			al.add(30);
			al.add(40);
			al.add("nagarjuna");
			al.add(true);
			al.add(null);
			
			
			al.set(1,al.get(1));
			System.out.println(al);
			System.out.println(al.size());
			System.out.println(al.contains(30));
	}

}
