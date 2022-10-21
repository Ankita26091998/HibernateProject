package com.hibernate;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HQLdemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session ses = factory.openSession();

		// hql syntax
//		String qq = "from Student where city='Banglore'";
		// or
//		String qq = "from Student where city=:x";
//
//		Query q = ses.createQuery(qq);
//		q.setParameter("x", "Banglore");
//		List<Student> list = q.list();
//		for (Student student : list) {
//			System.out.println(
//					student.getName() + " " + student.getCerti().getCourse() + " " + student.getCerti().getDuration());
//		}

//		System.out.println("---------------------------");
		Transaction tx = ses.beginTransaction();
//		Query q2 = ses.createQuery("delete from Student where city=:c");
//		q2.setParameter("c", "Hyderabad");
//
//		int r = q2.executeUpdate();
//		System.out.println("deleted:");
//		System.out.println(r);

//		Query q3 = ses.createQuery("update Student set city=:c where name=:n");
//		q3.setParameter("c", "Hyderabad");
//		q3.setParameter("n", "Shreyash Sharma ");
//		int r1 = q3.executeUpdate();
//		System.out.println(r1 + " updated");

//		how to execute join query
		Query q4 = ses
				.createQuery("select q.question,q.questionId,a.answer from Question as q INNER JOIN q.answer as a");
		List<Object[]> list4 = q4.getResultList();
		for (Object[] objects : list4) {
			System.out.println(Arrays.toString(objects));
		}

		tx.commit();
		ses.close();

		factory.close();
	}

}
