package com.hibernate.mapping.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OnetoOneMain {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session ses = factory.getCurrentSession();

		Transaction transaction = null;
		try {
			Answer answer = new Answer();
			answer.setAnsId(2);
			answer.setAnsName("Hyper Text Markup Language");

			Questions questions = new Questions();
			questions.setQueId(2);
			questions.setQueName("What is the full form of HTML?");
			questions.setAnswer(answer);
			answer.setQuestions(questions);

			ses = factory.openSession();
			transaction = ses.beginTransaction();
			ses.save(questions);
			ses.save(answer);
			transaction.commit();

		} catch (Exception e) {

			System.out.println(e);
		}
	}
}
