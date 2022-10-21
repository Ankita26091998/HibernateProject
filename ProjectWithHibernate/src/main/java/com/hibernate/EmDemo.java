package com.hibernate;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmDemo {
	public static void main(String[] args) throws IOException {
		System.out.println("Project Started!");
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Student s1 = new Student();
		s1.setId(11);
		s1.setName("Shreyash Sharma");
		s1.setCity("Banglore");

		Certificate c1 = new Certificate();
		c1.setCourse("Java FullStack Development");
		c1.setDuration("5 Months");

		s1.setCerti(c1);

		Session session = factory.openSession();
		session.beginTransaction();

		session.save(s1);

		session.getTransaction().commit();
		session.close();

	}
}
