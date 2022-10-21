package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateObjectStatesDemo {

	public static void main(String[] args) {

		// practical of hibernate object states:
		// transient
		// Persistent
		// Detached
		// Removed
		System.out.println("Object States");

		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		// Transient state: not associate with db or session
		Student s = new Student();
		s.setId(12);
		s.setName("Ankita");
		s.setCity("Hyderabad");
		s.setCerti(new Certificate("Java", "2 months"));

		Session ses = sf.openSession();
		Transaction tx = ses.beginTransaction();
		// Persistent state: now it's associate with both session and database
		ses.save(s);
		s.setName("John");
		tx.commit();

		ses.close();
		// Detached State:no change in db, detach from session
		s.setName("Ankita");

		sf.close();
	}

}
