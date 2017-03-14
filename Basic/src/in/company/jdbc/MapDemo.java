package in.company.jdbc;

import java.util.*;

public class MapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Hashtable ht=new Hashtable();
		HashMap hm=new HashMap();
		LinkedHashMap lhm=new LinkedHashMap();
		TreeMap tm=new TreeMap();
		ht.put(101, "abc");
		ht.put(102, "xyz");
		tm.put(104,"java");
		tm.put(105, "oracle");
			Set s=ht.keySet();
			Iterator it=s.iterator();
			while(it.hasNext()){
				System.out.println(it.next());
			}
			Collection c=ht.values();
			it=c.iterator();
			while(it.hasNext()){
				System.out.println(it.next());
				
			}
	}
	
}