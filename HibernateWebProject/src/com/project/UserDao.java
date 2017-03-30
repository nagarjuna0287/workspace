package com.project;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class UserDao {
	
	public static int register(User u){  
		 int i=0;  

			Session session=new AnnotationConfiguration().configure().buildSessionFactory().openSession();
			Transaction tx=session.beginTransaction();
			//tx.begin();
			
			i=(Integer)session.save(u);
			tx.commit();
			session.close();
			System.out.println("Record successfully saved");
			return i;

}
}