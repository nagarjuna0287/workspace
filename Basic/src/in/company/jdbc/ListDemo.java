package in.company.jdbc;

import java.util.LinkedList;
import java.util.Stack;
import java.util.Vector;

import java.util.Iterator;

public class ListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> li=new LinkedList<Integer>();
		Vector<String> v=new Vector<String>();
		Stack<String> s=new Stack<String>();
		li.add(123);
		li.add(456);
		v.add("Sachin");
		v.add("dhoni");
		s.push("virat");
		s.push("rohit");
		System.out.println(s.peek());
		System.out.println(s);
		System.out.println(li);
		System.out.println(v);
		Iterator it=s.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
			
		}
	}

}
