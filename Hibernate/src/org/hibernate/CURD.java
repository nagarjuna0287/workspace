package org.hibernate;

import org.hibernate.cfg.AnnotationConfiguration;

public class CURD{

	public static void main(String[] args) {
		
		Session session=new AnnotationConfiguration().configure().buildSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		Employee e=new Employee();
		session.load(e, 5);
		
		//To Retrive Specific Record
		 System.out.print(e.getId()+" ");
		System.out.print(e.getEname()+" ");
		System.out.println(e.getEsalary());
		System.out.println("Record Retrived successfully");
		
		//To Update Record
		  /*e.setEsalary(95000);
		session.update(e);
		System.out.println("Record  updated successfully");
		*/
		//To Delete Record
		/*session.delete(e);
		System.out.println("Record deleted successfully");
		*/
		tx.commit();
		session.close();
		
	}

}
