package org.hibernate;

import org.hibernate.cfg.AnnotationConfiguration;

public class StoreEmpDetails {

	public static void main(String[] args) {
		
		Session session=new AnnotationConfiguration().configure().buildSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		Employee e=new Employee();
		e.setId(5);
		e.setEname("James");
		e.setEsalary(79000);
		
		session.persist(e);
		tx.commit();
		session.close();
		System.out.println("Record successfully saved");

	}

}
