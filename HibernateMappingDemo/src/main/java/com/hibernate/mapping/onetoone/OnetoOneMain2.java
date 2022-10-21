package com.hibernate.mapping.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OnetoOneMain2 {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session ses = factory.getCurrentSession();

		Transaction transaction = null;
		try {
			Trainer trainer = new Trainer();
			trainer.setTrainerId(11);
			trainer.setTrainerName("Pooja Mehta");
			Student student = new Student();
			student.setStudId(101);
			student.setStudName("Ankita Khandekar");
			student.setTrainer(trainer);
			trainer.setStudent(student);
			ses = factory.openSession();
			transaction = ses.beginTransaction();
			ses.save(student);
			ses.save(trainer);
			transaction.commit();

		} catch (Exception e) {

			System.out.println(e);
		}
	}
}
