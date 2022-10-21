package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDataDemo {

	public static void main(String[] args) {
		System.out.println("Project Started!");
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

//		Student st = session.load(Student.class, 1);
//		Student st1 = session.load(Student.class, 1);
		Address address = session.get(Address.class, 1);
		Address address1 = session.get(Address.class, 2);

//		System.out.println(st);
		System.out.println(address);
		System.out.println(address1);

		session.clear();
		factory.close();

	}

}
