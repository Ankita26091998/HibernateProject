package com.hibernate;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) throws IOException {
		System.out.println("Project Started!");
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
//		Student s1 = new Student(3, "Amrutha Pandit", "Mumbai");
//		System.out.println(s1);

		Address ad = new Address();
		ad.setStreet("Madhapur");
		ad.setCity("Hyderabad");
		ad.setOpen(true);
		ad.setDate(new Date());
		ad.setX(12.5);

		// reading image
		FileInputStream fis = new FileInputStream("src/main/java/quiz.png");
		byte[] data = new byte[fis.available()];
		fis.read(data);
		ad.setImage(data);

		Session session = factory.getCurrentSession();

		session.beginTransaction();
//		session.save(s1);
		session.save(ad);

		session.getTransaction().commit();
		session.close();

	}
}
