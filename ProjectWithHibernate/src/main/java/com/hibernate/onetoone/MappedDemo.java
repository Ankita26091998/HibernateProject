package com.hibernate.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappedDemo {

	public static void main(String[] args) {
		System.out.println("Project Started!");
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session ses = factory.openSession();
		Transaction tx = ses.beginTransaction();

		Question q1 = new Question();
		q1.setQuestion("What is Python?");

		Answer a1 = new Answer();
		a1.setAnswer("Python is Programming language.");
		a1.setQue(q1);

		Question q2 = new Question();
		q2.setQuestion("What is Java?");

		Answer a2 = new Answer();
		a2.setAnswer("Java is Programming language.");
		a2.setQue(q2);

		q1.setAnswer(a1);
		q2.setAnswer(a2);

		ses.save(a1);
		ses.save(q1);
		ses.save(a2);
		ses.save(q2);
		tx.commit();

		// getting data from table

		Question que = ses.get(Question.class, 1);
		System.out.println(que.getQuestion());
		System.out.println(que.getAnswer().getAnswer());

		ses.close();
	}

}
