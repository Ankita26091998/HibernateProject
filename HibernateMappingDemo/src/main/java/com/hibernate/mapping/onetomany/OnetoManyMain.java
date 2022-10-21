package com.hibernate.mapping.onetomany;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OnetoManyMain {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session ses = factory.getCurrentSession();

		Transaction transaction = null;
		try {
			Questions questions = new Questions();
			questions.setQueName("Features of java?");

			Answer answer1 = new Answer("Object Oriented");
			Answer answer2 = new Answer("Portable");
			Answer answer3 = new Answer("Free and Open-Source");
			Answer answer4 = new Answer("Interpreted");

			answer1.setQuestions(questions);
			answer2.setQuestions(questions);
			answer3.setQuestions(questions);
			answer4.setQuestions(questions);

			ArrayList<Answer> list = new ArrayList<Answer>();
			list.add(answer1);
			list.add(answer2);
			list.add(answer3);
			list.add(answer4);

			questions.setAnsList(list);

			ses = factory.openSession();
			transaction = ses.beginTransaction();
			ses.save(questions);
			ses.save(answer1);
			ses.save(answer2);
			ses.save(answer3);
			ses.save(answer4);

			transaction.commit();

		} catch (Exception e) {

			System.out.println(e);
		}
	}
}
