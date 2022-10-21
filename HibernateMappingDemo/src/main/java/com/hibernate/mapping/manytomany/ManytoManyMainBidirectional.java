package com.hibernate.mapping.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManytoManyMainBidirectional {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session ses;
		ses = factory.openSession();
		Transaction t = ses.beginTransaction();
		try {
			Employee e1 = new Employee("Pooja Shinde");
			Employee e2 = new Employee("Ankita Khandekar");
			Employee e3 = new Employee("Apoorva Pande");

			Department d1 = new Department("DevOps and Cloud");
			d1.getEmployeeList().add(e1);
			d1.getEmployeeList().add(e2);
			d1.getEmployeeList().add(e3);

			Employee e4 = new Employee("Ketki Shinde");
			Employee e5 = new Employee("Suyasha Mehta");
			Employee e6 = new Employee("Arpita Deshmukh");

			Department d2 = new Department("Core Development");
			d2.getEmployeeList().add(e1);
			d2.getEmployeeList().add(e4);
			d2.getEmployeeList().add(e5);
			d2.getEmployeeList().add(e6);

			ses.save(d1);
			ses.save(d2);

//			System.out.println(d1.getDeptId() + " : " + d1.getDeptName());
//			System.out.println(d2.getDeptId() + " : " + d2.getDeptName());

			t.commit();

			ses.close();
			System.out.println("success");

		} catch (Exception e) {

			System.out.println(e);
		}
	}
}
