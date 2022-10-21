package com.hibernate.onetomany;

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

//		Question q2 = new Question();
//		q2.setQuestion("What is Java?");
//
//		Answer a2 = new Answer();
//		a2.setAnswer("Java is Programming language.");
//		a2.setQue(q2);
//
//		Answer a1 = new Answer();
//		a1.setAnswer("It's secure in nature.");
//		a1.setQue(q2);
//
//		Answer a3 = new Answer();
//		a3.setAnswer("It's interpreted in nature.");
//		a3.setQue(q2);
//
//		List<Answer> answerList = new ArrayList<Answer>();
//		answerList.add(a1);
//		answerList.add(a2);
//		answerList.add(a3);
//
//		q2.setAnswerList(answerList);
//
//		ses.save(a1);
//		ses.save(a2);
//		ses.save(a3);
//		ses.save(q2);

		Question que = ses.get(Question.class, 1);
		System.out.println(que.getQuestion());

		for (Answer a : que.getAnswerList()) {
			System.out.println(a.getAnswer());

		}

		tx.commit();
		ses.close();
	}

}
